package game;

import data.Player;
import gui.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionSetCardSelected implements MouseListener{

    private GamePanel currentGamePanel;
    private HandPanel currentHandPanel;
    private int cardNumber;
    private Player player;
    private ImagePanel parent;

    public ActionSetCardSelected(GamePanel currentGamePanel, HandPanel currentHandPanel,
                                 int cardNumber, Player player, ImagePanel parent) {
        this.currentGamePanel = currentGamePanel;
        this.currentHandPanel = currentHandPanel;
        this.cardNumber = cardNumber;
        this.player = player;
        this.parent = parent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentGamePanel.setCurrentCard(player,cardNumber);
        parent.setBorder(BorderFactory.createLineBorder(Color.red));
        player.removeCardFromHand(cardNumber);
        currentGamePanel.refresh();
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
