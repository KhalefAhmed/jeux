package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Rectangle;
import java.awt.event.*;


import javax.swing.*;

public class Jeu_vampires extends JPanel implements ActionListener, Jeu_interface  {
    // le lanceur qui va tirer les balles et tuer les vampires
        private Lanceur lanceur;
    // l'image qui va contenir l'arriere plan
	private Image arrierePlan;
    // List va contenir les vampires (ennemis) visible à un instant T
	private List<Vampire> vampires_array;
    // List va contenir les balles visible à l'écran
	private List<Balle> balles_array;
    // le JLabel qui va afficher le score dans le JPanel
        private JLabel score = new JLabel("Score : "+String.valueOf(Score.getInstance().getScore()));
    // si le lanceur a tiré une balle ou non
        protected boolean tire;
	private Balle balle;
        private Timer timer;
	

            
	
////////// Le Constructeur !  ///////////
public Jeu_vampires() {
                // mettre une arriérere plan au Jpanel
		ImageIcon bg = new ImageIcon(this.getClass().getResource("images/ESTC_bg2.png"));
                this.arrierePlan = bg.getImage();
                // initialiser le lanceur qui va lancer les balles
                this.lanceur = new Lanceur();
                // initialiser la liste des balles
		this.balles_array = new ArrayList<Balle>();
                // initialiser la liste des vampires
		this.vampires_array = new ArrayList<Vampire>();
                // mise en forme du score 
                score.setForeground(Color.WHITE);
                score.setFont(new java.awt.Font("Tw Cen MT", 1, 40));
                this.setFocusable(true);
                // ajouter le score au JLabal
                this.add(this.score);
                // initialiser le timer et le déclancher
                this.timer = new Timer(15, this);
		this.timer.start();
                // le listner est une instance de la classe Gestionnaire_Actions (classe interne dans Acceuil)
		Gestionnaire_Actions mon_gest = new Gestionnaire_Actions();
                addKeyListener(mon_gest);
                
                // thread interne pour créer et gérer le vampires spatial 
		Thread creerVampire = new Thread(new Runnable() {
			public void run() {
                        try {  Thread.sleep(2400);  }   catch (InterruptedException e) { }
                        while (true)
			try {   creerVampire();
				Thread.sleep(700);
			} catch (InterruptedException e) { }  }
		        });
		creerVampire.start();
                
                // thread interne pour gérer les tires des balles du lanceur 
		Thread Tire = new Thread(new Runnable() {
			public void run() {
			while (true)
			try {
			if (tire == true) {   tire();   }
			Thread.sleep(222);
			} catch (InterruptedException e) {}
                        }});
		Tire.start();
                
                // thread interne pour faire bouger le canon en cours du jeu
		Thread bougerLanceur = new Thread(new Runnable() {
			public void run() {
			while (true)
			try {    if (lanceur.getLeft() == true) {
			lanceur.left();}
			if (lanceur.getRight() == true) {
			lanceur.right();  }
			Thread.sleep(8);
			} catch (InterruptedException e) {}
                        }});
		bougerLanceur.start();
}




///////////    La méthode Action Performed,   ///////////////
//////////    je suis obligé de la définir puisque cette classe implémente ActionListener  //////////
	public void actionPerformed(ActionEvent arg0) {
		for (int k = 0; k < balles_array.size(); k++) {
			balles_array.get(k).move();
			if (balles_array.get(k).getY() < 1) {
                        // si la balle a quité l'écran on l'élimine
				balles_array.remove(k); } }
		for (int i = 0; i < vampires_array.size(); i++) {
			vampires_array.get(i).move();
			if (vampires_array.get(i).getY() > 600) {
                        // si le vampire a quité l'écran on l'élimine
			vampires_array.remove(i);
                        // et on retire 50 points du score
                        Score.getInstance().setScore(Score.getInstance().getScore() - 15);
                        score.setText("Score : "+String.valueOf(Score.getInstance().getScore())); 
			}}
		Thread collision = new Thread(new Runnable() {    public void run() {collision();}    });
		collision.start();
		repaint();
}


        
               
///////  La méthode paintComponent pour afficher les composants graphiques /////////////
public void paintComponent(Graphics g) {
                // afficher l'arriere plan est le lanceur
		g.drawImage(arrierePlan, 0, 0, null);
		g.drawImage(lanceur.getImage(), lanceur.getX(), lanceur.getY(), null);
                if (!vampires_array.isEmpty()) {
                // déssiner les vampires existants dans la liste à un instant T
			for (int i = 0; i < vampires_array.size(); i++) {
			g.drawImage(vampires_array.get(i).getImage(), vampires_array.get(i)
                        .getX(), vampires_array.get(i).getY(), null);
			}}
		if (!balles_array.isEmpty()) {
                 // déssiner les balles existants dans la liste à un instant T
			for (int k = 0; k < balles_array.size(); k++) {
			g.drawImage(balles_array.get(k).getImage(), balles_array
			.get(k).getX(), balles_array.get(k).getY(), null);
			}}
}




////// la méthode qui génère des vampires à emplacement aléatoire ////////////
public void creerVampire() {
		if (vampires_array.isEmpty()){
                    Random r = new Random();
                    int X = r.nextInt(730);
                    Vampire ball = new Vampire(X);
                    vampires_array.add(ball); }
                else {
                    // si on a déja au moins un vampire, on le clone ( PROTOTYPE ;) )
                    vampires_array.add(vampires_array.get(0).cloneToi());   }
}




//////// la méthode qui crée les balles ////////////////
public void tire() {
                if (balles_array.isEmpty()){
                     balle = new Balle(lanceur.getX() + 68);
                     balles_array.add(balle); }
                else {
                    // si on a déja au moins une balle, on la clone ( PROTOTYPE ;) )
                    // ici je ne peut pas enlever l'attribute qui fait reference au position
                    // actuel du canon, la clone doit savoir ou se trouve la canon
                    balles_array.add(balles_array.get(0).cloneToi(lanceur.getX() + 68));  }       	
}	


/////////// la méthode qui gére l'intersection entre les balles et les vampires  ///////////////
public void collision() {
		for (int k = 0; k < balles_array.size(); k++) {
			for (int j = 0; j < vampires_array.size(); j++) {
                        Rectangle rec1;
			// si il y a des balles visible sur l'écran :
                        if(!balles_array.isEmpty()){
                        rec1 = balles_array.get(k).getRectangle();
                        Rectangle rec2 = vampires_array.get(j).getRectangle();
			if (rec1.intersects(rec2)) {
                        // si la balle a toucher un vampire on élimine les deux
			balles_array.remove(k);
			vampires_array.remove(j);
                        // et on fait un plus 15 au score
                        Score.getInstance().setScore(Score.getInstance().getScore() + 15);
                        score.setText("Score : "+String.valueOf(Score.getInstance().getScore()));  }
			}}}
}




/////////// classe interne qui hérite de KeyAdapter et qui a pour objectif de déplacer le lanceur //////////////
private class Gestionnaire_Actions extends KeyAdapter {
	public void keyPressed(KeyEvent evenement) {
                        // afficher le lanceur
			lanceur.lanceur1();
			int code_Bouton = evenement.getKeyCode();
			if (code_Bouton == KeyEvent.VK_SPACE) {  tire = true; }
                        if (code_Bouton == KeyEvent.VK_LEFT) {  lanceur.setLeft(true);}
                        if (code_Bouton == KeyEvent.VK_RIGHT) {   lanceur.setRight(true);  }
        }
        public void keyReleased(KeyEvent evenement) {
                        // afficher le lanceur
                        lanceur.lanceur2();
                        int code_Bouton = evenement.getKeyCode();
                        if (code_Bouton == KeyEvent.VK_SPACE) {  tire = false;  }
                        if (code_Bouton == KeyEvent.VK_LEFT) {   lanceur.setLeft(false);  }
                        if (code_Bouton == KeyEvent.VK_RIGHT) {   lanceur.setRight(false); }
	}
}





// :p
}
