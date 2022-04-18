package src.src;
import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame("Button Example!");
    public static void main(String[] args) {
        // make the program close when the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create the box layout
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        Roster roster1 = new Roster("bears.txt");
        Roster roster2 = new Roster("defenders.txt");
        Roster roster3 = new Roster("fusion.txt");
        Roster roster4 = new Roster("hurricanes.txt");
        Roster roster5 = new Roster("jumbos.txt");
        Roster roster6 = new Roster("legends.txt");
        Roster roster7 = new Roster("rapids.txt");
        Roster roster8 = new Roster("wolves.txt");
        System.out.println(roster1.getOverall());
        frame.pack();
        frame.setVisible(true);
    }
    public static void addButton(String text, JFrame f) {
        // add a button object
        JButton button = new JButton(text);
        button.addActionListener(new ButtonListener(text));
        f.getContentPane().add(button);

    }
    public static void simOrTradeWindow(String rosterName) {
        frame.setVisible(false);
        JFrame frame2 = new JFrame("Sim or Trade Window");
        // make the program close when the window closes
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create the box layout
        frame2.getContentPane().setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
        addButton("Trade", frame2);
        addButton("Game Simulator", frame2);
        frame2.pack();

    }
}
