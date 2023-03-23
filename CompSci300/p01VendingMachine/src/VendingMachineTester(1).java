// A tool used to test VendingMachine.java works properly or not

/**
 * The class is used to test each method in VendingMachine.java. Include:
 * GetIndexNextItem
 * ContainsItem
 * GetItemAtIndex
 * GetItemsOccurrences
 * GetItem
 * RemoveNextItem
 * GetItemSummary
 *
 * @auther HuaiYuan Jing
* */

import java.util.Arrays;

public class VendingMachineTester {

    // TODO complete the implementation of the following tester methods and add their javadoc style
    // method headers

    // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
    // returns true if the test verifies a correct functionality and false if any bug is detected
    public static boolean testGetIndexNextItem() {
        // Test scenarios normal and edge cases
        // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
        // its description without removing it.

        // 1. Next item to be dispensed is NOT found: the expected output is -1
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
                System.out.println(
                        "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                                + "-1 when no match found.");
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                System.out.println(
                        "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                                + "changes to the content of the array passed as input.");
                return false;
            }
        }

        // 2. Next item to be dispensed is at index 0
        {
            String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
                    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            int itemsCount = 7;

            // check the correctness of the output
            if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
                System.out.println(
                        "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                                + "the expected output when the vending machines contains multiple matches with the "
                                + "provided item description and the matching item with the soonest expiration date "
                                + "is at index 0.");
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
                            {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                System.out.println(
                        "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                                + "changes to the content of the array passed as input.");
                return false;
            }
        }

        // 3. Next item to be dispensed is at the end of the array
        {
            String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
                    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            int itemsCount = 7;

            // check the correctness of the output
            if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
                System.out.println(
                        "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                                + "the expected output when the vending machines contains multiple matches with the "
                                + "provided item description and the matching item with the soonest expiration date "
                                + "is at the end of the array");
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
                            {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                System.out.println(
                        "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                                + "changes to the content of the array passed as input.");
                return false;
            }
        }

        // 4. Next item to be dispensed is at the middle of the array
        {
            String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
                    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            int itemsCount = 7;

            // check the correctness of the output
            if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
                System.out.println(
                        "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                                + "the expected output when the vending machines contains matches with the provided "
                                + "item description with different expiration dates.");
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
                            {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                System.out.println(
                        "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                                + "changes to the content of the array passed as input.");
                return false;
            }
        }

        return true; // No bug detected
    }

    // Checks the correctness of containsItem defined in the VendingMachine class. This method
    // returns true if the test verifies a correct functionality and false if any bug is detected
    public static boolean testContainsItem() {
        // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
        // search returning false.
        // 1
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.containsItem("candy", items, itemsCount) != false) {
                System.out.println("containsItem() find things does not exist");
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                System.out.println("containsItem() changed the original array");
                return false;
            }
        }
        // 2
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.containsItem("Water", items, itemsCount) != true) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        return true; // default return statement to let this incomplete code compiles with no errors.
        // Feel free to change it.
    }

    // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
    // returns true if the test verifies a correct functionality and false if any bug is detected
    public static boolean testGetItemAtIndex() {
        // Define at least two test scenarios: (1) the provided index is out of the range
        // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
        // For each test scenario, ensure that the method returned the exact expected string output
        // without making any changes to the contents of the array.
        // 1
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (!VendingMachine.getItemAtIndex(-1, items, itemsCount).equals("ERROR INVALID INDEX")) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 2
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.getItemAtIndex(0, items, itemsCount).equals("Water")) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }
        return true; // default return statement to let this incomplete code compiles with no errors.
    }

    // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
    public static boolean testGetItemsOccurrences() {
        // Define at least two test scenarios: (1) no match found so that the method returns zero,
        // (2) the items array contains multiple occurrences of the provided item description.

        // For each test scenario, ensure that the method returned the expected output without making
        // any changes to the contents of the array.
        // 1
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.getItemOccurrences("???", items, itemsCount) != 0) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 2
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.getItemOccurrences("Water", items, itemsCount) != 1) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }
        return true; // default return statement to let this incomplete code compiles with no errors.
    }

    // Checks the correctness of addItem defined in the VendingMachine class.
    public static boolean testAddItem() {
        // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
        // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
        // vending machine, and (3) adding a new item to a full vending machine where the provided
        // itemsCount equals the length of the provided items array.

        // For each tester scenario, check for the expected returned size of the vending machine and
        // the expected content of the items array after the method call returns.

        {
            // define the vending machine
            String[][] items =
                    new String[4][2];
            int itemsCount = 0;

            // check the correctness of the output
            if (VendingMachine.addItem("Cake", "50", items, itemsCount) != 1) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Cake", "50"}, {null, null}, {null, null}, {null, null}};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
//            System.out.println("Null Array Passed");
        }

        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Cake", "50"}, null, null, null};
            int itemsCount = 1;

            // check the correctness of the output
            if (VendingMachine.addItem("Cake", "60", items, itemsCount) != 2) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Cake", "50"}, {"Cake", "60"}, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Cake", "50"}};
            int itemsCount = 1;

            // check the correctness of the output
            if (VendingMachine.addItem("Cake", "60", items, itemsCount) != 1) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Cake", "50"}};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }
        return true; // default return statement to let this incomplete code compiles with no errors.
    }

    // Checks the correctness of removeNextItem defined in the VendingMachine class.
    public static boolean testRemoveNextItem() {
        // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
        // machine (the vending machine can be empty or not), (2) the next item to be removed matching
        // the provided description is at index 0 of the array, (3) the next item to be removed is at
        // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
        // is at a middle index of the provided items array.

        // For each tester scenario, check for the expected returned size of the vending machine and
        // the expected content of the items array after the method call returns.

        // 1
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.removeNextItem("Water", items, itemsCount) != 2) {
                return false;
            }
//            System.out.println("passed 1");
//            for (int i = 0; i < items.length; ++i) {
//                if (items[i] != null) {
//                    System.out.println(items[i][0] + " " + items[i][1]);
//                }
//                else {
//                    System.out.println("null");
//                }
//            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Chocolate", "10"}, {"Juice", "20"}, null, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
//            System.out.println("passed 1");
        }

        // 2
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.removeNextItem("Juice", items, itemsCount) != 2) {
                return false;
            }
            itemsCount = 2;
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, null, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 3
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.removeNextItem("Chocolate", items, itemsCount) != 2) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Juice", "20"}, null, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 4
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            int itemsCount = 3;

            // check the correctness of the output
            if (VendingMachine.removeNextItem("?????", items, itemsCount) != 3) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        return true; // default return statement to let this incomplete code compiles with no errors.

    }

    // Checks the correctness of getItemsSummary defined in the VendingMachine class.
    public static boolean testGetItemsSummary() {
        // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
        // contains non duplicate items (no multiple items with the same description), (3) the vending
        // machine contains multiple items with the same description at various index locations.
        // 1

        {
            // define the vending machine
            String[][] items =
                    new String[3][];
            int itemsCount = 0;

            // check the correctness of the output
            if (!VendingMachine.getItemsSummary(items, itemsCount).equals("")) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[3][];
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 2

        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "10"}};
            int itemsCount = 1;

            // check the correctness of the output
            if (!VendingMachine.getItemsSummary(items, itemsCount).equals("Water (1)\n")) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "10"}};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        // 3
        {
            // define the vending machine
            String[][] items =
                    new String[][] {{"Water", "10"}, {"Water", "20"}};
            int itemsCount = 2;

            // check the correctness of the output
            if (!VendingMachine.getItemsSummary(items, itemsCount).equals("Water (2)\n")) {
                return false;
            }
            // Check that the method did not make change to the contents of the array items passed as
            // input
            String[][] originalItems =
                    new String[][] {{"Water", "10"}, {"Water", "20"}};
            if (!Arrays.deepEquals(items, originalItems)) {
                return false;
            }
        }

        return true; // default return statement to let this incomplete code compiles with no errors.
    }

    // This method returns false if any of the tester methods defined in this class fails, and true
    // if no bug detected.
    public static boolean runAllTests() {
        return testGetIndexNextItem() &&
                testContainsItem() &&
                testGetItemAtIndex() &&
                testGetItemsOccurrences() &&
                testAddItem() &&
                testRemoveNextItem() &&
                testGetItemsSummary(); // default return statement to let this incomplete code compiles with no errors.
    }

    // main method to call the tester methods defined in this class
    public static void main(String[] args) {
        System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
        System.out.println("runAllTests(): " + runAllTests());
    }

}
