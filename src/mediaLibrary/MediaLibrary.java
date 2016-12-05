package mediaLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anastasia on 05.12.2016.
 */
public class MediaLibrary {

    public List<Media> mediaList = new ArrayList<Media>();
    public List<Media> favorites = new ArrayList<Media>();
    protected static int _nextId = 1;

    public void add(Media media){
        media.id = _nextId;
        this.mediaList.add(media);
        _nextId++;
    }

    public List<Media> getAllMedia(){
        return mediaList;
    }

    public Media getMediaById(int id){
        Media resultMedia = null;
        for(Media media : mediaList)
        {
            if(media.id == id)
            {
                resultMedia = media;
            }
        }
        return resultMedia;
    }
    public boolean deleteFromList(int id, List<Media> media){
        Media mediaToRemove = getMediaById(id);
        if(mediaToRemove == null)
        {
            return false;
        }
        else
        {
            media.remove(mediaToRemove);
            return true;
        }
    }

    public List<Media> searchMediaByTitle(String title){
        List<Media> resultList = new ArrayList<Media>();
        for (Media media : mediaList)
        {
            if(media.title == title)
            {
                resultList.add(media);
            }
        }
        return resultList;
    }

    public boolean addFavorite(int id){
        Media mediaToRemove = getMediaById(id);
        if(mediaToRemove==null)
        {
            return false;
        }
        else
        {
            favorites.add(getMediaById(id));
            return true;
        }
    }

    public List<Media> getFavoriteList(){
        return favorites;
    }


}
