package cardselection;

import data.User;
import gui.FrameContainer;

import javax.swing.*;
import java.awt.*;

public class CardSelection extends JLayeredPane{

    public static User user;
    private FrameContainer parent;
    private PanelCardCollection cardCollection;

    public CardSelection(FrameContainer parent){
        this.parent = parent;
        this.setSize(600,600);
        this.setLayout(null);
        user = new User("Player 1","load");
        initComponent();
    }

    private void initComponent(){
        JLabel title = new JLabel("Card Selection",SwingConstants.CENTER);
        title.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        title.setBounds(0,0,600,40);
        add(title);

        PanelCardSelected cardSelected = new PanelCardSelected(parent,user,this);
        cardSelected.setBounds(0,40,150,560);
        add(cardSelected);

        PanelPlayerInfo playerInfo = new PanelPlayerInfo(user);
        playerInfo.setBounds(455,80,130,100);
        add(playerInfo,2,0);

        cardCollection = new PanelCardCollection(user,cardSelected);
        cardCollection.setBounds(150,40,450,560);
        add(cardCollection,1,0);
    }
    public PanelCardCollection getCardCollection(){
        return cardCollection;
    }
}
