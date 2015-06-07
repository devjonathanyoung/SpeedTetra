package gui;

import data.TetraCard;
import gui.ImagePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class CardPanel extends ImagePanel{

    protected TetraCard containedCard;
    public TetraCard getContainedCard(){
        return containedCard;
    }
    public void redraw(String name,List<Integer> arrows){
        buildImage(name);
        generateArrows(arrows);
        repaint();
    }

    private void generateArrows(List<Integer> arrows){
        for(int i:arrows){
            addArrow(i);
        }
    }
    public void addArrow(int direction){
        BufferedImage modified;
        int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
        modified = new BufferedImage(this.getWidth(), this.getHeight(), type);
        Graphics2D g = modified.createGraphics();
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null);

        Polygon poly = createTriangle(direction);
        g.setColor(new Color(218, 165, 32));
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

    public void redraw(TetraCard tc){
        redraw(tc.getName(), tc.getArrows());
        this.containedCard = tc;
    }

}
