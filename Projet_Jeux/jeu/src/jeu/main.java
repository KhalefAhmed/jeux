package jeu;


import javax.swing.JFrame;
public class main  {


	
public static void main(String[] args) {
        // Créer un JFrame
        JFrame accueil = new JFrame("UCA - jeux de combat");
        // Créer une instance de Mon_Jpanel qui hérire de JPanel
        Mon_Jpanel pan = new Mon_Jpanel();
        // Ajouter le JPanel au JFrame
        accueil.setContentPane(pan);
        // Arreter le programme quand je ferme la fenetre
        accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Empecher le redimentionnement de la fenetre
	accueil.setResizable(false);
        // La taille de la fenetre
	accueil.setSize(800,700);
        // Centrer la fenetre   
        accueil.setLocationRelativeTo(null);
        // afficher la fenetre
        accueil.setVisible(true);
                
                
}




  
}
