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
import java.util.Scanner;

/**
 * A representation of a single Song.
 * Interfaces with the provided AudioUtility class,
 * which uses the javax.sound.sampled package to play audio to your computer's audio
 * output device
 */
public class Song
{
    /**
     * The artist of this song
     */
    private String artist;

    /**
     * This song's AudioUtility interface to javax.sound.sampled
     */
    private AudioUtility audioClip;

    /**
     * The duration of this song in number of seconds
     */
    private int duration;

    /**
     * The title of the song
     */
    private String title;

    public Song(String title,
                String artist,
                String filepath)
            throws IllegalArgumentException
    {
        try
        {
            this.audioClip = new AudioUtility(filepath);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("The song cannot be read");
        }
        this.title = title.equals("") ? null : title;
        this.artist = artist.equals("") ? null : artist;
        this.duration = this.audioClip.getClipLength();
    }

    /**
     * Tests whether this song is currently playing using the AudioUtility
     * @return true if the song is playing, false otherwise
     */
    public boolean isPlaying()
    {
        return this.audioClip.isRunning();
    }

    /**
     * Accessor method for the song's title
     * @return the title of this song
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Accessor method for the song's artist
     * @return the artist of this song
     */
    public String getArtist()
    {
        return this.artist;
    }

    /**
     * Uses the AudioUtility to start playback of this song,
     * reopening the clip for playback if necessary
     */
    public void play()
    {
        System.out.println("Playing " + this.toString());
        this.audioClip.startClip();
    }

    /**
     * Uses the AudioUtility to stop playback of this song
     */
    public void stop()
    {
        this.audioClip.stopClip();
    }

    /**
     * Creates and returns a string representation of this Song, for example:
     *     "Africa" (4:16) by Toto
     * The title should be in quotes,
     * the duration should be split out into minutes and seconds (recall it is stored as seconds only!),
     * and the artist should be preceded by the word "by".
     * It is intended for this assignment to leave single-digit seconds represented as 0:6,
     * for example, but if you would like to represent them as 0:06, this is also allowed.
     * @return a formatted string representation of this Song
     */
    @Override
    public String toString()
    {
        return "\"" + this.title + "\" "
                + "(" + this.duration / 60 + ":" + this.duration % 60 + ") "
                + "by " + this.artist;
    }
}
