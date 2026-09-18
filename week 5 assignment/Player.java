import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }

    static String draftAndRank(Player[] players) {
        Player[] temp = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                temp[count++] = p;
            }
        }

        Player[] draftable = Arrays.copyOf(temp, count);
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i + 1)
              .append(". ")
              .append(draftable[i].getName());
            if (i < draftable.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}