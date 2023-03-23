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
 * Test method for this project
 */
public class MusicPlayerTester
{

    /**
     * Test Song Constructor
     * @return True if the constructor work, false or not.
     */
    public static boolean testSongConstructor()
    {
        try
        {
            Song song1 = new Song("He's A Pirate",
                    "Klaus Badelt" ,
                    "audio/0.mid");
        }
        catch (IllegalArgumentException e)
        {
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    /**
     * Test song play back
     * @return True if work, false if not.
     */
    public static boolean testSongPlayback()
    {
        try
        {
            Song song1 = new Song("He's A Pirate",
                    "Klaus Badelt" ,
                    "audio/1.mid");
            song1.play();
            Thread.sleep(1000);
            return song1.isPlaying();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Test Song node
     * @return True if work, false if not.
     */
    public static boolean testSongNode()
    {
        Song song = new Song("He's A Pirate",
                "Klaus Badelt" ,
                "audio/1.mid");
        SongNode songNode = new SongNode(song);
        if (songNode.getSong() != song)
            return false;
        SongNode songNode1 = new SongNode(song, songNode);
        if (songNode1.getNext() != songNode)
            return false;
        try
        {
            SongNode songNode2 = new SongNode(null);
        }
        catch (IllegalArgumentException e)
        {
            return true;
        }
        return false;
    }

    /**
     * Test enqueue
     * @return true if work, false if not
     */
    public static boolean testEnqueue()
    {
        try
        {
            Song song1 = new Song("test1","hobbes","audio/1.mid");
            Song song2 = new Song("test2","hobbes","audio/2.mid");
            Song song3 = new Song("test4","yoko kanno","audio/4.mid");
            Playlist playlist = new Playlist();
            playlist.enqueue(song1);
            playlist.enqueue(song2);
            playlist.enqueue(song3);
            return playlist.peek() == song1;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Test Dequeue
     * @return true if work, false it not
     */
    public static boolean testDequeue()
    {
        try
        {
            Song song1 = new Song("test1","hobbes","audio/1.mid");
            Song song2 = new Song("test2","hobbes","audio/2.mid");
            Song song3 = new Song("test4","yoko kanno","audio/4.mid");
            Playlist playlist = new Playlist();
            playlist.enqueue(song1);
            playlist.enqueue(song2);
            playlist.enqueue(song3);
            if (playlist.dequeue() != song1)
                return false;
            if (playlist.dequeue() != song2)
                return false;
            if (playlist.dequeue() != song3)
                return false;
            return playlist.dequeue() == null;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Test Song Constructor: " + testSongConstructor());
        System.out.println("Test Song Playback: " + testSongPlayback());
        System.out.println("Test Song node: " + testSongNode());
        System.out.println("Test enqueue: " + testEnqueue());
        System.out.println("Test dequeue: " + testDequeue());
    }
}
