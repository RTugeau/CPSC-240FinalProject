package src.src;

/**
 * this class is made to work with each individual player stat
 * in the given text files
 */
public class Player {
    /**
     * set up the instance variables and Player object
     * to get from the file
     */
    private String name;
    private String position;
    private int playerRating;
    private double battingAvg;
    private double fieldingPct;
    private Player player;

    /**
     * constructor for reading in the lines of the stats
     * @param s
     */
    public Player(Player s) {
        this.name = s.getName();
        this.position = s.getPosition();
        this.playerRating = s.getPlayerRating();
        this.battingAvg = s.getBattingAvg();
        this.fieldingPct = s.getFieldingPct();
    }

    /**
     * constructor to set the variables and initialize them
     * @param name
     * @param position
     * @param playerRating
     * @param battingAvg
     * @param fieldingPct
     */
    public Player(String name, String position, int playerRating, double battingAvg, double fieldingPct) {
        this.name = name;
        this.position = position;
        this.playerRating = playerRating;
        this.battingAvg = battingAvg;
        this.fieldingPct = fieldingPct;
    }

    /**
     * this method returns the name in the file
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returns the position that asked for
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * returns the player rating that is asked for
     * @return
     */
    public int getPlayerRating() {
        return playerRating;
    }

    /**
     * returns the batting average of the player
     * @return
     */
    public double getBattingAvg() {
        return battingAvg;
    }

    /**
     * returns the fielding percentage of the player
     * @return
     */
    public double getFieldingPct() {
        return fieldingPct;
    }
}
