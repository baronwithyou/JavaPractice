package HeadFirst.Chapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<>();
    public static void main(String []args){
        new Jukebox5().go();
    }

    class ArtistCompare implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSong("MySong.txt");
        // 可以直接打印ArrayList
        System.out.println(songList);
        TreeSet<Song> songTreeSet = new TreeSet<>();
        songTreeSet.addAll(songList);
        System.out.println(songTreeSet);
    }

    private void getSong(String path) {
        File file = new File(path);
        String message;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((message = bufferedReader.readLine()) != null) {
                addSong(message);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addSong(String message) {
        String[] tokens = message.split("/");
        songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
    }
}
