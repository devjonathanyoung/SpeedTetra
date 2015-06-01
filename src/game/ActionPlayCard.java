package game;

import data.TetraCard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionPlayCard implements MouseListener{

    private GamePanel currentGamePanel;
    private SquarePanel parent;

    public ActionPlayCard(GamePanel currentGamePanel, SquarePanel parent) {
        this.currentGamePanel = currentGamePanel;
        this.parent = parent;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(parent.isPlayable() && currentGamePanel.getCurrentCard() != null){
            TetraCard activeCard = currentGamePanel.getCurrentCard();
            parent.redraw(activeCard.getName(),activeCard.getArrows());
            currentGamePanel.removeCurrentCard();
            currentGamePanel.refresh();
            currentGamePanel.changeTurn();
            parent.setPlayable(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
