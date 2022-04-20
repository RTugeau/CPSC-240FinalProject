package src.src;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static JFrame rosterFrame = new JFrame("Roster Frame");
    public static JFrame simOrTradeWindow = new JFrame("Sim & Trade Window");
    public static JFrame tradeWindow = new JFrame("Trade Window");
    public static JFrame gameSim = new JFrame("Game Simulator");
    public static JFrame seasonSim = new JFrame("Season Simulator");
    public static Enum tradeStatus = TradeStatus.NO_TEAM_SELECTED;
    public static boolean trading = false;
    public static boolean gameSiming = false;
    public static boolean seasonSiming = false;
    //public static JFrame currentFrame = new JFrame("Current JFrame");
    public static void main(String[] args) throws FileNotFoundException {
        rosterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rosterFrame.getContentPane().setLayout(new BoxLayout(rosterFrame.getContentPane(), BoxLayout.Y_AXIS));
        rosterFrame.setSize(300, 300);
        simOrTradeWindow.setSize(600, 600);
        tradeWindow.setSize(300, 300);
        gameSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameSim.getContentPane().setLayout(new BoxLayout(gameSim.getContentPane(), BoxLayout.Y_AXIS));
        seasonSim.setSize(300, 300);
        //seasonSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //seasonSim.getContentPane().setLayout(new BoxLayout(gameSim.getContentPane(), BoxLayout.Y_AXIS));
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
        addButton("Season Simulator", simOrTradeWindow);
    }


    public static void addButton(String text, JFrame f) {
        // add a button object
        JButton button = new JButton(text);
        button.addActionListener(new ButtonListener(text, f));
        f.getContentPane().add(button);
    }

    public static void simOrTradeWindow(String rosterName) {
        rosterFrame.setVisible(false);
        rosterName = rosterName.toLowerCase();
        //make the program close when the window closes
        simOrTradeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create the box layout
        simOrTradeWindow.getContentPane().setLayout(new BoxLayout(simOrTradeWindow.getContentPane(), BoxLayout.Y_AXIS));
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(12, 1));

        JPanel statGrid = new JPanel();
        statGrid.setLayout(new GridLayout());
        String f = ("POS"+" NAME "+" AVG "+" FPT "+" OVR");
        String playerSt = String.format(f);
        JTextField text = new JTextField(playerSt);
        statGrid.add(text);
        for (Player s: (Roster.rosterMap.get(rosterName))) {
            String player = (s.getPosition()+" "+s.getName()+" "+s.getBattingAvg()+" "+s.getFieldingPct()+" "+s.getPlayerRating());
            //String formatted = String.format("-%20", player);
            JTextField playerStats = new JTextField(player);
            //playerStats.addActionListener(new ButtonListener(s.getName(), Main.tradeWindow));
            grid.add(playerStats);
        }
        simOrTradeWindow.add(statGrid);
        simOrTradeWindow.add(grid);
        simOrTradeWindow.pack();
        simOrTradeWindow.setVisible(true);
    }
}