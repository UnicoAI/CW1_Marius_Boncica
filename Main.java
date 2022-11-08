

import java.util.*;

public class Main {
/**
 
 * @author     Marius Daniel Boncica Student Bucks New ID: 22045429
 * @version    0.1 (2022.10.29)
 * 
 * Modified by Marius Boncica 01/11/2022

 */

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        
// create album with songs to be stored and availabale to be added to the playlist
        Album album = new Album("Album1"); //create one album of songs stored

        album.addSong("Shivers","Ed Sheeran",677688);
        album.addSong("Flowers","ArrDee",662342);
        album.addSong("Seventeen Going Under","Sam Fender",65763432);
        album.addSong("Overseas","D-Block Europe",65763432);
        album.addSong("Come on home for Christmas","George Ezra",65763442);
        album.addSong("Sacrifice","The Weeknd",65763432);
        album.addSong("War","ArrDee & Aitch ",65763632);
        album.addSong("BMW","Bad Boy Chiller Crew",69763432);
        album.addSong("Starlight","Davw",654233432);
        album.addSong("Go","Cat Burns",65763432);
        album.addSong("Falling Back","Drake",65763432);
        album.addSong("Forget me","Lewis Capaldi",68888882);
       
        albums.add(album);  
//create a LinkedList of songs to behave like a playlist to who we add songs from the arraylist
        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("Shivers", playList);
        albums.get(0).addToPlayList("Flowers",playList);
        albums.get(0).addToPlayList("Seventeen Going Under",playList);
        albums.get(0).addToPlayList("Overseas",playList);
        albums.get(0).addToPlayList("Come on home for Christmas",playList);
        albums.get(0).addToPlayList("Sacrifice",playList);
        albums.get(0).addToPlayList("War",playList);
        albums.get(0).addToPlayList("BMW",playList);
        albums.get(0).addToPlayList("Starlight",playList);
        albums.get(0).addToPlayList("Go",playList);
        

//using the function of Linkedlist to start from index o we initialise playing from index 0
        play(playList);

    }


    private static void play(LinkedList<Song> playList){
        printMenu();
        Scanner sc = new Scanner(System.in); //open scanner for user input
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator(); //create iterator object
//1st message on console and print menu
        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " +"\n"+ listIterator.next().toString());
      
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
//using switch for creating menu options for the console
            switch (action){

                case 0:
                    System.out.println("Goodbye!");
                    System.out.println("===================================================================================");
                    quit = true;
                    break;

                case 1:  //play next song using iterator
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        System.out.println("===================================================================================");
                        forward = false;
                    }
                    break;
                case 2: //play previous song using iterator
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        System.out.println("===================================================================================");
                        forward = false;
                    }
                    break;

                case 3: //message alert when we reach the start of the linkedlist
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+"\n" +listIterator.previous().toString());
                            System.out.println("===================================================================================");
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                            System.out.println("===================================================================================");
                        }
                    }else { ////message alert when we reach the end of the linkedlist
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            System.out.println("===================================================================================");
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                            System.out.println("===================================================================================");
                            
                        }
                    }
                    break;

                case 4: //call method to print playlist songs
                System.out.println("===================================================================================");
                            
                System.out.println(
                    "||         Title          " + " ||     Artist Name          ||" + "     Play Count                ||");
                    System.out.println("===================================================================================");
                            
                    printList(playList);
                    
                   
                    break;
                case 5: //call method to print menu
                    printMenu();
                    break;
                    case 6: // searching for playcount number
                    Scanner newcount = new Scanner(System.in);
                    System.out.println("What number of PlayCount are you looking for?");
                     Double ssss = newcount.nextDouble();
                    

                     for(Song checkedSong : playList){
            if (checkedSong.getPlaycount().equals(ssss)){
             
                       System.out.println(ssss + "  is the Play Count number for  " + checkedSong.getTitle() + " --Arrtist Name--" + checkedSong.getArtist());
                       System.out.println("===================================================================================");
                       for (int index = 0; index < playList.size(); index++)
                       {        
                         Song s = playList.get(index);
                         if (s.getPlaycount() < checkedSong.getPlaycount())
                         {
                             System.out.print(playList.get(index+1));
                            printMenu();
                            
                         } else
                         {}
                 
                    }
            }
        }
                

                 
          
            
               
                     
                
                case 7:  //remove songs from playlist using iterator
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+ "\n"+listIterator.next().toString());
                       }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now Playing "+ "\n"+listIterator.previous().toString());
                       }
                    }
                    break;
                    case 8: //add songs to the playlist using only title of the song
                    Scanner newsong = new Scanner(System.in);
                    System.out.println("===================================================================================");
                    System.out.println("Wich song from our collection do you wanna add to a new playlist?");
                    System.out.println("Available Songs are: ");
                    System.out.println("Falling Back");
                    System.out.println("Forget me ");
                    System.out.println("===================================================================================");

                    
                    
                    albums.get(0).addToPlayList(newsong.nextLine(), playList);
                    
                    System.out.println(playList); // print playlist to see result off adding new song    
       System.out.println("Song " + newsong.nextLine()+ "added to the new playlist  ");
       System.out.println("===================================================================================");
     
       printMenu();
                }
            }
        }
    

   

    private static void printMenu(){  //menu list
        System.out.println(
              "===================================================================================");
        System.out.println(
                "     ||||||||||||||||||||            MENU            |||||||||||||||||||||\n ");
        System.out.println(
                "===================================================================================");
        System.out.println(
                "||     0 - To Quit                                                               ||\n"+
                "||     1 - To Play Next Song                                                     ||\n"+
                "||     2 - To Play Previous Song                                                 ||\n"+
                "||     3 - To Replay The Current Song                                            ||\n"+
                "||     4 - Print Playlist                                                        ||\n"+
                "||     5 - MENU                                                                  ||\n"+
                "||     6 - Find And Play A Playlist By the Play Count Number                     ||\n" +
                "||     7 - Delete Current Song                                                    ||\n" +
                "||     8 - Add New Song                                                          ||\n"
               );
                System.out.println(
             "===================================================================================");
    }

    private static void printList(LinkedList<Song> playList){ //style the console
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================================================================================");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("===================================================================================");
    }
    

}