import javax.swing.*;
import java.awt.*;

public class Changer implements Runnable{

    private final GUIChangeColor gui;

    Changer(GUIChangeColor gui){
        this.gui = gui;
    }

    @Override
    public void run() {
        JLabel lblTmp = new JLabel();
        while(true){
            if(gui.getChangeColor()){
                lblTmp.setBackground(Color.RED);
                lblTmp.setOpaque(true);
                gui.setLblColor(lblTmp);
            } else if (!gui.getChangeColor()){
                lblTmp.setBackground(Color.BLUE);
                lblTmp.setOpaque(true);
                gui.setLblColor(lblTmp);
            }
        }
    }
}
