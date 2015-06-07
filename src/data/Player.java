package data;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected List<TetraCard> hand;
    protected String name;

    public Player(String name){
        this.name = name;
        hand = new ArrayList<TetraCard>();
        initHand();
    }
    public Player(String name,List<TetraCard> Hand){
        this.name = name;
        this.hand = Hand;
    }

    protected void initHand(){
        hand.add(new TetraCard("dog1.jpg"));
        hand.add(new TetraCard("dog2.jpg"));
        hand.add(new TetraCard("dog4.jpg"));
        hand.add(new TetraCard("dog5.jpg"));
        hand.add(new TetraCard("dog3.jpg"));
    }

    public TetraCard getCard(int cardNumber){
        return hand.get(cardNumber);
    }
    public List<TetraCard> getHand(){
        return hand;
    }
    public void removeCardFromHand(int index){
        this.hand.remove(index);
    }
    public String identify(){
        return name;
    }
}
