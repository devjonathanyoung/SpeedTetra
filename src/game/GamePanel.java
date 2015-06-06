package game;

import cardselection.ArrowPanel;
import data.Npc;
import data.Player;
import data.TetraCard;
import data.User;
import gui.FrameContainer;

import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    private Player cardSelectedPlayer;
    private int cardSelectedNumber;
    private Player player1;
    private Player player2;
    private String playerTurn;
    private HandPanel player1Hand;
    private HandPanel player2Hand;
    private BoardPanel board;
    private JLabel lblTurn;
    private JLabel lblPlayer1Score;
    private JLabel lblPlayer2Score;

    public GamePanel(){
        player1 = new Player("Joueur 1");
        player2 = new Npc("NPC");

        initComponent();
        updateComponent();
    }
    public GamePanel(FrameContainer frameContainer, User user, ArrayList<TetraCard> Hand){
        player1 = new Player(user.getName(),Hand);
        player2 = new Npc("NPC");

        initComponent();
        updateComponent();
    }
    private void initComponent(){
        this.setSize(600,600);
        this.setLayout(null);

        cardSelectedPlayer = null;
        cardSelectedNumber = -1;

        playerTurn = player1.identify();
        setCurrentCard(player1,0);

        board = new BoardPanel(this);
        board.setBounds(95,70,400,400);

        lblTurn = new JLabel("Player 1 Turn", SwingConstants.CENTER);
        lblTurn.setBounds(95,475,400,20);

        lblPlayer1Score = new JLabel("Player 1 Score : 0", SwingConstants.CENTER);
        lblPlayer1Score.setBounds(95,495,400,20);

        lblPlayer2Score = new JLabel("Player 2 Score : 0", SwingConstants.CENTER);
        lblPlayer2Score.setBounds(95,515,400,20);

    }
    private void updateComponent(){
        player1Hand = new HandPanel(player1,this);
        player1Hand.setBounds(5,60,90,440);
        player1Hand.borderize(0);
        add(player1Hand);

        player2Hand = new HandPanel(player2,this);
        player2Hand.setBounds(505,60,90,440);
        add(player2Hand);

        add(board);
        add(lblTurn);
        add(lblPlayer1Score);
        add(lblPlayer2Score);

    }

    public String getPlayerTurn() {
        return playerTurn;
    }
    public Player getCardSelectedPlayer(){
        return cardSelectedPlayer;
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
        this.updateComponent();
    }

    public void changeTurn(){
        lblPlayer1Score.setText("Player 1 Score : " + board.getPlayerScore(player1));
        lblPlayer2Score.setText("Player 2 Score : " + board.getPlayerScore(player2));

        if(player1.getHand().isEmpty() && player2.getHand().isEmpty()){
            this.endGame();
            return;
        }

        if(playerTurn.equalsIgnoreCase(player1.identify())){
            playerTurn = player2.identify();
            player1Hand.removeBorder();
            player2Hand.borderize(0);
            setCurrentCard(player2,0);
            lblTurn.setText("Player 2 Turn");
        }else if(playerTurn.equalsIgnoreCase(player2.identify())){
            playerTurn = player1.identify();
            player2Hand.removeBorder();
            player1Hand.borderize(0);
            setCurrentCard(player1,0);
            lblTurn.setText("Player 1 Turn");
        }
    }

    private void endGame(){
        Player winner = board.getWinner(player1, player2);
        String result;
        if(winner != null){
            result = winner.identify();
        } else {
            result = "Draw";
        }
        player1Hand.removeBorder();
        player2Hand.removeBorder();
        lblTurn.setText("End of the Game : " + result);
        playerTurn = "endGame";
    }
}
