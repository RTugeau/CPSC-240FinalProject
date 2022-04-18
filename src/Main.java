package src.src;

public class Main {
    public static void main(String[] args) {
        Roster roster1 = new Roster("bears.txt", "Bears");
        Roster roster2 = new Roster("defenders.txt", "Defenders");
        Roster roster3 = new Roster("fusion.txt", "Fusion");
        Roster roster4 = new Roster("hurricanes.txt", "Hurricanes");
        Roster roster5 = new Roster("jumbos.txt", "Jumbos");
        Roster roster6 = new Roster("legends.txt", "Legends");
        Roster roster7 = new Roster("rapids.txt", "Rapids");
        Roster roster8 = new Roster("wolves.txt", "Wolves");
        System.out.println(roster1.getOverall());
        System.out.println(roster2.getOverall());
        System.out.println(roster3.getOverall());
        System.out.println(roster4.getOverall());
        System.out.println(roster5.getOverall());
        System.out.println(roster6.getOverall());
        System.out.println(roster7.getOverall());
        System.out.println(roster8.getOverall());
        System.out.println(roster1.gameSim(roster1));
    }
}
