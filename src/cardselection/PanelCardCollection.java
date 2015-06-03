package cardselection;

import javax.swing.*;
import java.awt.*;
import gui.ImagePanel;

public class PanelCardCollection extends JPanel{
    private ImagePanel[] panelsHorizontal = null;
    private ImagePanel[] panelsVertical = null;
    private ImagePanel[] arrows = null;
    private JButton[] buttons = null;

    public PanelCardCollection(){
        this.setLayout(null);
        this.setBackground(Color.green);
        panelsHorizontal = new ImagePanel[5];
        panelsVertical = new ImagePanel[5];
        arrows = new ImagePanel[4];
        buttons = new JButton[10];
        initComponent();
    }

    /*
    DIMENSION : A RETENIR
    Image : 50 x 50
    Fleche : 25 x 25
    Button : 50 x 20
    espace : 5
    margin-top: 45
     */
    private void initComponent(){
        int marginLeft=0;

        arrows[0] = new ImagePanel();
        arrows[0].setBounds(marginLeft, 275, 25, 25);
        arrows[0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(arrows[0]);
        marginLeft+=25;
        //Espace
        marginLeft+=5;
        for(int a = 0; a < panelsHorizontal.length;a++){

            panelsHorizontal[a] = new ImagePanel();
            panelsHorizontal[a].setBounds(marginLeft,255,50,50);
            panelsHorizontal[a].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(panelsHorizontal[a]);
            buttons[a] = new JButton("Add");
            buttons[a].setFocusPainted(false);
            buttons[a].setBounds(marginLeft, 305, 50, 20);
            buttons[a].setMargin(new Insets(0, 0, 0, 0));
            add(buttons[a]);
            marginLeft+=50;
            marginLeft+=5;

        }
        arrows[1] = new ImagePanel();
        arrows[1].setBounds(marginLeft,275,25,25);
        arrows[1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(arrows[1]);

        // Vertical
        int marginTop = 45;
        arrows[2] = new ImagePanel();
        arrows[2].setBounds(225, marginTop, 25, 25);
        arrows[2].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(arrows[2]);
        marginTop+=25;
        //Espace
        marginTop+=5;
        for(int a = 0; a < panelsVertical.length;a++){

            panelsVertical[a] = new ImagePanel();
            panelsVertical[a].setBounds(205,marginTop,50,50);
            panelsVertical[a].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(panelsVertical[a]);

            marginTop+=50;
            marginTop+=5;

        }
        arrows[3] = new ImagePanel();
        arrows[3].setBounds(225,marginTop,25,25);
        arrows[3].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(arrows[3]);
    }
}
