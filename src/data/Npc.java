package data;

import java.util.Random;

public class Npc extends Player{

    public Npc(){
        super();
    }

    @Override
    protected void initHand(){
        Random randomGenerator = new Random();
        for(int i=0;i<5;i++){
            int randomInt = randomGenerator.nextInt(19) +1;
            Hand.add(new TetraCard("tm"+randomInt+".png"));
        }

    }
}
