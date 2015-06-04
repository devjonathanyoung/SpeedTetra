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
        ArrayList<TetraCard> tempCards = new ArrayList<TetraCard>();
        //cardCollection.put("")
    }
}
