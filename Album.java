

import java.util.ArrayList;
import java.util.LinkedList;
/**
 
 * @author     Marius Daniel Boncica Student Bucks New ID: 22045429
 * @version    0.1 (2022.10.29)
 * 
 * Modified by Marius Boncica 01/11/2022

 */
public class Album {  //declare album attributes
    private ArrayList<Song> songs;

    public Album(String title) { //album constructor
        this.songs = new ArrayList<Song>();

    }
    public void addSong(Song song)
    {
      songs.add(song);
    }
  
    /**
    Method to delete a song from the database album
    @return void
    */
    public void deleteSong(int id)
    {
      songs.remove(id);
    }
  
   
//method to find a song in the arraylist
    public Song findSong(String title){

        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
          //  System.out.println(title + "exist in the list");--not visible for better user experience with console
        }
      //  System.out.println(title + "is not in our list");--not  visible for better user experience with console
        return null;
        
    }
   //using boolean method to add a song from the arraylist to the Linkedlist
    public boolean addSong(String title, String artist, double playcount){
        if(findSong(title) == null){
            songs.add(new Song(title,artist,playcount));
            
       //  System.out.println(title + "successfully added to the list");  ---  not visible for better user experience with console
            return true;
        }
        else {
         // System.out.println("Song with name "+ title+ " already exist in the list");  visible for better user experience with console
            return false;
        }
    }
//method to get index song and added to the playlist
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            songs.add(this.songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with trackNumber "+trackNumber);
        return false;
    }
//method to  check if song title exist in the arraylist and to added 
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                songs.add(checkedSong);
                return true;
            }
        }
     System.out.println(title + "there is no such song in album");
        return false;
    }
   
  
   
}
