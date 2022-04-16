import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<Song>();
    }

    public boolean addSong(String titleOfSong,double duration){
        if (findSong(titleOfSong)==null){
            this.songs.add(new Song(titleOfSong,duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
        if ((index>=0)&&(index<=this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album doesn't have a "+ trackNumber);
        return false;
    }

    public boolean addToPlayList(String title,LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if (checkedSong!=null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song "+title+" is not in the album");
        return false;

    }











    private Song findSong(String title){
        for (Song checkedSong:this.songs){
            if (checkedSong.getTitle().equals(title));
                return checkedSong;
        }
        return null;
    }
}
