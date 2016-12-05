package main;

import mediaLibrary.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Anastasia on 05.12.2016.
 */
public class Main {

    public static final String MEDIA_XML = "media.xml";
    public static final String FAVORITEMEDIA_XML = "favoriteMedia.xml";
    public static final String WELCOME = "Enter command or ask for help";
    public static final String PROMPT = ">>>";
    public static final String HELP_MENU = "help";
    public static final String ADD_BOOK = "add_book";
    public static final String ADD_SONG = "add_song";
    public static final String ADD_VIDEO = "add_video";
    public static final String MEDIA_LIST = "list";
    public static final String DELETE_FROM_LIST = "delete";
    public static final String SEARCH_BY_TITLE = "search_by_title";
    public static final String ADD_TO_FAVORITE = "add_to_favorite";
    public static final String FAVORITE_LIST = "favorite_list";
    public static final String DELETE_FROM_FAVORITE_LIST = "delete_from_favorite";
    public static final String EXIT = "exit";
    public static final String BYE = "bye";
    public static final String MENU = "add_book <Author> <Name>\nadd_video <Name>\nadd_song <Artist> <Name>\nlist\ndelete <id>\nsearch_by_title <Title>\nadd_to_favorite <id>\nfavorite_list\ndelete_from_favorite <id>\nexit";
    public static final String WRONG_VIDEO_INPUT = "wrong input\nadd_video <Name>";
    public static final String WRONG_BOOK_INPUT = "wrong input\nadd_book <Author> <Name>";
    public static final String WRONG_SONG_INPUT = "wrong input\nadd_song <Artist> <Name>";
    public static final String WRONG_DELETE_INPUT = "wrong input\ndelete <id>";
    public static final String NO_MEDIA = "No such media";
    public static final String WRONG_SEARCH_INPUT = "wrong input\nsearch_by_title <Title>";
    public static final String WRONG_INPUT = "no such command. try help";

    public static final char[] QUOTE_ARRAY = new char[] {'"'};

    public static MediaLibrary ml = new MediaLibrary();
    public static String userCommand = "";

    public static void main(String [] args){

        System.out.println(WELCOME);
        startLoop();
    }

    private static void startLoop(){
        Scanner sc = new Scanner(System.in);
        String[] mainCommand;
        while(true)
        {
            System.out.print(PROMPT);
            userCommand  = sc.nextLine();
            mainCommand = userCommand.split(" ");
            if (mainCommand.length<1)
            {
                wrongInput();
                continue;
            }

            switch (mainCommand[0])
            {
                case HELP_MENU:
                    helpMenu();
                    break;
                case ADD_BOOK:
                    addNewBookToList();
                    break;
                case ADD_SONG:
                    addNewSongToList();
                    break;
                case ADD_VIDEO:
                    addNewVideoToList();
                    break;
                case MEDIA_LIST:
                    listOfMedia();
                    break;
                case DELETE_FROM_LIST:
                    deleteFromList(ml.getAllMedia());
                    break;
                case SEARCH_BY_TITLE:
                    searchByTitle();
                    break;
                case ADD_TO_FAVORITE:
                    addToFavorite();
                    break;
                case FAVORITE_LIST:
                    favoriteList();
                    break;
                case DELETE_FROM_FAVORITE_LIST:
                    deleteFromList(ml.getFavoriteList());
                    break;
                case EXIT:
                    System.out.println(BYE);
                    return;
                default:
                    wrongInput();
                    break;
            }
        }
    }

    public static void helpMenu(){
        System.out.println(MENU);
    }

    public static void addNewVideoToList(){
        String[] array = userCommand.split(" ");
        if(array.length != 2)
        {
            System.out.println(WRONG_VIDEO_INPUT);
        }
        else
        {
            ml.add(new Video(array[1]));
        }
    }

    public static void addNewBookToList(){
        String[] array = userCommand.split(" ");
        if(array.length != 3)
        {
            System.out.println(WRONG_BOOK_INPUT);
        }
        else
        {
            ml.add(new Book(array[2],array[1]));
        }
    }

    public static void addNewSongToList(){
        String[] array = userCommand.split(" ");
        if(array.length !=3)
        {
            System.out.println(WRONG_SONG_INPUT);
        }
        else
        {
            ml.add(new Audio(array[2],array[1]));
        }
    }
    public static void listOfMedia(){
        for (Media media : ml.getAllMedia())
        {
            System.out.println(media.toString());
        }
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void deleteFromList( List<Media> media){
        String[] array = userCommand.split(" ");
        if(array.length!=2)
        {
            System.out.println(WRONG_DELETE_INPUT);
        }
        else
        {
            try {
                int id = Integer.parseInt(array[1]);
                if (!ml.deleteFromList(id, media)) {
                    System.out.println(NO_MEDIA);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(NO_MEDIA);
            }
        }

    }

    public static void searchByTitle(){
        String[] array = userCommand.split(" ");
        if(array.length!=2)
        {
            System.out.println(WRONG_SEARCH_INPUT);
        }
        else
        {
            for(Media media : ml.searchMediaByTitle(array[1]))
            {
                System.out.println(media.toString());
            }
        }
    }

    public static void addToFavorite(){

        String[] array = userCommand.split(" ");
        if(array.length!=2)
        {
            System.out.println(WRONG_INPUT);
        }
        else
        {
            try {
                int id = Integer.parseInt(array[1]);
                if (!ml.addFavorite(id)) {
                    System.out.println(NO_MEDIA);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(NO_MEDIA);
            }
        }
    }

    public static void favoriteList(){
        for(Media media : ml.getFavoriteList())
        {
            System.out.println(media.toString());
        }
    }

    public static void wrongInput(){
        System.out.println(WRONG_INPUT);
    }

}
