package cardselection;

import data.User;
import gui.FrameContainer;

import javax.swing.*;

public class CardSelection extends JLayeredPane{

    private User user;
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
        JLabel title = new JLabel("Tetramaster",SwingConstants.CENTER);
        title.setBounds(0,0,600,40);
        add(title);

        PanelCardSelected cardSelected = new PanelCardSelected(parent,user,this);
        cardSelected.setBounds(0,40,150,560);
        add(cardSelected);

        PanelPlayerInfo playerInfo = new PanelPlayerInfo();
        playerInfo.setBounds(455,60,130,100);
        add(playerInfo,2,0);

        cardCollection = new PanelCardCollection(user,cardSelected);
        cardCollection.setBounds(150,40,450,450);
        add(cardCollection,1,0);
    }
    public PanelCardCollection getCardCollection(){
        return cardCollection;
    }
}
