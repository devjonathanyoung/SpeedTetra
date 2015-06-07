package cardselection;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionArrow implements MouseListener {
    private final PanelCardCollection parent;
    private final String arrowDirection;

    public ActionArrow(PanelCardCollection parent,String arrowDirection){
        this.parent = parent;
        this.arrowDirection = arrowDirection;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(arrowDirection.equalsIgnoreCase("top")){
            parent.incrementVerticalCounter();
        }
        if(arrowDirection.equalsIgnoreCase("bot")){
            if(parent.curVerticalCounter -1 >= 0)
                parent.curVerticalCounter--;
        }
        if(arrowDirection.equalsIgnoreCase("left")){
            if(parent.curHorizontalCounter -1 >= 0){
                parent.curVerticalCounter = 0;
                parent.curHorizontalCounter--;
            }
        }
        if(arrowDirection.equalsIgnoreCase("right")){
            parent.incrementHorizontalCounter();
        }
        parent.refresh();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
