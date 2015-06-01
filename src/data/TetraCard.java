package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TetraCard extends RawTetraCard {
    private List<Integer> arrows;

    public TetraCard(String name){
        super(name);
        arrows = new ArrayList<Integer>();
        generateRandomArrows();
    }
    private void generateRandomArrows(){
        Random r = new Random();
        int numberOfArrows = r.nextInt(8-1) + 1;
        int chooser;
        for(int i=1;i<=numberOfArrows;i++){
            chooser = r.nextInt(1) +1;
            if (chooser == 1){
                arrows.add(i);
            }
        }
    }

    public List<Integer> getArrows(){
        return arrows;
    }
    public boolean assault(TetraCard victim){
        boolean result = true;
        if(this.attack() > victim.defend()){
            victim.switchSide();
        } else{
            this.switchSide();
            result = false;
        }
        return result;
    }
    public void switchSide(){
        if(name.contains("cat")){
            name = name.replace("cat","dog");
        }else if(name.contains("dog")){
            name = name.replace("dog","cat");
        }
    }

}
