package game;

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

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(parent.isPlayable() && currentGamePanel.getCurrentCard() != null){
            parent.redraw(currentGamePanel.getCurrentCard());
            parent.owner = currentGamePanel.getCardSelectedPlayer();
            currentGamePanel.removeCurrentCard();
            parent.setPlayable(false);
            parent.attack();
            currentGamePanel.refresh();
            currentGamePanel.changeTurn();
            currentGamePanel.autoplay();
            currentGamePanel.changeTurn();
        }
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
