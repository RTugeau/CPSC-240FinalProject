package src.src;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math;

/**
 * this class Roster Class uses the players to save, calculated and make changes
 * based on the called method
 */
public class Roster {
   /**
    * set up the variables and arrayLists
    */
   private ArrayList<Player> roster = new ArrayList<>();
   public static ArrayList<String> teamNames = new ArrayList<>();
   public static ArrayList<Roster> rosterList = new ArrayList<>();
   public static Map<String, ArrayList<Player>> rosterMap = new HashMap<>();
   private String teamName;

   /**
    * this takes in the file and scans by each line for the
    * text file to be used, then sets to roster map
    * @param fileName
    */
   public Roster (String fileName) {
      this.teamName = fileName.split("\\.")[0];
      Scanner scnr = new Scanner(System.in);
      try {
         scnr = new Scanner (new File(fileName));
      } catch (FileNotFoundException e){
         System.out.println("File not found");
         System.exit(0);
      }
      while (scnr.hasNextLine()) {
         String playerName = scnr.nextLine();
         String position = scnr.nextLine();
         int playerRating = Integer.parseInt(scnr.nextLine());
         double battingAvg = Double.parseDouble(scnr.nextLine());
         double fieldingPct = Double.parseDouble(scnr.nextLine());
         roster.add(new Player(playerName, position, playerRating, battingAvg, fieldingPct));
      }
     // rosterList.add(roster);
      rosterMap.put(teamName, roster);
      teamNames.add(teamName);
   }

   /**
    * calculates the batting avg of the team
    * @return
    */
   public double battingAvgCalc() {
      double sum = 0.0;
      for (Player s: roster) {
         sum += s.getBattingAvg();
      }
      double teamBattingAvg = sum/(roster.size());
      return teamBattingAvg;
   }

   /**
    * calculates the fielding percentage of the team
    * @return
    */
   public double fieldingPctCalc() {
      double sum = 0.0;
      for (Player s: roster) {
         sum += s.getFieldingPct();
      }
      double teamFieldPct = sum/(roster.size());
      return teamFieldPct;
   }

   /**
    * calculates the overall of the team
    * @return
    */
   public int getOverall() {
      int sum = 0;
      for (Player s:roster) {
         sum = sum+s.getPlayerRating();
      }
      int teamOverall = sum/(roster.size());
      return(teamOverall);
   }

   /**
    * calculates the overall of the team to incorporate in the GUI
    * @param rosterName
    * @return
    */
   public static int getOverall2(String rosterName) {
      int teamOverall = 0;
      int sum = 0;
      for (Player s: (Roster.rosterMap.get(rosterName.toLowerCase()))) {
         sum = sum + s.getPlayerRating();
      }
      teamOverall = sum/(Roster.rosterMap.get(rosterName.toLowerCase()).size());
      return(teamOverall);
   }

   /**
    * this method uses the overall of the team to predict
    * your possibility of winning a game
    * @param teamName
    */
   public static void gameSim(String teamName) {
     // Main.rosterFrame.setVisible(false);
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(2, 1));
      Random rng = new Random();
      double rand = 0;
      if(getOverall2(teamName) <= 78) {
         rand = rng.nextDouble(.350, .450);
      } else if(getOverall2(teamName) > 78 && getOverall2(teamName) <= 80) {
         rand = rng.nextDouble(.450, .550);
      } else {
         rand = rng.nextDouble(.550, .650);
      }
      double gsim = rng.nextDouble();
      if (gsim >= rand) {
         JTextField j = new JTextField("The " + teamName + " Lost the game.");
         grid.add(j);
      } else {
         JTextField j = new JTextField("The " + teamName + " Won the game.");
         grid.add(j);
      }
      JButton button = new JButton("Return to roster selection");
      button.addActionListener(new ButtonListener(button.getName(), Main.gameSim));
      grid.add(button);
      Main.gameSim.add(grid);
      Main.gameSim.pack();
      Main.gameSim.setVisible(true);
   }

   /**
    * this method takes the overall as well of the team
    * and makes a random prediction and calculation
    * of your predicted record for that season
    * @param teamName
    */
   public static void seasonSim(String teamName) {
      Main.simOrTradeWindow.setVisible(false);
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(2, 1));
      Random rng = new Random();
      double rand = 0;
      if(getOverall2(teamName) <= 78) {
         rand = rng.nextDouble(.350, .450);
      } else if(getOverall2(teamName) > 78 && getOverall2(teamName) <= 80) {
         rand = rng.nextDouble(.450, .550);
      } else {
         rand = rng.nextDouble(.550, .650);
      }
      int games = 100;
      int wins = (int) Math.round(rand * games);
      int losses = games - wins;
      JTextField text = new JTextField("The " + teamName + " record: " + wins + "-" + losses + ".");
      grid.add(text);
      JButton button = new JButton("Return to roster selection");
      button.addActionListener(new ButtonListener(button.getName(), Main.seasonSim));
      grid.add(button);
      Main.seasonSim.add(grid);
      Main.seasonSim.setVisible(true);
      Main.seasonSiming = false;
   }

   /**
    * File Writer to update the text files
    * after a trade is made
    */
   public static void fileWriter() {
      for (String s : teamNames) {
         PrintWriter pw = null;
         try {
            pw = new PrintWriter(s + ".txt");
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         }
         for (Player f : (Roster.rosterMap.get(s))) {
            pw.println(f.getName());
            pw.println(f.getPosition());
            pw.println(f.getPlayerRating());
            pw.println(f.getBattingAvg());
            pw.println(f.getFieldingPct());
         }
         pw.close();
      }
   }
}
