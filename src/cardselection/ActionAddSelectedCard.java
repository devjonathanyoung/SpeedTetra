package cardselection;

import gui.CardPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by suissia on 06/06/2015.
 */
public class ActionAddSelectedCard implements MouseListener {
    private CardPanel parent;
    private PanelCardSelected currentDestination;

    public ActionAddSelectedCard(CardPanel parent,PanelCardSelected currentDestination){
        this.parent = parent;
        this.currentDestination=currentDestination;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentDestination.addCardPanel(parent.getContainedCard());
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
