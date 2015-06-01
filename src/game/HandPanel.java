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
    private JPanel borderer;


    public HandPanel(Player player, GamePanel parent){
        this.player = player;
        this.parent = parent;
        this.setLayout(null);
        this.playerHandContent = player.getHand();
        borderer = new JPanel();
        borderer.setBackground(Color.red);
        updateCardDisplay();
    }

    public void updateCardDisplay(){
        int marginTop = 0;
        for(int i=0;i<playerHandContent.size();i++){
            ImagePanel cardContainer = new ImagePanel();
            cardContainer.setBounds(2, marginTop +2,80,80);
            ActionSetCardSelected ml = new ActionSetCardSelected(parent,this,i,player,cardContainer);
            cardContainer.addMouseListener(ml);
            TetraCard activeCard = playerHandContent.get(i);
            cardContainer.redraw(activeCard.getName(), activeCard.getArrows());
            this.add(cardContainer);
            marginTop += 85;
        }
    }

    public void borderize(int index){
        borderer.setBounds(0, index*85,84,84);
        add(borderer);
    }
    public void removeBorder(){
        remove(borderer);
    }
}
