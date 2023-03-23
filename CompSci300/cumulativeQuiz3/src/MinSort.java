///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: HUAIYUAN JING
// Campus ID: 9084099523
// WiscEmail: hjing7@wisc.edu
// (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

/**
 * This is a static, utility class containing methods to accomplish a recursive
 * sort of an array of Book objects. You do NOT have to implement the Book class;
 * it is provided for you in its entirety at the bottom of this file.
 */
public class MinSort {
  
  /**
   * Finds the "smallest" Book using a recursive helper method.
   * 
   * @param bookshelf a full, perfect-size array of Books with length >= 1
   * @return the Book from that shelf which is smaller than every other Book
   */
  public static Book getMinValue(Book[] bookshelf) {
    // suppose the first element of the shelf is the smallest
    Book minBook = bookshelf[0];
    
    // get the smaller of minBook and the elements in the rest of the array
    return getMinValueHelper(minBook, bookshelf, 1);
  }
  
  /**
   * A recursive helper method to find the smaller of:
   *   - the argument minBook, and
   *   - the smallest Book in the rest of bookshelf, from index to the end of the array
   * 
   * @param minBook the minimum value over all indexes 0 through index-1 (inclusive)
   * @param bookshelf a full, perfect-size array of Books with length >= 1
   * @param index the first index of the un-searched part of the bookshelf. 
   *     valid values: 1 to bookshelf.length (inclusive)
   *     If index == bookshelf.length, the un-searched part of the bookshelf is empty.
   * @return the minimum value over all indexes
   */
  private static Book getMinValueHelper(Book minBook, Book[] bookshelf, int index) {
    /////////// BASE CASE ///////////
    // TODO
    // 1. If the un-searched part of the shelf is empty, return the smallest book
    if (index == bookshelf.length)
      return minBook;
    ///////// RECURSIVE CASE ////////
    // TODO
    // 2. Define the recursive case for this algorithm
    // 3. Return the smallest book
    if (minBook.compareTo(bookshelf[index]) > 0) {
      minBook = bookshelf[index];
    }
    return getMinValueHelper(minBook, bookshelf, index + 1); // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /**
   * A tester method for getMinValue, which you must complete. This method WILL be tested.
   * 
   * @return true if getMinValue produces the expected result; false otherwise
   */
  public static boolean testGetMinValue() {
    // TODO
    // 4. Create a Book[] array containing at least 3 Book objects with different titles (see
    // testMinSort() below for examples)
    Book[] testShelf = new Book[] {new Book("Mockingjay", "Collins"),
            new Book("The Sparrow", "Mary Doria Russell"),
            new Book("2001", "Arthur C Clarke"),
            new Book("Noor", "Nnedi Okorafor")};
    // 5. Create a NEW Book object that matches the Book in the array that has the alphabetically
    Book[] expectedShelf = new Book[] {new Book("2001", "Arthur C Clarke"),
            new Book("Mockingjay", "Collins"),
            new Book("Noor", "Nnedi Okorafor"),
            new Book("The Sparrow", "Mary Doria Russell")};
    // smallest title (e.g. for Books ["A", "B", "C"], you'd create a new Book ca//Call getMinValue() on your Book[] array and save the result
    Book ans = getMinValue(testShelf);
    // 7. Compare this result against your expected value and return false if they do not match.
    // CAREFUL: the equals() method is NOT overridden in the Book class. To find equivalent Book
    // objects, use Book's compareTo() method.
    // OPTIONAL: implement additional tests to verify the method works!
    if (ans.compareTo(expectedShelf[0]) == 0) {
      return true;
    }
    // 8. Return true if all tests in this method are passed.
    return false;
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////
  //                                                                                         //
  // Checkpoint: SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) and RUN THIS TEST before you continue. //
  //                                                                                         //
  /////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Returns a new array of size bookshelf.length-1 which contains every Book in bookshelf that is NOT
   * the Book to remove. The method should NOT make any changes to the contents of bookshelf.
   *
   * Note that while there is no equals() method defined in Book, equal Books will have a compareTo() 
   * value of 0.
   * 
   * @param bookshelf a full, perfect-size array of Books with length >= 1
   * @param toRemove the Book to remove from the shelf
   * @return an array containing every Book from bookshelf EXCEPT toRemove, and NO null values
   */
  public static Book[] removeBook(Book[] bookshelf, Book toRemove) {
    // TODO
    // 9. Create a new Book array of the correct size
    Book[] result = new Book[bookshelf.length - 1];
    // 10. Iterate through the bookshelf and add all Books that are NOT the Book toRemove
    // (You may assume there are no duplicates.)
    int id = 0;
    for (Book book: bookshelf) {
      if (book.compareTo(toRemove) == 0) {
        continue;
      }
      result[id] = book;
      id += 1;
    }
    // 11. Return the resulting array
    return result; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /**
   * A tester method for removeBook, which you must complete. This method WILL be tested.
   * 
   * @return true if removeBook produces the expected result; false otherwise
   */
  public static boolean testRemoveBook() {
    // TODO
    // 12. Create a Book[] array containing at least 3 Book objects with different titles (see
    // testMinSort() below for examples)
    Book[] testShelf = new Book[] {new Book("Mockingjay", "Collins"),
            new Book("The Sparrow", "Mary Doria Russell"),
            new Book("2001", "Arthur C Clarke"),
            new Book("Noor", "Nnedi Okorafor")};
    // 13. Create a NEW Book object that is identical to one of the Book objects from your array
    Book toRemove = new Book("The Sparrow", "Mary Doria Russell");
    // 14. Call removeBook() on your array and Book object and save the result
    Book[] result = MinSort.removeBook(testShelf, toRemove);
    // 15. Verify that the length of the result is 1 less than your input array, and that the Book
    // you passed in the second argument is NOT present, and return false if either test does
    // not pass.
    // OPTIONAL: implement additional tests to verify the method works!
    if (result.length != testShelf.length - 1) {
      return false;
    }
    Book[] expected = new Book[] {new Book("Mockingjay", "Collins"),
            new Book("2001", "Arthur C Clarke"),
            new Book("Noor", "Nnedi Okorafor")};
    for (int i = 0; i < 3; ++i) {
      if (expected[i].compareTo(result[i]) != 0) {
        return false;
      }
    }
    // 16. Return true if all tests in this method are passed.
    return true; // default return statement added to avoid compiler errors. Feel free to change it.
  }
  
  /////////////////////////////////////////////////////////////////////////////////////////////////
  // NOTE: THERE IS NO MORE CODE REQUIRED FROM YOU AFTER THIS POINT!
  //
  // What follows is another test for you to run locally to help assure you that your program
  // works as expected, and a main method. The Book class is included at the bottom of the file.
  //
  // SAVE YOUR CODE (Ctrl/Cmd + S) and RUN ALL TESTS, and SUBMIT YOUR FILE TO GRADESCOPE!!
  /////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * A recursive method to sort an array of Books in-place.
   * 
   * @param bookshelf a full, perfect-size array of Books with length >= 1
   */
  public static void minSort(Book[] bookshelf) {
    /////////// BASE CASE ///////////
    // an array of length 1 is sorted
    if (bookshelf.length == 1) return;
    
    ///////// RECURSIVE CASE ////////
    
    // use the helper methods to pre-process the data
    Book minBook = getMinValue(bookshelf);
    Book[] newShelf = removeBook(bookshelf, minBook);
    minSort(newShelf);
    
    // copy the processed data back into the original shelf
    bookshelf[0] = minBook;
    for (int i=0; i<newShelf.length; i++) {
      bookshelf[i+1] = newShelf[i];
    }
  }
  
  /**
   * A tester method for minSort, provided for you in its entirety. You may add code if you wish,
   * but you are not required to. This method will not be tested.
   * 
   * @return true if minSort produces the expected result; false otherwise
   */
  public static boolean testMinSort() {
    // try sorting a one-book shelf:
    Book[] simpleShelf = new Book[] {new Book("The Last Girl Scout", "Natalie Ironside")};
    Book contents = new Book("The Last Girl Scout", "Natalie Ironside");
    try {
      minSort(simpleShelf);
    } catch (NullPointerException npe) {
      System.err.println("minSort() NullPointerException!");
      return false;
    }

    if (simpleShelf.length != 1) return false;
    if (simpleShelf[0] == null || simpleShelf[0].compareTo(contents) != 0) return false;
    
    // try sorting a shelf with multiple books:
    Book[] testShelf = new Book[] {new Book("Mockingjay", "Collins"), 
        new Book("The Sparrow", "Mary Doria Russell"), 
        new Book("2001", "Arthur C Clarke"), 
        new Book("Noor", "Nnedi Okorafor")};
    Book[] expectedShelf = new Book[] {new Book("2001", "Arthur C Clarke"),
        new Book("Mockingjay", "Collins"), 
        new Book("Noor", "Nnedi Okorafor"), 
        new Book("The Sparrow", "Mary Doria Russell")};
    try {
      minSort(testShelf);
    } catch (NullPointerException npe) {
      System.err.println("minSort() NullPointerException!");
      return false;
    }
    
    if (testShelf.length != expectedShelf.length) return false;
    for (int i=0; i<expectedShelf.length; i++) {
      if (testShelf[i] == null || testShelf[i].compareTo(expectedShelf[i]) != 0) return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    System.out.println("getMinValue test result: "+testGetMinValue());
    System.out.println("removeBook test result: "+testRemoveBook());
    System.out.println("minSort test result: "+testMinSort());
  }

}

/**
 * The objects to be sorted by the MinSort class. DO NOT MODIFY THIS CLASS IN ANY WAY.
 */
class Book {
  private String title;
  private String authorLastName;
  
  /**
   * Create a new Book object
   * @param title the title of the book
   * @param name the author's name, either just last name or full name. Author's last name
   *     is considered to be the last element of this String
   */
  public Book(String title, String name) {
    this.title = title;
    this.authorLastName = name.trim().split(" ")[name.trim().split(" ").length-1];
  }
  
  /**
   * Compare first on the basis of title, and if the titles are the same, compare on
   * basis of author last name.
   * 
   * @param b the Book to compare this to
   * @return a value less than 0 if this book is alphabetically "before" b, greater than
   *    0 if this book is alphabetically "after" b, and 0 if they have the same title and
   *    author last name.
   */
  public int compareTo(Book b) {
    if (this.title.compareTo(b.title) != 0) return this.title.compareTo(b.title);
    return this.authorLastName.compareTo(b.authorLastName);
  }
  
  /**
   * For debugging purposes, a way to System.out.println(Book)
   * 
   * Results are formatted as: "Title", AuthorLastName
   */
  @Override
  public String toString() {
    return "\""+this.title+"\", "+this.authorLastName;
  }
}
