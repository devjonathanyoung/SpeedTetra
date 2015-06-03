package data;

import java.util.Random;

public class RawTetraCard {
    protected String name;
    private int power;
    private int defense;

    public RawTetraCard(String name){
        this.name = name;
        Random r = new Random();
        this.defense = r.nextInt(10 - 1) + 1;
        this.power = r.nextInt(10 - 1) + 1;
    }

    public String getName(){
        return name;
    }

    protected int defend(){
        return defense;
    }
    protected int attack(){
        return power;
    }

}
