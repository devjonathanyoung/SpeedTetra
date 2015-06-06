package data;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String name;
    private HashMap<String,ArrayList<TetraCard>> cardCollection;

    public User(String name) {
        this.name = name;
        buildDeck();
    }

    private void buildDeck(){
        this.cardCollection = new HashMap<String, ArrayList<TetraCard>>();
        addCardToDeck(new TetraCard("dog1.jpg"));
        addCardToDeck(new TetraCard("dog2.jpg"));
        addCardToDeck(new TetraCard("dog2.jpg"));
        addCardToDeck(new TetraCard("dog2.jpg"));
        addCardToDeck(new TetraCard("dog4.jpg"));
        addCardToDeck(new TetraCard("dog4.jpg"));
        addCardToDeck(new TetraCard("dog4.jpg"));
        addCardToDeck(new TetraCard("dog4.jpg"));
        addCardToDeck(new TetraCard("dog1.jpg"));
        addCardToDeck(new TetraCard("dog3.jpg"));
        addCardToDeck(new TetraCard("dog3.jpg"));
        addCardToDeck(new TetraCard("dog3.jpg"));
    }
    private void addCardToDeck(TetraCard tc){
        if(!cardCollection.containsKey(tc.getName()))
            cardCollection.put(tc.getName(),new ArrayList<TetraCard>());

        cardCollection.get(tc.getName()).add(tc);
    }
    public HashMap<String,ArrayList<TetraCard>> getCardCollection(){
        return cardCollection;
    }
    public String getName(){
        return name;
    }
}
