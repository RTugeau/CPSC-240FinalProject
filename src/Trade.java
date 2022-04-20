package src.src;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Set;

public class Trade {
    public static JFrame tradeWindow = new JFrame("Trade Window");
    public static String tradingTeam1;
    public static String tradingTeam2;
    public static String tradingPlayer1;
    public static String tradingPlayer2;
    public static void tradeWindow(String team1, String team2) {

        tradeWindow.setSize(600, 600);
        JPanel bigGrid = new JPanel();
        bigGrid.setLayout(new GridLayout(1, 2));
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(12, 1));
        for (Player s: (Roster.rosterMap.get(team1))) {
            String name = s.getName();
            JButton button = new JButton(name);
            button.addActionListener(new ButtonListener(s.getName(), Main.tradeWindow));
            grid.add(button);
        }
        JPanel grid2 = new JPanel();
        grid2.setLayout(new GridLayout(12, 1));
        for (Player s: (Roster.rosterMap.get(team2))) {
            String name = s.getName();
            JButton button = new JButton(name);
            button.addActionListener(new ButtonListener(s.getName(), Main.tradeWindow));
            grid2.add(button);
        }
        bigGrid.add(grid);
        bigGrid.add(grid2);
        tradeWindow.add(bigGrid);
        tradeWindow.pack();
        tradeWindow.setVisible(true);
        Main.tradeStatus = TradeStatus.NO_TEAM_SELECTED;
    }
    public static void tradePlayer(String player1, String player2, JButton playerButton1, JButton playerButton2) {
        //Set<String> keySet = Roster.rosterMap.keySet();
        for (Player s: (Roster.rosterMap.get(tradingTeam1))) {
            for (Player f: (Roster.rosterMap.get(tradingTeam2))) {
                if (s.getName().equals(player1) && f.getName().equals(player2)) {
                    System.out.println(s.getName()+" "+f.getName());
                    Player copy_s = new Player(s);
                    Player copy_f = new Player(f);
                    int player1Index = Roster.rosterMap.get(tradingTeam1).indexOf(s);
                    int player2Index = Roster.rosterMap.get(tradingTeam2).indexOf(f);
                    Roster.rosterMap.get(tradingTeam1).set(player1Index, f);
                    Roster.rosterMap.get(tradingTeam2).set(player2Index, s);
                    System.out.println(s.getName()+" "+f.getName());
                }
            }
        }
        tradeWindow.setVisible(false);
        Main.rosterFrame.setVisible(true);
        Main.trading = false;
        Roster.fileWriter();
    }
}