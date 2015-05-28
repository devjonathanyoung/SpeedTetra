package game;

import data.Player;
import data.TetraCard;

import javax.swing.*;

public class GamePanel extends JPanel{
    private TetraCard cardSelected;
    private Player player1;
    private Player player2;
    private HandPanel player1Hand;
    private HandPanel player2Hand;

    public void setCurrentCard(Player player, int cardNumber){
        this.cardSelected = player.getCard(cardNumber);
    }

    public GamePanel(){
        player1 = new Player();
        player2 = new Player();
        this.setSize(600,600);
        this.setLayout(null);
        initComponent();
    }
    public void refresh(){
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.initComponent();
    }
    private void initComponent(){
        player1Hand = new HandPanel(player1,this);
        player1Hand.setBounds(20,60,85,4*85 + 80);
        add(player1Hand);

        player2Hand = new HandPanel(player2,this);
        player2Hand.setBounds(500,60,85,4*85 + 80);
        add(player2Hand);
    }
}
