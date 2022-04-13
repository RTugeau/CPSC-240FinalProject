package src.src;

public class Main {
    public static void main(String[] args) {
        Roster roster1 = new Roster("bears.txt");
        Roster roster2 = new Roster("defenders.txt");
        Roster roster3 = new Roster("fusion.txt");
        Roster roster4 = new Roster("hurricanes.txt");
        Roster roster5 = new Roster("jumbos.txt");
        Roster roster6 = new Roster("legends.txt");
        Roster roster7 = new Roster("rapids.txt");
        Roster roster8 = new Roster("wolves.txt");
        System.out.println(roster1.getOverall());
    }
}
