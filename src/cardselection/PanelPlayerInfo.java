package cardselection;

import data.User;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PanelPlayerInfo extends JPanel {

    private HashMap<String,Integer> playerInfo;
    private int marginTop = 0;
    private User user;

    public PanelPlayerInfo(User user){
        this.user = user;
        this.setBackground(Color.pink);
        this.setLayout(null);
        getPlayerInfo();
        initComponent();
    }

    private void initComponent(){
        addLabel("Win");
        addLabel("Lose");
        addLabel("Draw");
        addLabel("Total  Cards");
        addLabel("Unique Cards");
    }

    private void addLabel(String labelname){
        JLabel temp = new JLabel(labelname + " : " + playerInfo.get(labelname),SwingConstants.CENTER);
        temp.setBounds(0,marginTop,130,20);
        marginTop += 20;
        add(temp);
    }

    private void getPlayerInfo(){
        playerInfo = new HashMap<String, Integer>();
        playerInfo.put("Win",user.nbVictory);
        playerInfo.put("Lose",user.nbDefeat);
        playerInfo.put("Draw",user.nbDraw);
        int nbCardTotal = 0;
        for(String s: user.getCardCollection().keySet()){
            nbCardTotal += user.getCardCollection().get(s).size();
        }
        playerInfo.put("Total  Cards", nbCardTotal);
        playerInfo.put("Unique Cards", user.getCardCollection().size());
    }
}
