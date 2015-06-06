package cardselection;

import data.TetraCard;
import data.User;
import game.GamePanel;
import gui.CardPanel;
import gui.FrameContainer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCardSelected extends JPanel {
    private CardPanel[] panels;
    private JButton[] buttons;
    private FrameContainer frameContainer;
    private User user;

    public PanelCardSelected(FrameContainer frameContainer, User user){
        this.user = user;
        this.frameContainer = frameContainer;
        this.setLayout(null);
        this.setBackground(Color.cyan);
        panels = new CardPanel[5];
        buttons = new JButton[5];
        initComponent();
    }

    private void initComponent(){
        int marginTop=5;
        for(int a = 0; a < panels.length;a++){
            panels[a] = new CardPanel();
            panels[a].setBounds(29,marginTop,77,77);
            panels[a].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(panels[a]);
            marginTop+=77;

            buttons[a] = new JButton("Remove");
            buttons[a].setFocusPainted(false);
            buttons[a].setBounds(29, marginTop, 77, 20);
            buttons[a].setMargin(new Insets(0, 0, 0, 0));
            buttons[a].addActionListener(new ActionRemoveImagePanel(a,this));
            marginTop+=25;

            add(buttons[a]);
            hideCardPanel(a);
        }
    }

    private void hideCardPanel(int i){
        panels[i].setVisible(false);
        buttons[i].setVisible(false);
    }
    public void addCardPanel(TetraCard tc){
        for(int i=0;i<panels.length;i++){
            if(!panels[i].isVisible()){
                panels[i].redraw(tc);
                panels[i].setVisible(true);
                buttons[i].setVisible(true);
                break;
            }
        }
        if(checkFull()){
            OpenPopup();
        }
    }
    public void removeCardPanel(int i){
       hideCardPanel(i);
    }

    private boolean checkFull(){
        boolean foundFree = true;
        for(int i=0;i<panels.length;i++){
            if(!panels[i].isVisible()){
                foundFree = false;
            }
        }
        return foundFree;
    }

    private void OpenPopup(){
        ArrayList<TetraCard> Hand = new ArrayList<TetraCard>();
        for(int i=0;i<panels.length;i++){
            Hand.add(panels[i].getContainedCard());
        }
        frameContainer.setContentPane(new GamePanel(frameContainer,user,Hand));
    }

}
