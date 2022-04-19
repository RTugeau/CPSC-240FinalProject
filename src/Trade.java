package src.src;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.*;
public class Trade {
    public static JFrame tradeWindow = new JFrame("Trade Window");
    public static String tradingTeam1;
    public static String tradingTeam2;
    public static void tradeWindow(String team1, String team2) {

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(12, 1));
        for (Player s: (Roster.rosterMap.get(team1))) {
            String name = s.getName();
            JButton button = new JButton(name);
            button.addActionListener(new ButtonListener(s.getName(), Main.tradeWindow));
            grid.add(button);
        }
        tradeWindow.add(grid);
        tradeWindow.pack();
        tradeWindow.setVisible(true);
    }
}