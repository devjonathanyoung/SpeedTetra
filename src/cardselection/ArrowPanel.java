package cardselection;

import gui.ImagePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ArrowPanel extends ImagePanel{

    public  ArrowPanel(){
        super();
        setOpaque(false);
    }
    public void drawButton(int direction){
        BufferedImage modified;
        modified = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = modified.createGraphics();

        Polygon poly = createButton(direction);
        g.setColor(Color.yellow);
        g.fillPolygon(poly);

        g.dispose();
        image = modified;
        repaint();
    }

    private Polygon createButton(int direction){
        Polygon poly;
        int width = this.getWidth();
        int height = this.getHeight();

        int xPolyN[] = {0,width/2,width};
        int yPolyN[] = {height,0,height};

        int xPolyE[] = {0,width,0};
        int yPolyE[] = {0,height/2,height};

        int xPolyS[] = {0,width/2,width};
        int yPolyS[] = {0,height,0};

        int xPolyW[] = {width,0,width};
        int yPolyW[] = {0,height/2,height};

        switch (direction){
            case 1:
                poly = new Polygon(xPolyN, yPolyN, xPolyN.length);
                break;
            case 2:
                poly = new Polygon(xPolyE, yPolyE, xPolyE.length);
                break;
            case 3:
                poly = new Polygon(xPolyS, yPolyS, xPolyS.length);
                break;
            case 4:
                poly = new Polygon(xPolyW, yPolyW, xPolyW.length);
                break;
            default:
                return new Polygon(xPolyN, yPolyN, xPolyN.length);
        }
        return poly;
    }

}
