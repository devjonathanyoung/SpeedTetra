package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ImagePanel extends JPanel {

        protected BufferedImage image;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
        public void redraw(String name){
            buildImage(name);
            repaint();
        }
        protected void buildImage(String name){
            BufferedImage resizedImage = null;
            try {
                BufferedImage rawImage = ImageIO.read(new File(Paths.get(StaticHelper.PATHTOIMAGES, name).toString()));
                int type = rawImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : rawImage.getType();
                resizedImage = new BufferedImage(this.getWidth(), this.getHeight(), type);
                Graphics2D g = resizedImage.createGraphics();
                g.drawImage(rawImage, 0, 0,this.getWidth(), this.getHeight(), null);
                g.dispose();
            } catch (IOException ex) {
                System.err.println(Paths.get(StaticHelper.PATHTOIMAGES, name).toString());
                System.err.println("Could not find picture " + name);
            }
            image = resizedImage;
        }

    }
