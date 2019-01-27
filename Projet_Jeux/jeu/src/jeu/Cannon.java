package jeu;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Cannon implements Arme_interface {
    // les atrribut des coordonnées du cannon
	private int x, y;
    // variables vont contenir l'image du cannon
        private Image cannon;
	private ImageIcon Cannon_bleu = new ImageIcon(this.getClass().getResource("images/cannon_bleu.png"));
	private ImageIcon Cannon_rouge = new ImageIcon(this.getClass().getResource("images/cannon_rouge.png"));
        private boolean left = false;
        private boolean right = false;


////////////// le constructeur de la classe //////////////////
public Cannon() {
    // initialiser les coordonnées du cannon
	x = 395;
	y = 620;
    // initialiser l'apparence du connon
	cannon = Cannon_bleu.getImage();
}


/////////// autes méthodes utiles pour le positionnement du cannon /////////////
public void left() {
	x -= 3;
	if (x <= 0)  x = 0;
}


public void right() {
	x += 3;
	if (x >= 706) x = 706;
}


public void cannon_rouge() {
	y = 625;
	cannon = Cannon_rouge.getImage();
}


public void cannon_bleu() {
	y = 620;
	cannon = Cannon_bleu.getImage();
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
	return cannon;
}




}
