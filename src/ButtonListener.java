package src.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ButtonListener implements ActionListener {
    // each button listener stores the name of the button
    private String buttonName;
    private JFrame currentFrame;
   // private Players_Selected numPlayersSelected;
    private static int numPlayersSelected = 0;
    private static String tradingPlayer1;
    private static String tradingPlayer2;
    private static JButton playerButton1;
    private static JButton playerButton1Copy;
    private static JButton playerButton2;
    private static JButton playerButton2Copy;
    private static String selectedTeam;
    public String tradingTeam1;
    public String tradingTeam2;
    // given the text when it's created
    public ButtonListener(String t, JFrame f) {
        buttonName = t;
        currentFrame = f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "You pushed button " + buttonName);
        if (buttonName == "Trade") {
            Main.trading = true;
        } else if (buttonName == "Game Simulator") {
            Main.gameSiming = true;
        } else if (buttonName == "Season Simulator") {
            Main.seasonSiming = true;
        }
        if (currentFrame.getTitle().equals("Roster Frame") && Main.trading == false) {
            Main.simOrTradeWindow(buttonName);
            selectedTeam = buttonName;
        } else if (currentFrame.getTitle().equals("Sim & Trade Window") && Main.trading == true) {
            Main.simOrTradeWindow.setVisible(false);
            Main.rosterFrame.add(new JLabel("Select the team you would like to trade with"), BorderLayout.NORTH);
            Main.rosterFrame.setVisible(true);
        } else if (currentFrame.getTitle().equals("Sim & Trade Window") && Main.gameSiming == true) {
            //Main.simOrTradeWindow.dispose();
            Roster.gameSim(selectedTeam);

        } else if (currentFrame.getTitle().equals("Roster Frame") && Main.trading == true) {
            if (Main.tradeStatus == TradeStatus.NO_TEAM_SELECTED) {
                Trade.tradingTeam1 = buttonName.toLowerCase();
                Main.tradeStatus = TradeStatus.ONE_TEAM_SELECTED;
            } else if (Main.tradeStatus == TradeStatus.ONE_TEAM_SELECTED) {
                Trade.tradingTeam2 = buttonName.toLowerCase();
                Main.tradeStatus = TradeStatus.TWO_TEAMS_SELECTED;
            }
        } else if (currentFrame.getTitle().equals("Trade Window") && Main.trading == true) {
            if (numPlayersSelected == 0) {
                ((JButton) e.getSource()).setBackground(Color.YELLOW);
                tradingPlayer1 = buttonName;
                playerButton1 = (JButton) e.getSource();
                playerButton1Copy = (JButton) e.getSource();
                numPlayersSelected++;
            } else if (numPlayersSelected == 1) {
                ((JButton) e.getSource()).setBackground(Color.YELLOW);
                numPlayersSelected = 0;
                tradingPlayer2 = buttonName;
                playerButton2 = (JButton) e.getSource();
                playerButton2Copy = (JButton) e.getSource();
                Trade.tradePlayer(tradingPlayer1, tradingPlayer2, playerButton1, playerButton2);
            }
        } else if (currentFrame.getTitle().equals("Game Simulator")) {
            Main.gameSim.setVisible(false);
            Main.simOrTradeWindow.setVisible(false);
            Main.rosterFrame.setVisible(true);
        } else if (currentFrame.getTitle().equals("Sim & Trade Window") && Main.seasonSiming == true) {
            Roster.seasonSim(selectedTeam);
        } else if (currentFrame.getTitle().equals("Season Simulator") && Main.seasonSiming == false) {
            Main.seasonSim.setVisible(false);
            Main.rosterFrame.setVisible(true);
        }
        if (Main.trading == true && Main.tradeStatus == TradeStatus.TWO_TEAMS_SELECTED) {
            Main.rosterFrame.setVisible(false);
            Trade.tradeWindow(Trade.tradingTeam1, Trade.tradingTeam2);
        }
    }
}
