package HeadFirst.Chapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class JukeBox6 {
    HashSet<Song> songList = new HashSet<>();
    public static void main(String []args){
        new JukeBox6().go();
    }

    public void go() {
        getSong("MySong.txt");
        // 可以直接打印ArrayList
        System.out.println(songList);
//        Collections.sort(songList);
//        System.out.println(songList);
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
