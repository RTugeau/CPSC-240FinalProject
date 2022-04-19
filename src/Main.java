package src.src;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static JFrame rosterFrame = new JFrame("Roster Frame");
    public static JFrame simOrTradeWindow = new JFrame("Sim & Trade Window");
    public static JFrame tradeWindow = new JFrame("Trade Window");
    public static Enum tradeStatus = TradeStatus.NO_TEAM_SELECTED;
    public static boolean trading = false;
    //public static JFrame currentFrame = new JFrame("Current JFrame");
    public static void main(String[] args) {

        rosterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rosterFrame.getContentPane().setLayout(new BoxLayout(rosterFrame.getContentPane(), BoxLayout.Y_AXIS));

        Roster bears = new Roster("bears.txt");
        Roster defenders = new Roster("defenders.txt");
        Roster fusion = new Roster("fusion.txt");
        Roster hurricanes = new Roster("hurricanes.txt");
        Roster jumbos = new Roster("jumbos.txt");
        Roster legends = new Roster("legends.txt");
        Roster rapids = new Roster("rapids.txt");
        Roster wolves = new Roster("wolves.txt");

        addButton("Bears", rosterFrame);
        addButton("Defenders", rosterFrame);
        addButton("Fusion", rosterFrame);
        addButton("Hurricanes", rosterFrame);
        addButton("Jumbos", rosterFrame);
        addButton("Legends", rosterFrame);
        addButton("Rapids", rosterFrame);
        addButton("Wolves", rosterFrame);
        rosterFrame.pack();
        rosterFrame.setVisible(true);
        addButton("Trade", simOrTradeWindow);
        addButton("Game Simulator", simOrTradeWindow);
        System.out.println(bears.getOverall());

    }

    public static void addButton(String text, JFrame f) {
        // add a button object
        JButton button = new JButton(text);
        button.addActionListener(new ButtonListener(text, f));
        f.getContentPane().add(button);
    }

    public static void simOrTradeWindow(String rosterName) {
        rosterFrame.setVisible(false);
        //make the program close when the window closes
        simOrTradeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create the box layout
        simOrTradeWindow.getContentPane().setLayout(new BoxLayout(simOrTradeWindow.getContentPane(), BoxLayout.Y_AXIS));
        addButton("Trade", simOrTradeWindow);
        addButton("Game Simulator", simOrTradeWindow);
        simOrTradeWindow.pack();
        simOrTradeWindow.setVisible(true);
    }
}