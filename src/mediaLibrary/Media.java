package mediaLibrary;

/**
 * Created by Anastasia on 05.12.2016.
 */

public abstract class Media {

    protected int id;
    protected String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return ""+this.id+" "+this.title;
    }
}
