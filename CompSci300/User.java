///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: HUAIYUAN JING
// Campus ID: 9084099523
// WiscEmail: hing7@wisc.edu
// (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// BE CAREFUL!! This file contains TWO classes. You will need to complete the
// implementation of BOTH classes with respect to the provided requirements
// in the TODO tags for full credit.
//
// When creating new exception objects, including messages within these objects 
// is optional.
////////////////////////////////////////////////////////////////////////////////

// Note: no additional imports are allowed. These are required for this program's design.
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.sun.jdi.request.DuplicateRequestException;

/**
 * This class models the User data type, which represents a user of a general webpage with a
 * username and password.
 *
 * NOTES:
 * You may NOT add any additional data fields to this class unless specified in the TODO tags.
 * You may NOT add ANY additional methods to this class, regardless of access modifier.
 * There is no tester or main method for this class.
 */
public class User {
    // TODO
    // 1. Declare a protected instance field of type String named username
    protected String username;

    // 2. Declare a private instance field of type String named password
    private String password;

    // Note: usernameList stores all usernames that have been used by the constructor so far
    private static ArrayList<String> usernameList = new ArrayList<String>();

    /**
     * Creates a new User with the given username and password.
     *
     * @param username the user's unique identifier
     * @param password the user's password string
     * @throws IllegalArgumentException if the username is null or the password is null or empty
     * @throws DuplicateRequestException if this username is already in use. HINT: use ArrayList's
     * contains() method to see if a value is already present
     */
    public User(String username, String password) throws IllegalArgumentException, DuplicateRequestException {
        // TODO
        // 3. Check the validity of the input parameters and handle appropriately
        if (username == null || username.equals("") || password == null || password.equals("")) {
            throw new IllegalArgumentException("username or password invalid");
        }
        if (usernameList.contains(username)) {
            throw new DuplicateFormatFlagsException("the username is already in use");
        }

        // 4. Set the instance data fields to the provided input parameters
        this.username = username;
        this.password = password;

        // 5. Add this User's username to the list of current users
        usernameList.add(username);
    }

    /**
     * Verifies whether a provided string matches this user's password exactly (case-sensitive)
     * A null value should not match the user's password OR cause an exception.
     *
     * @param passwordAttempt the guessed password
     * @return true if and only if the passwordAttempt matches this User's password exactly
     */
    public boolean checkPassword(String passwordAttempt) {
        // TODO
        // 6. Complete the implementation of this method
        if (this.password.equals(passwordAttempt)) {
            return true;
        }

        // Note: A null value should not match the user's password OR cause an exception.

        return false; // default return statement added to avoid compiler errors. Feel free to change it.
    }

    /**
     * Changes the current password to the provided value.
     *
     * @param newPassword the new password string for this user
     */
    public void changePassword(String newPassword) {
        // TODO
        // 7. Complete the implementation of this mutator method
        if (password == null || password.equals("")) {
            return;
        }
        this.password = password;
        // Note: if the provided password is null or empty, do nothing
    }

    /**
     * Returns a string representation of this User. The returned string must have the following
     * format: username + ": " + [a number of '*' characters equal to the length of the password]
     * For example, "dispatchrabbi: **********"
     *
     * @return a string formatted as username + ": " + [a number of '*' characters equal to the length of the password]
     */
    @Override
    public String toString() {
        // TODO
        // 8. Complete the implementation of this method
        String result = this.username + ": ";
        for (int i = 0; i < this.password.length(); ++i) {result += "*";}

        // Hint: the String method "*".repeat(8) will return the string "********" (8 stars)

        return result; // default return statement added to avoid compiler errors. Feel free to change it.
    }

}

// Checkpoint: MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S)

/**
 * This class models the ForumUser data type, representing a user of a web forum which allows posts.
 *
 * NOTES:
 * You may NOT add any additional data fields to this class.
 * You may NOT add ANY additional methods to this class, regardless of access modifier.
 * There is no tester or main method for this class.
 */
class ForumUser extends User{ // TODO: 9. Set this class to be a subclass of the User class

    private int numPosts;     // the number of posts this ForumUser has made
    private boolean isBanned; // whether this ForumUser is currently allowed to make posts

    /**
     * Creates a new ForumUser with the provided username and password.
     *
     * @param username the user's unique identifier
     * @param password the user's password string
     * @throws DuplicateRequestException if this username is already in use
     * @throws IllegalArgumentException if the password is null or empty
     */
    public ForumUser(String username, String password) {
        // TODO
        // 10. Call the constructor of the super class with required arguments.
        // HINT: Do not catch any exceptions that it may throw. Let the exceptions propogate.
        super(username, password);

        // 11. Set the instance fields of this class to indicate that no posts have been made and
        // the user is currently allowed to make posts (is NOT banned).
        this.numPosts = 0;
        this.isBanned = false;
    }

    /**
     * Changes this ForumUser's isBanned status to true if it was false, and false if it was true.
     */
    public void toggleBan() {
        // TODO
        // 12. Complete the implementation of this mutator method
        if (this.isBanned) {
            this.isBanned = false;
        }
        else {
            this.isBanned = true;
        }
    }

    /**
     * Makes a post for this user if and only if the provided password is valid and the user is not
     * currently banned. Prints an error message to the console if the password is wrong or the user
     * is banned.
     *
     * @param password the password to check
     * @param postText the text of the post
     */
    public void makePost(String password, String postText) {
        // TODO
        // 13. Validate the provided password against the stored password using the super class method
        if (super.checkPassword(password) == false) {
            System.out.println("Password is wrong");
            return;
        }

        // 14. If the password was correct AND the user is not banned, increment this user's numPosts
        if (this.isBanned == false) {
            this.numPosts += 1;
            return;
        }

        // 15. In all other cases, print "Sorry, you are not allowed to post." to the console
        System.out.println("Sorry, you are not allowed to post.");
    }

    /**
     * Returns a string representation of this ForumUser. The returned string must have the following
     * format: username + ": " + <a number of '*' characters equal to the length of password> + " " + numPosts
     * For example, "dispatchrabbi: ********** 17"
     *
     * @return a string formatted as
     *   username + ": " + <a number of '*' characters equal to the length of password> + " " + numPosts
     */
    @Override
    public String toString() {
        // TODO
        // 16. Complete the implementation of this method.
        // Note: the password is a private data field with no accessor defined in the super class.
        // Use the toString() method from the User class to start your implementation.
        return super.toString() + " " + this.numPosts; // default return statement added to avoid compiler errors. Feel free to change it.
    }

    // MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) before submitting it to Gradescope

}
