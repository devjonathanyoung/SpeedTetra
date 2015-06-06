package cardselection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRemoveImagePanel implements ActionListener {
    private int index;
    private PanelCardSelected pcs;

    public ActionRemoveImagePanel(int index,PanelCardSelected pcs){
        this.index= index;
        this.pcs = pcs;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        pcs.removeCardPanel(index);
    }
}
