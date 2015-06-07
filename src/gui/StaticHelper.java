package gui;

public class StaticHelper {
    public static String PATHTOIMAGES = "ressources\\images";
    public static String PATHTOUSERFILE = "ressources\\userdata";

    public static String getOppositeDirection(String direction){
        if(direction.equalsIgnoreCase("north"))
            return "south";
        else if(direction.equalsIgnoreCase("northEast"))
            return "southWest";
        else if(direction.equalsIgnoreCase("east"))
            return "west";
        else if(direction.equalsIgnoreCase("southEast"))
            return "northWest";
        else if(direction.equalsIgnoreCase("south"))
            return "north";
        else if(direction.equalsIgnoreCase("southWest"))
            return "northEast";
        else if(direction.equalsIgnoreCase("west"))
            return "east";
        else if(direction.equalsIgnoreCase("northWest"))
            return "northEast";
        else
            return null;
    }
}
