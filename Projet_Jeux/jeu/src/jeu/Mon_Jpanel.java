package jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mon_Jpanel extends JPanel implements ActionListener{
    JButton b1;
    JButton b2;

public Mon_Jpanel() {
        // pour pouvoir positionner les bouton librement sur le JPanel
        this.setLayout(null);
        // initialiser les 2 boutons
        b1 = new JButton("Les Extraterrestres");
        b2 = new JButton("Les Vampires");
        // les personnaliser
        b1.setBounds(190, 260, 400, 60);
        b2.setBounds(190, 390, 400, 60);
        b1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        b2.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        // le Listener est la classe elle meme, puisqu'elle implemente l'ActionListener
        b1.addActionListener(this);
        b2.addActionListener(this);
        // ajouter les 2 boutons au JPanel
        this.add(b1);
        this.add(b2);
}

@Override
////////////// j'ai redéfini cette méthode pour mettre l'image d'ESTC en arrière plan /////////////////
protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // récuperer la ressource (l'image)
        ImageIcon bg = new ImageIcon(this.getClass().getResource("images/accueil_bg1.png"));
        Image arrierePlan = bg.getImage();
        // la mettre en arriere plan
        g.drawImage(arrierePlan, 0, 0, this);
}

@Override
public void actionPerformed(ActionEvent e) {
        // si le joueur a appuyé sur "Extraterrestes"..........
        if(e.getSource() == (Object) b1){
            Jeu_extraterrestres ext = new Jeu_extraterrestres();
            // Créer un JFrame
            JFrame jf = new JFrame("UCA - jeux de combat");
            jf.add(ext);
            // Arreter le programme quand je ferme la fenetre
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Empecher le redimentionnement de la fenetre
	    jf.setResizable(false);
            // La taille de la fenetre
	    jf.setSize(800,700);
            // Centrer la fenetre   
            jf.setLocationRelativeTo(null);
            // Cacher l'accueil
            this.hide();
            // afficher la fenetre
            jf.setVisible(true);    }
        
        // si le joueur a appuyé sur "Vampires"......
        if(e.getSource() == (Object) b2){
            Jeu_vampires vamp = new Jeu_vampires();
            // Créer un JFrame
            JFrame jf = new JFrame("UCA - jeux de combat");
            jf.add(vamp);
            // Arreter le programme quand je ferme la fenetre
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Empecher le redimentionnement de la fenetre
	    jf.setResizable(false);
            // La taille de la fenetre
	    jf.setSize(800,700);
            // Centrer la fenetre   
            jf.setLocationRelativeTo(null);
            // Cacher l'accueil
            this.hide();
            // afficher la fenetre
            jf.setVisible(true);    }
        
    }



    
    
    
    

}
