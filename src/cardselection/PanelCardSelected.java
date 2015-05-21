package cardselection;

import gui.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCardSelected extends JPanel {
    private ImagePanel[] panels = null;
    private JButton[] buttons = null;

    public PanelCardSelected(){
        this.setLayout(null);
        this.setBackground(Color.cyan);
        panels = new ImagePanel[5];
        buttons = new JButton[5];
        initComponent();
        addImagePanel();
        addImagePanel();
        addImagePanel();
        addImagePanel();
        addImagePanel();
    }

    private void initComponent(){
        int marginTop=5;
        for(int a = 0; a < panels.length;a++){

            panels[a] = new ImagePanel();
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
            hideImagePanel(a);
        }
    }

    private void hideImagePanel(int i){
        panels[i].setVisible(false);
        buttons[i].setVisible(false);
    }
    public void addImagePanel(){
        for(int i=0;i<panels.length;i++){
            if(!panels[i].isVisible()){
                panels[i].setVisible(true);
                buttons[i].setVisible(true);
                break;
            }
        }
        if(checkFull()){
            OpenPopup();
        }
    }
    public void removeImagePanel(int i){
       hideImagePanel(i);
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
        System.out.println("Hello World!");
    }

}
