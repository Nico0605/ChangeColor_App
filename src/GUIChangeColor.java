import javax.swing.*;
import java.awt.*;

public class GUIChangeColor extends JFrame {

    private boolean changeColor;
    private final JFrame frame;
    private JLabel lblColor;

    public boolean getChangeColor() {
        return changeColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    private void createPnlLabelCC(){
        JPanel pnlLabelCC = new JPanel();
        pnlLabelCC.setLayout(new GridLayout(1,3));

        lblColor = new JLabel();
        lblColor.setBackground(Color.RED);
        lblColor.setOpaque(true);

        pnlLabelCC.add(Box.createHorizontalStrut(30));
        pnlLabelCC.add(lblColor, BorderLayout.CENTER);
        pnlLabelCC.add(Box.createHorizontalStrut(30));
        frame.add(pnlLabelCC);
    }

    private void createPnlButtonCC(){
        JPanel pnlButtonCC = new JPanel();
        pnlButtonCC.setLayout(new GridLayout(1,5));

        JButton btnRed = new JButton("Red");
        btnRed.setBackground(Color.RED);
        btnRed.setOpaque(true);
        btnRed.setBorderPainted(false);

        btnRed.addActionListener(e -> changeColor = true);

        JButton btnBlue = new JButton("Blue");
        btnBlue.setBackground(Color.BLUE);
        btnBlue.setOpaque(true);
        btnBlue.setBorderPainted(false);

        btnBlue.addActionListener(e -> changeColor = false);

        pnlButtonCC.add(Box.createHorizontalStrut(30));
        pnlButtonCC.add(btnRed);
        pnlButtonCC.add(Box.createHorizontalStrut(30));
        pnlButtonCC.add(btnBlue);
        pnlButtonCC.add(Box.createHorizontalStrut(30));
        frame.add(pnlButtonCC);
    }

    GUIChangeColor(){
        frame = new JFrame("Change Color");
        frame.setLayout(new GridLayout(4,1));

        changeColor = true;

        Thread thread = new Thread(new Changer(this));
        thread.start();

        frame.add(Box.createHorizontalStrut(30));
        createPnlLabelCC();
        frame.add(Box.createHorizontalStrut(10));
        createPnlButtonCC();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
