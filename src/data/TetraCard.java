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
        int numberOfArrows = r.nextInt(7) + 1;
        int chooser;
        for(int i=1;i<=numberOfArrows;){
            chooser = r.nextInt(7) +1;
            if(!arrows.contains(chooser)){
                arrows.add(chooser);
                i++;
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
    public boolean canAccess(String direction){
        if(direction.equalsIgnoreCase("north") && arrows.contains(2))
            return true;
         else if(direction.equalsIgnoreCase("northEast") && arrows.contains(3))
            return true;
         else if(direction.equalsIgnoreCase("east") && arrows.contains(4))
            return true;
         else if(direction.equalsIgnoreCase("southEast") && arrows.contains(5))
            return true;
         else if(direction.equalsIgnoreCase("south") && arrows.contains(6))
            return true;
         else if(direction.equalsIgnoreCase("southWest") && arrows.contains(7))
            return true;
         else if(direction.equalsIgnoreCase("west") && arrows.contains(8))
            return true;
         else if(direction.equalsIgnoreCase("northWest") && arrows.contains(1))
            return true;
         else
            return false;
        
    }
}
