package cardselection;

import javax.swing.*;
import java.awt.*;

import data.Player;
import data.User;
import gui.CardPanel;

public class PanelCardCollection extends JPanel{
    private CardPanel[] panelsHorizontal = null;
    private CardPanel[] panelsVertical = null;
    private ArrowPanel[] arrowPanels = null;
    private User user;

    public PanelCardCollection(User user){
        this.setLayout(null);
        this.setBackground(Color.green);
        panelsHorizontal = new CardPanel[5];
        panelsVertical = new CardPanel[4];
        arrowPanels = new ArrowPanel[4];
        this.user = user;
        initComponent();
    }
    private void initComponent(){
        int marginLeft = 20;
        int marginTop = 190;

        arrowPanels[0] = new ArrowPanel();
        arrowPanels[0].setBounds(marginLeft,marginTop+22,25,25);
        arrowPanels[0].drawButton(4);
        marginLeft += 40;

        panelsHorizontal[0] = new CardPanel();
        panelsHorizontal[0].setBounds(marginLeft,marginTop+10,50,50);
        marginLeft += 65;

        panelsHorizontal[1] = new CardPanel();
        panelsHorizontal[1].setBounds(marginLeft, marginTop + 10, 50, 50);
        marginLeft += 65;

        drawVerticalRow(marginLeft);

        panelsHorizontal[2] = new CardPanel();
        panelsHorizontal[2].setBounds(marginLeft, marginTop, 70, 70);
        marginLeft += 85;

        panelsHorizontal[3] = new CardPanel();
        panelsHorizontal[3].setBounds(marginLeft, marginTop + 10, 50, 50);
        marginLeft += 65;

        panelsHorizontal[4] = new CardPanel();
        panelsHorizontal[4].setBounds(marginLeft, marginTop + 10, 50, 50);
        marginLeft += 65;

        arrowPanels[3] = new ArrowPanel();
        arrowPanels[3].setBounds(marginLeft, marginTop + 22, 25, 25);
        arrowPanels[3].drawButton(2);

        for(CardPanel cp:panelsHorizontal){
            cp.setBorder(BorderFactory.createLineBorder(Color.black));
            add(cp);
        }
        for(CardPanel cp:panelsVertical){
            cp.setBorder(BorderFactory.createLineBorder(Color.black));
            add(cp);
        }
        for(ArrowPanel ap :arrowPanels){
            add(ap);
        }
    }
    private void drawVerticalRow(int marginLeft){
        int marginTopVerticalCards = 20;

        arrowPanels[1] = new ArrowPanel();
        arrowPanels[1].setBounds(marginLeft + 22, marginTopVerticalCards,25,25);
        arrowPanels[1].drawButton(1);
        marginTopVerticalCards += 40;

        panelsVertical[0] = new CardPanel();
        panelsVertical[0].setBounds(marginLeft+10,marginTopVerticalCards,50,50);
        marginTopVerticalCards += 65;

        panelsVertical[1] = new CardPanel();
        panelsVertical[1].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 150;

        panelsVertical[2] = new CardPanel();
        panelsVertical[2].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 65;

        panelsVertical[3] = new CardPanel();
        panelsVertical[3].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 65;

        arrowPanels[2] = new ArrowPanel();
        arrowPanels[2].setBounds(marginLeft + 22, marginTopVerticalCards, 25, 25);
        arrowPanels[2].drawButton(3);
    }

    public void initCardContainers(){

    }
}
