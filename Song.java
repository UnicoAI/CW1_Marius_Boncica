
/**
 
 * @author     Marius Daniel Boncica Student Bucks New ID: 22045429
 * @version    0.1 (2022.10.29)
 * 
 * Modified by Marius Boncica 01/11/2022

 */
public class Song { //create class song, declare attribute private
    
    private String title;
    private String artist;
    private int playcount;
   

    //create constructors
    public Song(String title, String artist, int playcount) {
        this.title = title;
        this.artist = artist;
        this.playcount = playcount;
    }

    

   
   //create getter so we can refer to them in other classes such as album class

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public  int getPlaycount(){
        return playcount;
    }
    //override tostring method to print values of objects instead of allocated storage memory index
    @Override //make a style to display song details
    public String toString() {
        return "===================================================================================\n" +
        "|| "  +
                " |Title: " +"||"+ title + "||"+ 
                " |Artist Name:  " + "||"+artist  + "||" + " |Play Count: " + " ||"+playcount +"||" +
                " ||  \n"+ "===================================================================================";
                
    }
}
