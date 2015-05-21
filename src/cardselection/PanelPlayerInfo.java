package cardselection;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PanelPlayerInfo extends JPanel {

    private HashMap<String,Integer> playerInfo;
    private int marginTop = 0;

    public PanelPlayerInfo(){
        this.setBackground(Color.pink);
        this.setLayout(null);
        getPlayerInfo();
        initComponent();
    }

    private void initComponent(){
        addLabel("Win");
        addLabel("Lose");
        addLabel("Draw");
        addLabel("NbCartesT");
        addLabel("NbCartesU");
    }

    private void addLabel(String labelname){
        JLabel temp = new JLabel(labelname + " : " + playerInfo.get(labelname),SwingConstants.CENTER);
        temp.setBounds(0,marginTop,130,20);
        marginTop += 20;
        add(temp);
    }

    private void getPlayerInfo(){
        playerInfo = new HashMap<String, Integer>();
        playerInfo.put("Win",0);
        playerInfo.put("Lose",0);
        playerInfo.put("Draw",0);
        playerInfo.put("NbCartesT", 0);
        playerInfo.put("NbCartesU", 0);
    }
}
