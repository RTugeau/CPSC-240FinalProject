package src.src;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;

public class Roster {
   public static ArrayList<Player> roster = new ArrayList<>();
   public static ArrayList<String> teamNames = new ArrayList<>();
   public static ArrayList<Roster> rosterList = new ArrayList<>();
   public static Map<String, ArrayList<Player>> rosterMap = new HashMap<>();
   private String teamName;
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

   public double battingAvgCalc() {
      double sum = 0.0;
      for (Player s: roster) {
         sum += s.getBattingAvg();
      }
      double teamBattingAvg = sum/(roster.size());
      return teamBattingAvg;
   }

   public double fieldingPctCalc() {
      double sum = 0.0;
      for (Player s: roster) {
         sum += s.getFieldingPct();
      }
      double teamFieldPct = sum/(roster.size());
      return teamFieldPct;
   }

   public int getOverall() {
      int sum = 0;
      for (Player s:roster) {
         sum = sum+s.getPlayerRating();
      }
      int teamOverall = sum/(roster.size());
      return(teamOverall);
   }

   public String gameSim(Roster r) {
      Random rng = new Random();
      double rand = 0;
      if(r.getOverall() <= 78) {
         rand = rng.nextDouble(.350, .450);
      } else if(r.getOverall() > 78 && r.getOverall() <= 80) {
         rand = rng.nextDouble(.450, .550);
      } else {
         rand = rng.nextDouble(.550, .650);
      }
      double gsim = rng.nextDouble();
      if(gsim >= rand) {
         return ("The " + r.teamName + " Lost the game.");
      } else {
         return ("The " + r.teamName + " Won the game.");
      }
   }

   public String seasonSim(Roster r) {
      Random rng = new Random();
      double rand = 0;
      if(r.getOverall() <= 78) {
         rand = rng.nextDouble(.350, .450);
      } else if(r.getOverall() > 78 && r.getOverall() <= 80) {
         rand = rng.nextDouble(.450, .550);
      } else {
         rand = rng.nextDouble(.550, .650);
      }
      int games = 100;
      int wins = (int) Math.round(rand * games);
      int losses = games - wins;
      return ("The " + r.teamName + " record: " + wins + "-" + losses + ".");
   }
}
