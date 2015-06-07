package cardselection;

import data.TetraCard;
import data.User;
import gui.CardPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelCardCollection extends JPanel{
    private CardPanel[] panelsHorizontal = null;
    private CardPanel[] panelsVertical = null;
    private ArrowPanel[] arrowPanels = null;
    private PanelCardSelected selectedCards;
    private HashMap<String, ArrayList<TetraCard>> curdeck;
    public int curVerticalCounter;
    public int curHorizontalCounter;
    private String curCardString;

    public PanelCardCollection(User user,PanelCardSelected selectedCards){
        this.setLayout(null);
        this.setBackground(new Color(242,162,92));
        panelsHorizontal = new CardPanel[5];
        panelsVertical = new CardPanel[4];
        arrowPanels = new ArrowPanel[4];
        this.curdeck = user.getCardCollection();
        this.selectedCards = selectedCards;
        this.curHorizontalCounter = 0;
        this.curVerticalCounter = 0;
        initComponent();
        initCardContainers();
    }
    private void initComponent(){
        int marginLeft = 20;
        int marginTop = 190;

        arrowPanels[0] = new ArrowPanel();
        arrowPanels[0].setBounds(marginLeft,marginTop+22,25,25);
        arrowPanels[0].drawButton(4);
        arrowPanels[0].addMouseListener(new ActionArrow(this, "left"));
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
        panelsHorizontal[2].addMouseListener(new ActionAddSelectedCard(panelsHorizontal[2],selectedCards,curdeck,this));
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
        arrowPanels[3].addMouseListener(new ActionArrow(this, "right"));

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
        arrowPanels[1].addMouseListener(new ActionArrow(this,"top"));
        marginTopVerticalCards += 40;

        panelsVertical[3] = new CardPanel();
        panelsVertical[3].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 65;

        panelsVertical[2] = new CardPanel();
        panelsVertical[2].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 150;

        panelsVertical[1] = new CardPanel();
        panelsVertical[1].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 65;

        panelsVertical[0] = new CardPanel();
        panelsVertical[0].setBounds(marginLeft + 10, marginTopVerticalCards, 50, 50);
        marginTopVerticalCards += 65;

        arrowPanels[2] = new ArrowPanel();
        arrowPanels[2].setBounds(marginLeft + 22, marginTopVerticalCards, 25, 25);
        arrowPanels[2].drawButton(3);
        arrowPanels[2].addMouseListener(new ActionArrow(this, "bot"));
    }
    public void refresh(){
        initCardContainers();
    }
    public void initCardContainers(){
        hidePanels();
        ArrayList<String> temp = new ArrayList<String>(curdeck.keySet());
        curCardString = temp.get(curHorizontalCounter);
        if(curVerticalCounter - 2 >= 0){
            panelsVertical[0].redraw(curdeck.get(curCardString).get(curVerticalCounter - 2));
            panelsVertical[0].setVisible(true);
        }
        if(curVerticalCounter - 1 >= 0){
            panelsVertical[1].redraw(curdeck.get(curCardString).get(curVerticalCounter - 1));
            panelsVertical[1].setVisible(true);
        }
        if(curVerticalCounter + 1 < curdeck.get(curCardString).size()){
            panelsVertical[2].redraw(curdeck.get(curCardString).get(curVerticalCounter + 1));
            panelsVertical[2].setVisible(true);
        }
        if(curVerticalCounter + 2 < curdeck.get(curCardString).size()){
            panelsVertical[3].redraw(curdeck.get(curCardString).get(curVerticalCounter + 2));
            panelsVertical[3].setVisible(true);
        }
        if(curHorizontalCounter - 2 >= 0){
            panelsHorizontal[0].redraw(curdeck.get(temp.get(curHorizontalCounter - 2)).get(0));
            panelsHorizontal[0].setVisible(true);
        }
        if(curHorizontalCounter - 1 >= 0){
            panelsHorizontal[1].redraw(curdeck.get(temp.get(curHorizontalCounter - 1)).get(0));
            panelsHorizontal[1].setVisible(true);
        }
        panelsHorizontal[2].redraw(curdeck.get(temp.get(curHorizontalCounter)).get(curVerticalCounter));
        panelsHorizontal[2].setVisible(true);
        if(curHorizontalCounter + 1 < curdeck.size()){
            panelsHorizontal[3].redraw(curdeck.get(temp.get(curHorizontalCounter + 1)).get(0));
            panelsHorizontal[3].setVisible(true);
        }
        if(curHorizontalCounter + 2 < curdeck.size()){
            panelsHorizontal[4].redraw(curdeck.get(temp.get(curHorizontalCounter + 2)).get(0));
            panelsHorizontal[4].setVisible(true);
        }
    }
    public void incrementVerticalCounter(){
        if(curVerticalCounter + 1 < curdeck.get(curCardString).size()){
            curVerticalCounter++;
        }
    }
    public void incrementHorizontalCounter(){
        if(curHorizontalCounter + 1 < curdeck.size()){
            curHorizontalCounter++;
            curVerticalCounter = 0;
        }
    }
    private void hidePanels(){
        for(CardPanel cp:panelsHorizontal){
            cp.setVisible(false);
        }
        for(CardPanel cp:panelsVertical){
            cp.setVisible(false);
        }
    }
}
