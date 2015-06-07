package data;

import gui.StaticHelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String name;
    private HashMap<String,ArrayList<TetraCard>> cardCollection;
    public int nbVictory;
    public int nbDefeat;
    public int nbDraw;

    public User(String name,String mode) {
        this.name = name;
        if(mode.equalsIgnoreCase("init")){
            buildDeck();
            nbVictory = 0;
            nbDefeat = 0;
            nbDraw = 0;
        } else{
            this.cardCollection = new HashMap<String, ArrayList<TetraCard>>();
            Load();
        }
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
        addCardToDeck(new TetraCard("dog1.jpg"));
        addCardToDeck(new TetraCard("dog3.jpg"));
        addCardToDeck(new TetraCard("dog3.jpg"));
        addCardToDeck(new TetraCard("dog5.jpg"));
        addCardToDeck(new TetraCard("dog5.jpg"));
        Save();
    }
    public void addCardToDeck(TetraCard tc){
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
    private void Load(){
        String[] splited,splited2;
        ArrayList<Integer> arrows;
        try{
            List<String> lines = Files.readAllLines(Paths.get(StaticHelper.PATHTOUSERFILE, "userdata.txt")
                    , Charset.defaultCharset());
            for (String line : lines) {
                if(line.contains(";")){
                    splited = line.split(";");
                    splited2 = splited[1].split(",");
                    arrows = new ArrayList<Integer>();
                    for (String number:splited2){
                        arrows.add(Integer.parseInt(number));
                    }
                    addCardToDeck(new TetraCard(splited[0],arrows));
                } else if(line.contains("playername")){
                    splited = line.split("=");
                    this.name = splited[1];
                } else if(line.contains("nbVictory")){
                    splited = line.split("=");
                    this.nbVictory = Integer.parseInt(splited[1]);
                } else if(line.contains("nbDefeat")){
                    splited = line.split("=");
                    this.nbDefeat = Integer.parseInt(splited[1]);
                } else if(line.contains("nbDraw")){
                    splited = line.split("=");
                    this.nbDraw = Integer.parseInt(splited[1]);
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public void Save(){
        try{
            String dataString = "playername=" + name + "\n";
            dataString += "nbVictory=" +nbVictory + "\n";
            dataString += "nbDefeat=" +nbDefeat + "\n";
            dataString += "nbDraw=" +nbDraw + "\n";
            for(String cardName:cardCollection.keySet()){
                for(TetraCard tc:cardCollection.get(cardName)){
                    dataString += cardName +";";
                    for(int i=0;i<tc.getArrows().size();i++){
                        dataString += tc.getArrows().get(i) +",";
                    }
                    dataString = dataString.substring(0, dataString.length()-1);
                    dataString += "\n";
                }
            }
            Files.write(Paths.get(StaticHelper.PATHTOUSERFILE, "userdata.txt"), dataString.getBytes());
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
