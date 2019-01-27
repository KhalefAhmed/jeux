package jeu;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Balle extends objetMobile_abstrait{
        private int mouvement;
        private boolean visible;
	

public Balle(int x) {
            // initialisation des attributs
                this.x = x;
                this.y = 605;
                this.mouvement = 10;
            // affecter l'image png de la ball à l'imageIcone b
		ImageIcon b = new ImageIcon(this.getClass().getResource("images/balle.png"));
		this.image = b.getImage();
            // je vait utiliser les memes dimension de l'image
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
                this.visible = true;
}
        
        

////////////  méthode qui va produire une clone d'un objet déja crée //////////////   
public Balle cloneToi(int xClone){
            Balle clone = new Balle(xClone);
            return clone;
 }


//////////////// pour faire déplacer la balle  /////////////////////////////////
public void move() { y = y - mouvement; }


///////////////// Récupérer l'attribur x    ////////////////////////////////////
public int getX()  {  return this.x;  }


///////////////// Modifier l'attribur x   /////////////////////////////////////
public void setX(int x)  {  this.x = x;  }


///////////////// Récupérer l'attribur y   /////////////////////////////////////
public int getY()  { return this.y;  }


//////////////// Récupérer l'attribur image de type Image   ////////////////////
public Image getImage()  {  return image;  }


////////////// Récupérer un rectangle logique qui entoure l'objet  /////////////
public Rectangle getRectangle() {  return new Rectangle(x, y, width, height); }        
	

}