// A class to imitate a Vending Machine

// Add import statement to relevant exceptions and FilePrinter or FileWriter
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * This class models a vending machine. When requested, the item with the soonest expiration date
 * will be dispensed first.
 *
 */
public class ExceptionalVendingMachine {
    private Item[] items; // array storing the items available within this vending machine
    private int size; // number of items available in this vending machine

    /**
     * Creates a new vending machine with a given capacity
     *
     * @param capacity maximum number of items that can be held by this vending machine
     * @throws IllegalArgumentException with a descriptive error message if capacity is zero or
     *                                  negative
     */
    public ExceptionalVendingMachine(int capacity) {
        // TODO complete the implementation of this method with respect to the details of its javadoc
        // comments
        if (capacity <= 0) {throw new IllegalArgumentException("capacity is equal or smaller than 0");}
        items = new Item[capacity];
        size = 0; // optional since 0 is the default value for primitive type int
    }

    /**
     * Checks whether this vending machine is empty
     *
     * @return true if this vending machine is empty, false otherwise
     */
    public boolean isEmpty() {
        // TODO implement this method
        return size == 0; // default return statement. Feel free to change it
    }

    /**
     * Checks whether this vending machine is full
     *
     * @return true if this vending machine is full, false otherwise
     */
    public boolean isFull() {
        // TODO implement this method
        return size == items.length; // default return statement. Feel free to change it
    }

    /**
     * Returns the total number of items available in this vending machine
     *
     * @return the size of this vending machine
     */
    public int size() {
        // TODO implement this method
        return this.size; // default return statement. Feel free to change it
    }

    /**
     * Appends an item defined by its description and expirationDate to this vending machine. The item
     * will be added to the end of the vending machine.
     *
     * @param description    description of the item to be added to the vending machine
     * @param expirationDate a positive integer which represents the expiration date of the item.
     * @throws IllegalStateException    with a descriptive error message if the vending machine is
     *                                  full
     * @throws IllegalArgumentException with a descriptive error message if description is null or
     *                                  blank or if expirationDate is negative ( &lt; 0)
     */
    public void addItem(String description, int expirationDate) {
        // TODO complete the implementation of this method with respect to its above specification
        if (this.isFull()) {throw new IllegalStateException("Vending machine is full");}
        if (description == null || description.equals("") || expirationDate < 0) {
            throw new IllegalArgumentException("Incorrect Argument");
        }

        // create a new item and add it to the end of this vending machine
        items[size] = new Item(description, expirationDate);
        size++;
    }


    /**
     * Returns without removing the string representation of the item at the given index within the
     * vending machine
     *
     * @param index index of an item within the vending machine
     * @return the string representation of the item stored at the given index within the vending
     *         machine defined by items and itemsCount. The returned string must have the following
     *         format: "description: expirationDate".
     * @throws IndexOutOfBoundsException with a descriptive error message if index &lt; 0 or index
     *                                   &gt;= size of the vending machine
     */
    public String getItemAtIndex(int index) {
        // TODO complete the implementation of this method with respect to its above specification
        if (index >= this.size || index < 0) {throw new IndexOutOfBoundsException("Invalid index");}
        return items[index].toString();
    }

    /**
     * Returns the number of occurrences of items with a given description within this vending machine
     *
     * @param description description (name) of an item
     * @return the number of occurrences of items with a given description within the vending machine
     * @throws IllegalArgumentException with a descriptive error message if description is null or
     *                                  blank
     */
    public int getItemOccurrences(String description) {
        // TODO: Complete the implementation of this method with respect to the above details
        if (description == null || description.equals("")) {throw new IllegalArgumentException("Illegal Argument");}
        int nbOccurrences = 0;
        for (int i = 0; i < size; i++) {
            if (description.equals(items[i].getDescription())) {
                nbOccurrences++;
            }
        }
        return nbOccurrences;
    }

    /**
     * Checks whether the vending machine contains at least one item with the provided description
     *
     * @param description description (name) of an item to search
     * @return true if there is a match with description in the vending machine, false otherwise
     * @throws IllegalArgumentException with a descriptive error message if description is null or
     *                                  blank
     */
    public boolean containsItem(String description) {
        // TODO: Complete the implementation of this method with respect to the above details
        if (description == null || description.equals("")) {throw new IllegalArgumentException("Illegal Argument");}
        return getItemOccurrences(description) != 0;
    }

    /**
     * Returns the number of items in the vending machine with a specific description and whose
     * expiration dates are greater or equal to a specific expiration date
     *
     * @param description    description of the item to find its number of occurrences
     * @param expirationDate specific (earliest) expiration date
     * @return the number of items with a specific description and whose expiration date is greater or
     *         equal to the given one
     * @throws IllegalArgumentException with a descriptive error message if expirationDate is negative
     *                                  (less than zero) or description is null or blank
     */
    public int getItemOccurrencesByExpirationDate(String description, int expirationDate) {
        // TODO: Complete the implementation of this method with respect to the above details
        if (description == null || description.equals("") || expirationDate < 0) {
            throw new IllegalArgumentException("Illegal Argument");
        }
        int nbOccurrences = 0; // number of occurrences of the matching items
        // traverse the vending machine looking for matching items
        for (int i = 0; i < size; i++) {
            if (description.equals(items[i].getDescription())
                    && items[i].getExpirationDate() >= expirationDate) {// match found
                nbOccurrences++;
            }
        }
        // return the number of occurrences of the matching items
        return nbOccurrences;
    }

    /**
     * Returns without removing the index of the item having the provided description and the smallest
     * expiration date within the vending machine.
     *
     * @param description description of an item
     * @return the index of the next item, meaning the item with the given description and the
     *         smallest expiration date.
     * @throws IllegalArgumentException with a descriptive error message if description is null or
     *                                  blank
     * @throws NoSuchElementException   with a descriptive error message if no match found
     */
    public int getIndexNextItem(String description) {
        // TODO complete the implementation of this method with respect to the details provided above
        if (description == null || description.equals("")) {throw new IllegalArgumentException("Illegal Argument");}
        int index = -1; // index of the search item
        int minExpirationDate = -1; // smallest expiration date of matching items

        // traverse the vending machine looking for the matching item with the smallest expiration date
        for (int i = 0; i < size; i++) {
            if (description.equals(items[i].getDescription())) {
                int itemExpirationDate = items[i].getExpirationDate();
                if (index == -1) { // first match found
                    minExpirationDate = items[i].getExpirationDate();
                    index = i;
                } else { // another match found
                    if (itemExpirationDate < minExpirationDate) {
                        // match with smaller (sooner) expiration date found
                        minExpirationDate = itemExpirationDate; // update minimum expiration date
                        index = i; // update the index of the next item
                    }
                }
            }
        }

        if (index == -1) {throw new NoSuchElementException("No such element");}

        return index; // return the index of the item with the given description and the smallest
        // expiration date if found
    }


    /**
     * Removes and returns the item having the provided description with the smallest expiration date
     * within the vending machine. This method should maintain the order of precedence of items in the
     * vending machine. This means that the remove operation involves a shift operation.
     *
     * @param description description of the item to remove or dispense
     * @return The removed or dispensed item if it is available
     * @throws IllegalArgumentException with a descriptive error message if description is null or
     *                                  blank
     * @throws NoSuchElementException   with a descriptive error message if no match found
     *
     */
    public Item removeNextItem(String description) {
        if (description == null || description.equals("")) {throw new IllegalArgumentException("Illegal Argument");}
        // get the index of the next item to dispense by this vending machine
        int index = getIndexNextItem(description); // exceptions throws by this method call should
        // propagate

        // save a copy of the item to dispense
        Item itemToDispense = items[index];

        // remove the item at index using a shift operation
        for (int i = index + 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        items[size - 1] = null;
        size--;

        return itemToDispense; // return the removed item
    }

    /**
     * Returns a summary of the contents of this vending machine in the following format: Each line
     * contains the description or item name followed by one the number of occurrences of the item
     * name in the vending machine between parentheses. For instance, if the vending machine contains
     * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
     * follows. water (5)\n chocolate (10)\n snack (7) If the vending machine is empty, this method
     * returns an empty string ""
     *
     * @return a descriptive summary of the contents of the vending machine
     */
    public String getItemsSummary() {
        String summary = ""; // empty string

        // traverse the vending machine and build its items summary description
        for (int i = 0; i < size; i++) {
            // add the item's description and count if not yet processed
            if (!summary.contains(items[i].getDescription())) {
                summary = summary + items[i].getDescription() + " ("
                        + getItemOccurrences(items[i].getDescription()) + ")\n";
            }
        }
        return summary.trim(); // return the items' summary
    }

    // TODO Implement the methods loadOneItem, loadItems, and saveItems



    /**
     * Parse an item's string representation and add the corresponding item to this vending machine
     *
     * @param itemRepresentation a String representation of an item formatted as "description:
     *                           expirationDate". Extra spaces at the beginning and end of the item
     *                           description and expirationDate can be disregarded.
     * @throws IllegalArgumentException with a descriptive error message if itemRepresentation is null
     *                                  or blank
     * @throws DataFormatException      with a descriptive error message if the provided string is not
     *                                  correctly formatted. A correct format of the
     *                                  itemRepresentation is "description: expirationDate". The
     *                                  description must be a NOT blank string. The expirationDate
     *                                  must be a non-empty string parsable to a positive integer. The
     *                                  item's description and its expiration date must be separated
     *                                  by one colon ":". Extra whitespace at the beginning and end of
     *                                  description or expirationDate should be disregarded.
     * @throws IllegalStateException    with a descriptive error message if the vending machine is
     *                                  full
     */
    public void loadOneItem(String itemRepresentation) throws DataFormatException, IllegalStateException {
        // TODO Complete the implementation of this method with respect to the details provided above
        // TODO Add throws declarations to the method signature as required

        // [HINT] Use String.split() and String.trim() methods to help parsing the itemRepresentation
        // This method MUST call addItem(String, int) to try adding the parsed item to the vending
        // machine

        // This is a complex method. Try to decompose it into steps. We highly recommend breaking its
        // functionality down the way that you see fits using private helper methods.
        if (this.isFull()) {throw new IllegalStateException("machine is full");}
        if (itemRepresentation == null || itemRepresentation.trim().equals("")) {
            throw new IllegalArgumentException("description is null or blank");
        }
        itemRepresentation = itemRepresentation.trim();

        int cnt = 0;
        int index = 0;
        while ((index = itemRepresentation.indexOf(":", index)) != -1) {
            index += 1;
            cnt += 1;
        }
        if (cnt != 1) {
            throw new DataFormatException("Incorrect Format");
        }

        String[] buff = itemRepresentation.split(":");
        if (buff.length != 2) {throw new DataFormatException("Incorrect Format");}
        buff[0] = buff[0].trim();
        buff[1] = buff[1].trim();
        if (buff[0].trim().equals("") || buff[1].trim().equals("")) {
            throw new DataFormatException("Incorrect Format");
        }
        int expirationDate;
        try {
            expirationDate = Integer.parseInt(buff[1]);
        }
        catch (Exception e) {
            throw new DataFormatException("Incorrect Format");
        }
        if (expirationDate < 0) {throw new DataFormatException("Incorrect Format");}

        this.addItem(buff[0], expirationDate);
    }


    /**
     * Reads and parses the file passed as input line by line and loads the corresponding items to the
     * vending machine. Each line in the file represents an item description formatted as
     * "description: expirationDate". Blank and badly formatted lines must be skipped.
     *
     * Displays "Vending machine FULL. No more items can be loaded." when trying to load a new item to
     * the vending machine if it is or becomes full.
     *
     * @param file file to load items from
     * @return the total number of new items loaded to this vending machine
     * @throws FileNotFoundException if the file object does not correspond to an actual file within
     *                               the file system.
     */
    public int loadItems(File file) throws FileNotFoundException {
        // TODO Complete the implementation of this method with respect to the details provided above
        // TODO Add throws declarations to the method signature as required

        // Create and use a java.util.Scanner object to open and read the file
        // This method MUST call the loadOneItem(String) method to operate while parsing each line

        // Notice carefully that this method does not throw any exception if the vending machine is full
        // or becomes full while trying to lead an item.
        Scanner scnr = new Scanner(file);
        int raw = this.size();
        while (scnr.hasNextLine()) {
            try {
                this.loadOneItem(scnr.nextLine());
            }
            catch (Exception e) {
            }
        }

        return this.size() - raw; // default return statement. Feel free to change it.
    }

    /**
     * Saves the summary of this vending machine to the file object passed as input
     *
     * @param file file object where the vending machine summary will be saved
     */
    public void saveVendingMachineSummary(File file) {
        // TODO Complete the implementation of this method with respect to the details provided above

        // You can use either a java.io.PrintWriter or a java.io.FileWriter to write into the file

        // This method MUST call the getItemsSummary() to get the summary of this vending machine to be
        // saved to the file

        // This method MUST NOT throw any exception
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(this.getItemsSummary());
            writer.flush();
            writer.close();
        }
        catch (Exception e) {
        }
    }

}
