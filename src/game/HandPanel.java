package game;

import data.Player;
import data.TetraCard;
import gui.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HandPanel extends JPanel{
    private int xOrigin;
    private int yOrigin;
    private Player player;
    private List<TetraCard> playerHandContent;
    private GamePanel parent;


    public HandPanel(int xOrigin, int yOrigin, Player player, List<TetraCard> playerHandContent, GamePanel parent){
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.player = player;
        this.playerHandContent = playerHandContent;
        this.parent = parent;
    }

    public void updateCardDisplay(){
        int marginTop = yOrigin;
        for(int i=0;i<playerHandContent.size();i++){
            ImagePanel cardContainer = new ImagePanel();
            cardContainer.setBounds(xOrigin,marginTop,77,77);
            cardContainer.redraw("");
            setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(cardContainer);
            marginTop += 82;
        }
    }
}
