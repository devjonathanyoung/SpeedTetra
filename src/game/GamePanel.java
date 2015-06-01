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
    private String playerTurn;
    private HandPanel player1Hand;
    private HandPanel player2Hand;
    private BoardPanel board;

    public GamePanel(){
        this.setSize(600,600);
        this.setLayout(null);

        cardSelectedPlayer = null;
        cardSelectedNumber = -1;
        player1 = new Player("Joueur 1");
        player2 = new Npc("NPC");
        playerTurn = player1.identify();
        setCurrentCard(player1,0);

        board = new BoardPanel(this);
        board.setBounds(95,70,400,400);

        initComponent();

    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setCurrentCard(Player player, int cardNumber){
        if(playerTurn.equalsIgnoreCase(player.identify())){
            this.cardSelectedPlayer = player;
            this.cardSelectedNumber = cardNumber;
        }
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
        player1Hand.borderize(0);
        add(player1Hand);

        player2Hand = new HandPanel(player2,this);
        player2Hand.setBounds(505,60,90,440);
        add(player2Hand);

        add(board);
    }
    public void changeTurn(){
        if(player1.getHand().isEmpty() && player2.getHand().isEmpty()){
            endGame();
        }
        if(playerTurn.equalsIgnoreCase(player1.identify())){
            playerTurn = player2.identify();
            player1Hand.removeBorder();
            player2Hand.borderize(0);
            setCurrentCard(player2,0);
        }else if(playerTurn.equalsIgnoreCase(player2.identify())){
            playerTurn = player1.identify();
            player2Hand.removeBorder();
            player1Hand.borderize(0);
            setCurrentCard(player1,0);
        }
    }
    private void endGame(){
        player1Hand.removeBorder();
        player2Hand.removeBorder();
        playerTurn = "endGame";
    }
}
