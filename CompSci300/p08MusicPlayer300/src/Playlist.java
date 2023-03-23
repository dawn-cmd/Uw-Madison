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

/**
 * A FIFO linked queue of SongNodes, conforming to our QueueADT interface.
 */
public class Playlist
        extends Object
        implements QueueADT<Song>
{

    /**
     * The current first song in the queue; the next one up to play (front of the queue)
     */
    private SongNode first;

    /**
     * The current last song in the queue; the most-recently added one (back of the queue)
     */
    private SongNode last;

    /**
     * The number of songs currently in the queue
     */
    private int numSongs;

    /**
     * Constructs a new, empty playlist queue
     */
    public Playlist()
    {
        this.first = null;
        this.last = null;
        this.numSongs = 0;
    }

    /**
     * Adds a new song to the end of the queue
     * @param element the song to add to the Playlist
     */
    @Override
    public void enqueue(Song element) {
        if (this.numSongs == 0)
        {
            SongNode now = new SongNode(element);
            this.first = now;
            this.last = now;
            this.numSongs = 1;
            return;
        }

        this.last.setNext(new SongNode(element));
        this.last = this.last.getNext();
        this.numSongs += 1;
    }

    /**
     * Removes the song from the beginning of the queue
     * @return the song that was removed from the queue, or null if the queue is empty
     */
    @Override
    public Song dequeue() {
        if (this.numSongs == 0)
            return null;
        if (this.numSongs == 1)
        {
            Song ans = this.first.getSong();
            this.first = null;
            this.last = null;
            this.numSongs = 0;
            return ans;
        }

        Song ans = this.first.getSong();
        this.first = this.first.getNext();
        this.numSongs -= 1;
        return ans;
    }

    /**
     * Returns the song at the front of the queue without removing it
     * @return the song that is at the front of the queue, or null if the queue is empty
     */
    @Override
    public Song peek() {
        if (this.numSongs == 0)
            return null;
        return this.first.getSong();
    }

    /**
     * Returns true if and only if there are no songs in this queue
     * @return true if this queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.numSongs == 0;
    }

    /**
     * Returns the number of songs in this queue
     * @return the number of songs in this queue
     */
    @Override
    public int size() {
        return this.numSongs;
    }

    /**
     * Creates and returns a formatted string representation of this playlist,
     * with the string version of each song in the list on a separate line. For example:
     *   "He's A Pirate" (1:21) by Klaus Badelt
     *   "Africa" (4:16) by Toto
     *   "Waterloo" (2:45) by ABBA
     *   "All I Want For Christmas Is You" (4:10) by Mariah Carey
     *   "Sandstorm" (5:41) by Darude
     *   "Never Gonna Give You Up" (3:40) by Rick Astley
     * @return the string representation of this playlist
     */
    @Override
    public String toString()
    {
        String ans = "";
        SongNode now = this.first;
        while (now != null)
        {
            ans += now.getSong().toString() + "\n";
            now = now.getNext();
        }
        return ans;
    }
}