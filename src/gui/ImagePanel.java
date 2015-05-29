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
            addArrow(1);
            addArrow(2);
            addArrow(3);
            addArrow(4);
            addArrow(5);
            addArrow(6);
            addArrow(7);
            addArrow(8);

        }
        public void addArrow(int direction){
            BufferedImage modified = null;
            int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
            modified = new BufferedImage(this.getWidth(), this.getHeight(), type);
            Graphics2D g = modified.createGraphics();
            g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null);

            Polygon poly = createTriangle(direction);
            g.setColor(Color.yellow);
            g.fillPolygon(poly);

            g.dispose();
            image = modified;
            repaint();
        }
        private Polygon createTriangle(int direction){

            Polygon poly;
            int width = this.getWidth();
            int height = this.getHeight();

            int xPolyNW[] = {5,5,15,5};
            int yPolyNW[] = {5,15,5,5};

            int xPolyN[] = {width/2 - 5,width/2,width/2+5,width/2-5};
            int yPolyN[] = {10,0,10,10};

            int xPolyNE[] = {width -15,width-5,width-5,width-15};
            int yPolyNE[] = {5,5,15,5};

            int xPolyE[] = {width -15,width-5,width-15,width-15};
            int yPolyE[] = {height/2-5,height/2,height/2+5,height/2-5};

            int xPolySE[] = {width -5,width-5,width-15,width-5};
            int yPolySE[] = {height-15,height-5,height-5,height-15};

            int xPolyS[] = {width/2 - 5,width/2 + 5,width/2,width/2-5};
            int yPolyS[] = {height-10,height-10,height,height-10};

            int xPolySW[] = {5,15,5,5};
            int yPolySW[] = {height-15,height-5,height-5,height-15};

            int xPolyW[] = {10,10,0,10};
            int yPolyW[] = {height/2-5,height/2+5,height/2,height/2-5};

            switch (direction){
                case 1:
                    poly = new Polygon(xPolyNW, yPolyNW, xPolyNW.length);
                    break;
                case 2:
                    poly = new Polygon(xPolyN, yPolyN, xPolyN.length);
                    break;
                case 3:
                    poly = new Polygon(xPolyNE, yPolyNE, xPolyNE.length);
                    break;
                case 4:
                    poly = new Polygon(xPolyE, yPolyE, xPolyE.length);
                    break;
                case 5:
                    poly = new Polygon(xPolySE, yPolySE, xPolySE.length);
                    break;
                case 6:
                    poly = new Polygon(xPolyS, yPolyS, xPolyS.length);
                    break;
                case 7:
                    poly = new Polygon(xPolySW, yPolySW, xPolySW.length);
                    break;
                case 8:
                    poly = new Polygon(xPolyW, yPolyW, xPolyW.length);
                    break;
                default:
                    return null;
            }
            return poly;
        }
    }
