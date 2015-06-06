package cardselection;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by suissia on 06/06/2015.
 */
public class ActionAddSelectedCard implements MouseListener {
    private PanelCardCollection currentPanelCardCollection;
    private int index;
    public ActionAddSelectedCard(PanelCardCollection currentPanelCardCollection,int index){
        this.currentPanelCardCollection = currentPanelCardCollection;
        this.index=index;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentPanelCardCollection.addCard(index);
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
