package gui;

import cardselection.CardSelection;

import javax.swing.*;

public class FrameContainer extends JFrame{

    public FrameContainer(){
        this.setSize(600,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Tetramaster");
        //this.setContentPane(new GamePanel());
        this.setContentPane(new CardSelection(this));
    }

    public void start(){
        this.setVisible(true);
    }
}
