package src.src;

public class Player {
    private String name;
    private String position;
    private int playerRating;
    private double battingAvg;
    private double fieldingPct;

    public Player(String name, String position, int playerRating, double battingAvg, double fieldingPct) {
        this.name = name;
        this.position = position;
        this.playerRating = playerRating;
        this.battingAvg = battingAvg;
        this.fieldingPct = fieldingPct;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPlayerRating() {
        return playerRating;
    }

    public double getBattingAvg() {
        return battingAvg;
    }

    public double getFieldingPct() {
        return fieldingPct;
    }
}
