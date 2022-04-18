package src.src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonListener implements ActionListener {
    // each button listener stores the name of the button
    private String text;
    // given the text when it's created
    public ButtonListener(String t) {
        text = t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "You pushed button " + text);
        Main.simOrTradeWindow(text);
    }
}
