package jeu;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Vaisseau extends objetMobile_abstrait implements Ennemis_interface{

    
public Vaisseau(int x) {
           // initialiser les coordonnées 
            this.x = x;
            this.y = 0;
            Random r = new Random();
            int num_vaisseau = r.nextInt(4) + 1;
            // affecter l'image d'un vaisseau spatial a l'imageicon v
		ImageIcon v = new ImageIcon(this.getClass().getResource("images/ennemis/vaisseau"+num_vaisseau+".png"));
		this.image = v.getImage();

            // les dimensions originale du nuage
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
}


////////////  méthode qui va produire une clone d'un objet déja crée //////////////
public Vaisseau cloneToi(){
            Vaisseau clone = new Vaisseau(this.x);
             Random r = new Random();
             int X = r.nextInt(730);
             clone.setX(X);
             return clone;
 }



///////////////// Récupérer l'attribur x   /////////////////////////////////////
public int getX()  {  return this.x;  }

///////////////// Modifier l'attribur x   /////////////////////////////////////
public void setX(int x)  {  this.x = x;  }

//////////////// Récupérer l'attribur y  ///////////////////////////////////////
public int getY()  { return this.y;  }


//////////////// pour faire déplacer le nuage  /////////////////////////////////
public void move() { y = y+2; }


//////////////// Récupérer l'attribur image de type Image //////////////////////
public Image getImage()  {  return image;  }


//////////////// Récupérer un rectangle logique qui entoure l'objet ////////////
public Rectangle getRectangle() {  return new Rectangle(x, y, width, height); }








}
