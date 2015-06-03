package game;

import data.Player;
import data.TetraCard;
import gui.StaticHelper;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SquarePanel extends CardPanel{
    private TetraCard containedCard;
    private HashMap<String,SquarePanel> accessibleSquares;
    private boolean playable;
    public Player owner;

    public SquarePanel(Boolean playable){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        containedCard = null;
        this.playable = playable;
        owner = null;
        accessibleSquares = new HashMap<String, SquarePanel>();
    }
    public void linkSquarePanel(String direction, SquarePanel sp){
        accessibleSquares.put(direction,sp);
    }
    public boolean isPlayable(){
        return playable;
    }

    public void setPlayable(boolean playable){this.playable = playable;}

    public void redraw(){
        if(this.containedCard != null){
            redraw(this.containedCard);
        }
    }
    public void redraw(String name){
        super.redraw(name);
    }

    public void redraw(TetraCard tc){
        super.redraw(tc.getName(), tc.getArrows());
        this.containedCard = tc;
    }
    public TetraCard getContainedCard(){
        return containedCard;
    }
    public void attack(){
        SquarePanel attackedSquare;
        boolean canDef;
        boolean win;
        for(String direction: accessibleSquares.keySet()){
            if(containedCard.canAccess(direction) && accessibleSquares.get(direction).getContainedCard() != null
                    && this.owner != accessibleSquares.get(direction).owner){
                attackedSquare = accessibleSquares.get(direction);
                canDef = attackedSquare.getContainedCard().canAccess(StaticHelper.getOppositeDirection(direction));
                if (canDef){
                    win = containedCard.assault(attackedSquare.getContainedCard());
                    if(win){
                       attackedSquare.owner = this.owner;
                    } else {
                        this.owner = attackedSquare.owner;
                        this.redraw();
                        attackedSquare.redraw();
                        break;
                    }
                }else{
                    attackedSquare.getContainedCard().switchSide();
                    attackedSquare.owner = this.owner;
                }
                this.redraw();
                attackedSquare.redraw();
            }
        }
    }
}
