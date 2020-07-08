package Jframe;

import java.awt.*;

    public class Ball {
        private static final int DIAMETER=30;
        int x = 0;//direccion
        int y = 0;//velocidad
        int xa = 1;
        int ya = 1;
        private Contenedor game;

        public Ball(Contenedor game) {
            this.game= game;
        }

       protected void move() {
            if (x + xa < 0)
                xa = 1;
            if (x + xa > game.getWidth() - DIAMETER)
                xa = -1;
            if (y + ya < 0)
                ya = 1;
            if (y + ya > game.getHeight() - DIAMETER)
                game.gameOver();
            if (collision()){
                ya=-1;
                y = game.racquet.getTopY()-DIAMETER;
            }
            x = x + xa;
            y = y + ya;
        }

        public void paint(Graphics2D g){
            g.fillOval(x, y, DIAMETER,DIAMETER);
        }
        public Rectangle getBounds() {
            return new Rectangle(x, y, DIAMETER, DIAMETER);
        }
        private boolean collision() {
            return game.racquet.getBounds().intersects(getBounds());
        }
    }

