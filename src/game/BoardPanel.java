package game;

import data.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BoardPanel extends JPanel {
    private HashMap<String,SquarePanel> boardSquares;
    private GamePanel parent;

    public BoardPanel(GamePanel parent){
        this.parent = parent;
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        boardSquares = new HashMap<String, SquarePanel>();
        initSquares();
        putRandomStones();
        initSquaresRelations();
    }

    private void initSquares(){
        for(int j=0;j<4;j++){
            for(int i=0;i<4;i++){
                SquarePanel temp = new SquarePanel(true);
                temp.setBounds(i*100,j*100,100,100);
                ActionPlayCard apc = new ActionPlayCard(parent,temp);
                temp.addMouseListener(apc);
                boardSquares.put(j + ":" + i,temp);
            }
        }
        for(String it: boardSquares.keySet()){
            add(boardSquares.get(it));
        }
    }

    private void putRandomStones(){
        Random r = new Random();
        int x,y;
        int numberOfStones = r.nextInt(4) + 2;
        for(int i=0;i<numberOfStones;i++){
            x= r.nextInt(3);
            y= r.nextInt(3);
            SquarePanel sp = boardSquares.get(x + ":" + y);
            sp.redraw("stone.jpg");
            sp.setPlayable(false);
        }
    }
    public int getPlayerScore(Player player){
        int score = 0;
        for(String s:boardSquares.keySet()){
            Player boardSquareOwner = boardSquares.get(s).owner;
            if(boardSquareOwner != null){
                if(boardSquareOwner.identify().equalsIgnoreCase(player.identify())){
                    score++;
                }
            }
        }
        return score;
    }
    public Player getWinner(Player player1, Player player2){
        int numberCardPlayer1 = getPlayerScore(player1);
        int numberCardPlayer2 = getPlayerScore(player2);

        if(numberCardPlayer1 > numberCardPlayer2){
            return player1;
        }
        if(numberCardPlayer2 > numberCardPlayer1){
            return player2;
        }
        return null;
    }
    private ArrayList<SquarePanel> getEmptySquares(){
        ArrayList<SquarePanel> emptySquares = new ArrayList<SquarePanel>();
        for(SquarePanel sp: boardSquares.values()){
            if(sp.isPlayable()){
                emptySquares.add(sp);
            }
        }
        return emptySquares;
    }
    public SquarePanel getRandomPlayableSquare(){
        Random randomIntGenerator = new Random();
        ArrayList<SquarePanel> emptySquares = getEmptySquares();
        int randomSquareIndex = randomIntGenerator.nextInt(emptySquares.size() - 1) + 1;
        return emptySquares.get(randomSquareIndex);
    }
    private void initSquaresRelations(){
        SquarePanel square1 = boardSquares.get("0:0");
        SquarePanel square2 = boardSquares.get("0:1");
        SquarePanel square3 = boardSquares.get("0:2");
        SquarePanel square4 = boardSquares.get("0:3");

        SquarePanel square5 = boardSquares.get("1:0");
        SquarePanel square6 = boardSquares.get("1:1");
        SquarePanel square7 = boardSquares.get("1:2");
        SquarePanel square8 = boardSquares.get("1:3");

        SquarePanel square9 = boardSquares.get("2:0");
        SquarePanel square10 = boardSquares.get("2:1");
        SquarePanel square11 = boardSquares.get("2:2");
        SquarePanel square12 = boardSquares.get("2:3");

        SquarePanel square13 = boardSquares.get("3:0");
        SquarePanel square14 = boardSquares.get("3:1");
        SquarePanel square15 = boardSquares.get("3:2");
        SquarePanel square16 = boardSquares.get("3:3");

        square1.linkSquarePanel("east",square2);
        square1.linkSquarePanel("southEast",square6);
        square1.linkSquarePanel("south",square5);

        square2.linkSquarePanel("east", square3);
        square2.linkSquarePanel("southEast", square7);
        square2.linkSquarePanel("south", square6);
        square2.linkSquarePanel("southWest", square5);
        square2.linkSquarePanel("west", square1);

        square3.linkSquarePanel("east", square4);
        square3.linkSquarePanel("southEast", square8);
        square3.linkSquarePanel("south", square7);
        square3.linkSquarePanel("southWest", square6);
        square3.linkSquarePanel("west", square2);

        square4.linkSquarePanel("west",square3);
        square4.linkSquarePanel("southWest",square7);
        square4.linkSquarePanel("south",square8);

        square5.linkSquarePanel("north", square1);
        square5.linkSquarePanel("northEast", square2);
        square5.linkSquarePanel("east", square6);
        square5.linkSquarePanel("southEast", square10);
        square5.linkSquarePanel("south", square9);

        square6.linkSquarePanel("north", square2);
        square6.linkSquarePanel("northEast", square3);
        square6.linkSquarePanel("east", square7);
        square6.linkSquarePanel("southEast", square11);
        square6.linkSquarePanel("south", square10);
        square6.linkSquarePanel("southWest", square9);
        square6.linkSquarePanel("west", square5);
        square6.linkSquarePanel("northWest", square1);

        square7.linkSquarePanel("north", square3);
        square7.linkSquarePanel("northEast", square4);
        square7.linkSquarePanel("east", square8);
        square7.linkSquarePanel("southEast", square12);
        square7.linkSquarePanel("south", square11);
        square7.linkSquarePanel("southWest", square10);
        square7.linkSquarePanel("west", square6);
        square7.linkSquarePanel("northWest", square2);

        square8.linkSquarePanel("north", square4);
        square8.linkSquarePanel("northWest", square3);
        square8.linkSquarePanel("west", square7);
        square8.linkSquarePanel("southWest", square11);
        square8.linkSquarePanel("south", square12);

        square9.linkSquarePanel("north", square5);
        square9.linkSquarePanel("northEast", square6);
        square9.linkSquarePanel("east", square10);
        square9.linkSquarePanel("southEast", square14);
        square9.linkSquarePanel("south", square13);

        square10.linkSquarePanel("north", square6);
        square10.linkSquarePanel("northEast", square7);
        square10.linkSquarePanel("east", square11);
        square10.linkSquarePanel("southEast", square15);
        square10.linkSquarePanel("south", square14);
        square10.linkSquarePanel("southWest", square13);
        square10.linkSquarePanel("west", square9);
        square10.linkSquarePanel("northWest", square5);

        square11.linkSquarePanel("north", square7);
        square11.linkSquarePanel("northEast", square8);
        square11.linkSquarePanel("east", square12);
        square11.linkSquarePanel("southEast", square16);
        square11.linkSquarePanel("south", square15);
        square11.linkSquarePanel("southWest", square14);
        square11.linkSquarePanel("west", square10);
        square11.linkSquarePanel("northWest", square6);

        square12.linkSquarePanel("north", square8);
        square12.linkSquarePanel("northWest", square7);
        square12.linkSquarePanel("west", square11);
        square12.linkSquarePanel("southWest", square15);
        square12.linkSquarePanel("south", square16);

        square13.linkSquarePanel("north",square9);
        square13.linkSquarePanel("northEast",square10);
        square13.linkSquarePanel("east",square14);

        square14.linkSquarePanel("west", square13);
        square14.linkSquarePanel("northWest", square9);
        square14.linkSquarePanel("north", square10);
        square14.linkSquarePanel("northEast", square11);
        square14.linkSquarePanel("east", square15);

        square15.linkSquarePanel("west", square14);
        square15.linkSquarePanel("northWest", square10);
        square15.linkSquarePanel("north", square11);
        square15.linkSquarePanel("northEast", square12);
        square15.linkSquarePanel("east", square16);

        square16.linkSquarePanel("north",square12);
        square16.linkSquarePanel("northWest",square11);
        square16.linkSquarePanel("west",square15);
    }
}
