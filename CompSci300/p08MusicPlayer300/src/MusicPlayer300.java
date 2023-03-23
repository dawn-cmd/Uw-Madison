//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   HUAIYUAN JING
// Email:    hjing7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A linked-queue based music player which plays Actual Music Files
 * based on keyboard input in an interactive console method.
 * This music player can load playlists of music or add individual song files to the queue.
 */
public class MusicPlayer300
{
    /**
     * The current playlist of Songs
     */
    private Playlist playlist;

    /**
     * Whether the current playback mode should be filtered by artist; false by default
     */
    private boolean filterPlay;

    /**
     * The artist to play if filterPlay is true; should be null otherwise
     */
    private String filterArtist;

    /**
     * Creates a new MusicPlayer300 with an empty playlist
     */
    public MusicPlayer300()
    {
        this.playlist = new Playlist();
        this.filterArtist = null;
        this.filterPlay = false;
    }

    /**
     * Stops any song that is playing and clears out the playlist
     */
    public void clear()
    {
        while (!this.playlist.isEmpty())
        {
            Song now = this.playlist.dequeue();
            now.stop();
        }
    }

    /**
     * Loads a playlist from a provided file, skipping any individual songs which cannot be loaded.
     * Note that filenames in the provided files do NOT include the audio directory,
     * and will need that added before they are loaded.
     * Print "Loading" and the song's title in quotes before you begin loading a song,
     * and an "X" if the load was unsuccessful for any reason.
     * @param file the File object to load
     * @throws FileNotFoundException if the playlist file cannot be loaded
     */
    public void loadPlaylist(File file) throws FileNotFoundException
    {
        Scanner scnr = new Scanner(file);
        while (scnr.hasNextLine())
        {
            try
            {
                String[] tmp;
                tmp = scnr.nextLine().split(",");
                System.out.println("Loading " + tmp[0]);
                Song song = new Song(tmp[0], tmp[1], "audio/" + tmp[2]);
                this.playlist.enqueue(song);
            }
            catch (Exception e)
            {
                System.out.println("X");
            }
        }
    }

    /**
     * Loads a single song to the end of the playlist given the title, artist, and filepath.
     * Filepaths for P08 must refer to files in the audio directory.
     * @param title the title of the song
     * @param artist the artist of this song
     * @param filepath the full relative path to the song file, begins with the "audio" directory for P08
     */
    public void loadOneSong(String title,
                            String artist,
                            String filepath)
    {
        this.playlist.enqueue(new Song(title, artist, filepath));
    }

    /**
     * Provides a string representation of all songs in the current playlist
     * @return a string representation of all songs in the current playlist
     */
    public String printPlaylist()
    {
        return this.playlist.toString();
    }

    /**
     * Creates and returns the menu of options for the interactive console program.
     * @return the formatted menu String
     */
    public String getMenu()
    {
        return """
                Enter one of the following options:
                [A <filename>] to enqueue a new song file to the end of this playlist
                [F <filename>] to load a new playlist from the given file
                [L] to list all songs in the current playlist
                [P] to start playing ALL songs in the playlist from the beginning
                [P -t <Title>] to play all songs in the playlist starting from <Title>
                [P -a <Artist>] to start playing only the songs in the playlist by Artist
                [N] to play the next song
                [Q] to stop playing music and quit the program""";
    }

    /**
     * Stops playback of the current song (if one is playing) and advances to the next song in the playlist.
     * @throws IllegalStateException if the playlist is null or empty, or becomes empty at any time during this method
     */
    public void playNextSong()
            throws IllegalStateException
    {
        if (this.playlist.isEmpty())
            throw new IllegalStateException("Playlist is null");
        this.playlist.dequeue().stop();
        if (this.filterPlay)
            while (!this.playlist.isEmpty() && !this.playlist.peek().getArtist().equals(this.filterArtist))
                this.playlist.dequeue().stop();
        if (this.playlist.isEmpty())
            throw new IllegalStateException("Playlist is null");
        this.playlist.peek().play();
    }

    public void runMusicPlayer300(Scanner in)
    {
        System.out.println(this.getMenu());
        while (true)
        {
            System.out.print("> ");
            String[] todo = in.nextLine().split(" ");
            if (todo[0].equals("Q"))
            {
                while (!this.playlist.isEmpty())
                    playlist.dequeue().stop();
                System.out.println("Goodbye!");
                return;
            }
            if (todo[0].equals("A"))
            {
                String filename = todo[1];
                System.out.print("Title: ");
                String title = in.nextLine();
                System.out.print("Artist: ");
                String artist = in.nextLine();
                try
                {
                    this.playlist.enqueue(new Song(title, artist, filename));
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Unable to load the song");
                }
                System.out.print(this.printPlaylist());
                continue;
            }
            if (todo[0].equals("F"))
            {
                try {
                    this.loadPlaylist(new File(todo[1]));
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to load the playlist");
                }
                System.out.println(this.printPlaylist());
                continue;
            }
            if (todo[0].equals("L"))
            {
                System.out.print(this.playlist.toString());
                System.out.print(this.printPlaylist());
                continue;
            }
            if (todo[0].equals("P"))
            {
                if (todo.length == 1)
                {
                    if (this.playlist.isEmpty())
                    {
                        System.out.println("No songs left :(");
                    }
                    else{
                        this.playlist.peek().play();
                    }
                    System.out.print(this.printPlaylist());
                    continue;
                }
                if (todo[1].equals("-t"))
                {
                    while (!playlist.isEmpty() && !this.playlist.peek().getTitle().equals(todo[2]))
                        this.playlist.dequeue();
                    if (this.playlist.isEmpty())
                    {
                        System.out.println("No songs left :(");
                    }
                    else{
                        this.playlist.peek().play();
                    }
                    System.out.print(this.printPlaylist());
                    continue;
                }
                if (todo[1].equals("-a"))
                {
                    this.filterPlay = true;
                    this.filterArtist = todo[2];
                    try
                    {
                        this.playNextSong();
                    }
                    catch (IllegalStateException e)
                    {
                        System.out.println("No songs left :(");
                    }
                    System.out.print(this.printPlaylist());
                    continue;
                }
                System.out.println("I don't know how to do that.");
                System.out.print(this.printPlaylist());
                continue;
            }
            if (todo[0].equals("N"))
            {
                try
                {
                    this.playNextSong();
                }
                catch (IllegalStateException e)
                {
                    System.out.println("No songs left :(");
                }
                System.out.print(this.printPlaylist());
                continue;
            }
            System.out.println("I don't know how to do it.");
            System.out.print(this.printPlaylist());
        }
    }
}
