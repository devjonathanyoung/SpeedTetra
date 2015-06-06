package gui;

import cardselection.CardSelection;
import game.GamePanel;

import javax.swing.*;

public class FrameContainer extends JFrame{

    public FrameContainer(){
        this.setSize(600,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Tetramaster");
        //this.setContentPane(new GamePanel(this));
        this.setContentPane(new CardSelection(this));
    }

    public void changeContentPane(JPanel newContent){
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.removeAll();
        contentPane.add(newContent);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void start(){
        this.setVisible(true);
    }
}
