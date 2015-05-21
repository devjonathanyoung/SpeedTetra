package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

        private BufferedImage image;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }

        public void redraw(String path){
            //image = ImageBuilder.getImage(type,name,this.getWidth(),this.getHeight());
            repaint();
        }
    }
