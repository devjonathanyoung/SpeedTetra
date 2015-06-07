package game;

import data.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionSetCardSelected implements MouseListener{

    private GamePanel currentGamePanel;
    private HandPanel currentHandPanel;
    private int cardNumber;
    private Player player;

    public ActionSetCardSelected(GamePanel currentGamePanel, HandPanel currentHandPanel,
                                 int cardNumber, Player player) {
        this.currentGamePanel = currentGamePanel;
        this.currentHandPanel = currentHandPanel;
        this.cardNumber = cardNumber;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(player.identify().equalsIgnoreCase(currentGamePanel.getPlayerTurn())){
            currentGamePanel.setCurrentCard(player, cardNumber);
            currentHandPanel.borderize(cardNumber);
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
