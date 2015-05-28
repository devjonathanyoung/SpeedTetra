package data;

import java.util.*;

public class Player {
    private List<TetraCard> Hand;

    public Player(){
        Hand = new ArrayList<TetraCard>();
        Hand.add(new TetraCard());
        Hand.add(new TetraCard());
        Hand.add(new TetraCard());
        Hand.add(new TetraCard());
        Hand.add(new TetraCard());

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
