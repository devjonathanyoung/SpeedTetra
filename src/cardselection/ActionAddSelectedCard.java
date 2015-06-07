package cardselection;

import data.TetraCard;
import gui.CardPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by suissia on 06/06/2015.
 */
public class ActionAddSelectedCard implements MouseListener {
    private CardPanel parent;
    private PanelCardSelected currentDestination;
    private HashMap<String, ArrayList<TetraCard>> curdeck;
    private PanelCardCollection pcc;
    public ActionAddSelectedCard(CardPanel parent,PanelCardSelected currentDestination,
                                 HashMap<String, ArrayList<TetraCard>> curdeck, PanelCardCollection pcc){
        this.parent = parent;
        this.currentDestination=currentDestination;
        this.curdeck = curdeck;
        this.pcc = pcc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        TetraCard selectedCard = parent.getContainedCard();
        currentDestination.addCardPanel(selectedCard);
        if(curdeck.get(selectedCard.getName()).contains(selectedCard)){
            curdeck.get(selectedCard.getName()).remove(selectedCard);
        }
        if(pcc.curVerticalCounter - 1 >= 0){
            pcc.curVerticalCounter--;
        }else{
            if(curdeck.get(selectedCard.getName()).size() <= 0){
                curdeck.remove(selectedCard.getName());
                pcc.curHorizontalCounter--;
                pcc.curVerticalCounter = 0;
            }
        }
        pcc.refresh();
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
