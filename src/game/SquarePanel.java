package game;

import data.TetraCard;
import gui.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends ImagePanel{
    private TetraCard containedCard;
    private SquarePanel[] accessibleSquares;
    private boolean playable;

    public SquarePanel(Boolean playable){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        containedCard = null;
        this.playable = playable;
    }

    public boolean isPlayable(){
        return playable;
    }

    public void setPlayable(boolean playable){this.playable = playable;}
}
