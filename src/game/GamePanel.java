package game;

import data.Npc;
import data.Player;
import data.TetraCard;

import javax.swing.*;

public class GamePanel extends JPanel{
    private Player cardSelectedPlayer;
    private int cardSelectedNumber;
    private Player player1;
    private Player player2;
    private HandPanel player1Hand;
    private HandPanel player2Hand;
    private BoardPanel board;

    public GamePanel(){
        cardSelectedPlayer = null;
        cardSelectedNumber = -1;
        player1 = new Player();
        player2 = new Npc();
        this.setSize(600,600);
        this.setLayout(null);
        board = new BoardPanel(this);
        board.setBounds(95,70,400,400);
        initComponent();
    }

    public void setCurrentCard(Player player, int cardNumber){
        this.cardSelectedPlayer = player;
        this.cardSelectedNumber = cardNumber;
    }

    public TetraCard getCurrentCard(){
        if(cardSelectedPlayer == null) return null;
        return cardSelectedPlayer.getCard(cardSelectedNumber);
    }
    public void removeCurrentCard(){
        cardSelectedPlayer.removeCardFromHand(cardSelectedNumber);
        cardSelectedPlayer = null;
        cardSelectedNumber = -1;
    }

    public void refresh(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.initComponent();
    }
    private void initComponent(){
        player1Hand = new HandPanel(player1,this);
        player1Hand.setBounds(5,60,90,440);
        add(player1Hand);

        player2Hand = new HandPanel(player2,this);
        player2Hand.setBounds(505,60,90,440);
        add(player2Hand);

        add(board);
    }

}
