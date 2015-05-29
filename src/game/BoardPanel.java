package game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class BoardPanel extends JPanel {
    private HashMap<String,SquarePanel> boardSquares;

    public BoardPanel(){
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        boardSquares = new HashMap<String, SquarePanel>();
        initSquares();
    }
    private void initSquares(){
        for(int j=0;j<4;j++){
            for(int i=0;i<4;i++){
                SquarePanel temp = new SquarePanel(true);
                temp.setBounds(i*100,j*100,100,100);
                boardSquares.put(j + ":" + i,temp);
            }
        }
        for(String it: boardSquares.keySet()){
            add(boardSquares.get(it));
        }
    }
}
