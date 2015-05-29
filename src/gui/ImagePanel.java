package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

        private BufferedImage image;
        public static String PATHTOIMAGES = "ressources\\images";
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }

        public void redraw(String name){
            buildImage(name);
            repaint();
        }
        private void buildImage(String name){
            BufferedImage resizedImage = null;
            try {
                BufferedImage rawImage = ImageIO.read(new File(Paths.get(ImagePanel.PATHTOIMAGES, name).toString()));
                int type = rawImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : rawImage.getType();
                resizedImage = new BufferedImage(this.getWidth(), this.getHeight(), type);
                Graphics2D g = resizedImage.createGraphics();
                g.drawImage(rawImage, 0, 0,this.getWidth(), this.getHeight(), null);
                g.dispose();
            } catch (IOException ex) {
                System.err.println(Paths.get(ImagePanel.PATHTOIMAGES, name).toString());
                System.err.println("Could not find picture " + name);
            }
            image = resizedImage;
        }
        public void addArrow(){
            BufferedImage modified = null;
            int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
            modified = new BufferedImage(this.getWidth(), this.getHeight(), type);
            Graphics2D g = modified.createGraphics();
            g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null);

            Polygon poly = createTriangle("");
            g.setColor(Color.yellow);
            g.fillPolygon(poly);

            g.dispose();
            image = modified;
            repaint();
        }
        private Polygon createTriangle(String direction){
            int xPoly[] = {5, 15, 5,5};
            int yPoly[] = {5, 5, 15,5};
            Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
            return poly;
        }
    }
