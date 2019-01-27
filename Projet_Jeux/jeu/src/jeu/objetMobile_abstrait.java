package jeu;

import java.awt.Image;
import java.awt.Rectangle;


public abstract class objetMobile_abstrait {
        protected int x;
        protected int y;
	protected Image image;
	protected int width;
        protected int height;
        
        public abstract Image getImage();
        public abstract int getX();
        public abstract int getY();
        public abstract void move();
        public abstract Rectangle getRectangle();
        
    
}
