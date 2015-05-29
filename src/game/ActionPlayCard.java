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
        if(parent.isPlayable() && currentGamePanel.getCurrentCard() != null){
            parent.redraw(currentGamePanel.getCurrentCard().getName());
            currentGamePanel.removeCurrentCard();
            currentGamePanel.refresh();
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
