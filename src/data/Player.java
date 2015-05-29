package data;

import java.util.*;

public class Player {
    protected List<TetraCard> Hand;

    public Player(){
        Hand = new ArrayList<TetraCard>();
        initHand();
    }

    protected void initHand(){
        Hand.add(new TetraCard("tm1.png"));
        Hand.add(new TetraCard("tm2.png"));
        Hand.add(new TetraCard("tm4.png"));
        Hand.add(new TetraCard("tm1.png"));
        Hand.add(new TetraCard("tm3.png"));
    }

    public TetraCard getCard(int cardNumber){
        return Hand.get(cardNumber);
    }
    public List<TetraCard> getHand(){
        return Hand;
    }
    public void removeCardFromHand(int index){
        this.Hand.remove(index);
    }
}
