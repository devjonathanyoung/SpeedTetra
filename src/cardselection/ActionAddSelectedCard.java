package cardselection;

import data.TetraCard;
import gui.CardPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by suissia on 06/06/2015.
 */
public class ActionAddSelectedCard implements MouseListener {
    private TetraCard currentCard;
    private PanelCardSelected currentDestination;
    public ActionAddSelectedCard(TetraCard currentCard,PanelCardSelected currentDestination){
        this.currentCard = currentCard;
        this.currentDestination=currentDestination;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentDestination.addImagePanel(currentCard);
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
