package data;

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
            Hand.add(new TetraCard("cat"+randomInt+".jpg"));
        }

    }
}
