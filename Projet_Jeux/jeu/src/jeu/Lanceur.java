package jeu;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Lanceur implements Arme_interface {
    // les atrribut des coordonnées du lanceur
	private int x, y;
    // variables vont contenir l'image du lanceur
        private Image lanceur;
	private ImageIcon lanceur2 = new ImageIcon(this.getClass().getResource("images/lanceur2.png"));
	private ImageIcon lanceur1 = new ImageIcon(this.getClass().getResource("images/lanceur1.png"));
        private boolean left = false;
        private boolean right = false;


////////////// le constructeur de la classe //////////////////
public Lanceur() {
    // initialiser les coordonnées du lanceur
	x = 395;
	y = 620;
    // initialiser l'apparence du connon
	lanceur = lanceur2.getImage();
}


/////////// autes méthodes utiles pour le positionnement du lanceur /////////////
public void left() {
	x -= 3;
	if (x <= -38)  x = -38;
}


public void right() {
	x += 3;
	if (x >= 682) x = 682;
}


public void lanceur1() {
	y = 619;
	lanceur = lanceur1.getImage();
}


public void lanceur2() {
	y = 614;
	lanceur = lanceur2.getImage();
}


public void setLeft(boolean left) {
	this.left = left;
}

	
public void setRight(boolean right) {
	this.right = right;
}

	
public boolean getLeft() {
	return left;
}

public boolean getRight() {
	return right;
}

	
public int getX() {
	return x;
}


public int getY() {
	return y;
}


public Image getImage() {
	return lanceur;
}




}
