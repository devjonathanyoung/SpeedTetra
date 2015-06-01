package data;

import java.util.*;

public class Player {
    protected List<TetraCard> Hand;

    public Player(){
        Hand = new ArrayList<TetraCard>();
        initHand();
    }

    protected void initHand(){
        Hand.add(new TetraCard("dog1.jpg"));
        Hand.add(new TetraCard("dog2.jpg"));
        Hand.add(new TetraCard("dog4.jpg"));
        Hand.add(new TetraCard("dog1.jpg"));
        Hand.add(new TetraCard("dog3.jpg"));
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
