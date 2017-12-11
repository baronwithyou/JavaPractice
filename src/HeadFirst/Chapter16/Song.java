package HeadFirst.Chapter16;

public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private String rating;
    private String bpm;

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String getArtist() {

        return artist;
    }

    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Song o) {
        return title.compareTo(o.getTitle());
    }

    public boolean equals(Object o) {
        Song s = (Song)o;
        return s.getTitle().equals(title);
    }

    public int hashCode() {
        return title.hashCode();
    }
}
