package data;

import game.BoardPanel;
import game.GamePanel;
import game.HandPanel;
import game.SquarePanel;

import java.util.Random;

public class Npc extends Player{

    public Npc(String name){
        super(name);
    }

    @Override
    protected void initHand(){
        Random randomGenerator = new Random();
        for(int i=0;i<5;i++){
            int randomInt = randomGenerator.nextInt(4) +1;
            hand.add(new TetraCard("cat"+randomInt+".jpg"));
        }
    }

    public int getRandomCardIndex(){
        Random randomGenerator = new Random();
        if (hand.size() -1 >0){
            return randomGenerator.nextInt(hand.size() -1) +1;
        }
        return 0;
    }
    public void playRandom(GamePanel gp, HandPanel myHandPanel, BoardPanel board){
        int cardNumber = getRandomCardIndex();
        gp.setCurrentCard(this, cardNumber);
        myHandPanel.borderize(cardNumber);
        SquarePanel randomSquare = board.getRandomPlayableSquare();
        randomSquare.redraw(gp.getCurrentCard());
        randomSquare.owner = this;
        gp.removeCurrentCard();

        randomSquare.setPlayable(false);
        randomSquare.attack();

        gp.refresh();
    }
}
