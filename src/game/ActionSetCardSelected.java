package game;

import data.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSetCardSelected implements ActionListener{

    private GamePanel currentGamePanel;
    private int cardNumber;
    private Player player;

    public ActionSetCardSelected(GamePanel currentGamePanel, int cardNumber, Player player) {
        this.currentGamePanel = currentGamePanel;
        this.cardNumber = cardNumber;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
