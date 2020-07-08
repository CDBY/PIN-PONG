package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Contenedor extends JPanel{
   Ball ball = new Ball(this);
   Racquet racquet = new Racquet(this);

    public Contenedor() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2D);
        racquet.paint(g2D);
    }

    private void move() {
        ball.move();
        racquet.move();
    }
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "¡¡¡Game Over!!!", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame jframe = new JFrame("Prueba");
        jframe.setSize(400, 300);
        Contenedor game = new Contenedor();
        jframe.add(game);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
