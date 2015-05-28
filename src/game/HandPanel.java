package game;

import data.Player;
import data.TetraCard;
import gui.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HandPanel extends JPanel{
    private Player player;
    private List<TetraCard> playerHandContent;
    private GamePanel parent;


    public HandPanel(Player player, GamePanel parent){
        this.player = player;
        this.parent = parent;
        this.setLayout(null);
        this.playerHandContent = player.getHand();
        updateCardDisplay();
    }

    public void updateCardDisplay(){
        int marginTop = 0;
        for(int i=0;i<playerHandContent.size();i++){
            ImagePanel cardContainer = new ImagePanel();
            cardContainer.setBounds(0, marginTop,80,80);
            ActionSetCardSelected ml = new ActionSetCardSelected(parent,this,i,player,cardContainer);
            cardContainer.addMouseListener(ml);
            cardContainer.redraw("");
            cardContainer.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(cardContainer);
            marginTop += 85;
        }
    }
}
