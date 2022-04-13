package src.src;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
      int count=0;
      while (scnr.hasNextLine()) {
         count++;
         String playerName = scnr.nextLine();
         String position = scnr.nextLine();
         int playerRating = Integer.parseInt(scnr.nextLine());
         double battingAvg = Double.parseDouble(scnr.nextLine());
         double fieldingPct = Double.parseDouble(scnr.nextLine());
         roster.add(new Player(playerName, position, playerRating, battingAvg, fieldingPct));
         if (scnr.hasNextLine());
      }
      for (Player p:roster) {
         System.out.println(p.getName());
      }
   }

}
