package Jframe;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y=220,WIDTH=60,HEIGHT=10;
    int x;
    int xa;

    private Contenedor game;

    public Racquet(Contenedor game){
    this.game = game;
    }

    protected void move(){
        if (x + xa > 0 && x + xa < game.getWidth()-60){
            x= x + xa;
        }
    }
    public void paint(Graphics2D g){
        g.fillRect(x,220,60,10);
    }
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa=1;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            xa=-1;
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }
    public int getTopY(){
        return Y - HEIGHT;
    }


}
