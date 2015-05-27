package data;

import java.util.List;

public class Player {
    private List<TetraCard> Hand;
    public TetraCard getCard(int cardNumber){
        return Hand.get(cardNumber);
    }
}
