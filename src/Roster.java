package src.src;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class Roster {
   private ArrayList<Player> roster = new ArrayList<>();
   public Roster (String fileName) {
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
      for (Player p:roster) {
         System.out.println(p.getName());
      }
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
         return ("Your team Lost the game.");
      } else {
         return ("Your team Won the game.");
      }
   }
}
