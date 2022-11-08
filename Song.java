

public class Song { //create class song, declare attribute private
    private String title;
    private String artist;
    private double playcount;
   

    //create constructors
    public Song(String title, String artist, double playcount) {
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

    public Double getPlaycount(){
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