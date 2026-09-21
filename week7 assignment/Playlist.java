import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public int getSongCount() {
        return songCount;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("p.getSongs()[0] is still \"" + p.getSongs()[0] + "\"");
        System.out.println("Song count: " + p.getSongCount());
    }
}