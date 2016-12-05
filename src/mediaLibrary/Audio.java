package mediaLibrary;
import mediaLibrary.Media;

/**
 * Created by Anastasia on 05.12.2016.
 */

public class Audio extends Media{

    protected String author;

    public Audio(){

    }

    public Audio(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return ""+id+" "+author+" - "+title;
    }
}
