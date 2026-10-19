
import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("First song: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
