//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   HuaiYuan Jing
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

import javax.swing.text.AsyncBoxView;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 *
 * @author HuaiYuan Jing
 *
 */

public class ChugidexTester {


    /**
     * Checks the correctness of the implementation of both compareTo() and equals() methods defined
     * in the Chugimon class.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testChugimonCompareToEquals() {
        // TODO complete the implementation of this method
        try
        {
            Chugimon test1 = new Chugimon(50, 3);
            Chugimon test2 = new Chugimon(50, 3);
            if (test1.compareTo(test2) != 0 || test2.compareTo(test1) != 0)
                return false;
            return test1.equals(test2) && test2.equals(test1);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Checks the correctness of the implementation of Chugimon.toString() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testChugimonToString() {
        // TODO complete the implementation of this method
        try
        {
            Chugimon test = new Chugimon(100, 10);
            return test.toString().equals(test.getName() + '#' + test.getFirstID() + "." + test.getSecondID());
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
     * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
     * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
     * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
     * search order property is violated at at least one internal node.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testIsValidBSTHelper() {
        // TODO complete the implementation of this method
        if (!ChugiTree.isValidBSTHelper(null))
            return false;
        BSTNode<Chugimon> node1 = new BSTNode<>(new Chugimon(1, 2));
        node1.setLeft(new BSTNode<>(new Chugimon(2, 1)));
        node1.getLeft().setLeft(new BSTNode<>(new Chugimon(3, 1)));
        if (ChugiTree.isValidBSTHelper(node1))
            return false;
        BSTNode<Chugimon> node2 = new BSTNode<>(new Chugimon(1, 2));
        node2.setRight(new BSTNode<>(new Chugimon(2, 1)));
        node2.getRight().setRight(new BSTNode<>(new Chugimon(3, 1)));
        if (!ChugiTree.isValidBSTHelper(node2))
            return false;
        return true; // Default return statement added to resolve compiler errors
    }

    /**
     * Checks the correctness of the implementation of both add() and toString() methods implemented
     * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
     * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
     * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
     * method call returns true, the tree is not empty, its size is 1, and the toString() called on
     * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
     * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
     * root, (5) Try adding at least two further Chugimons such that one must be added at the left
     * subtree, and the other at the right subtree. For all the above scenarios, and more, double
     * check each time that size() method returns the expected value, the add method call returns
     * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
     * string representation of the contents of the binary search tree in an increasing order from the
     * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
     * sure that the add() method call returned false, and that the size of the tree did not change.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testAddToStringSize() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        if (test1.size() != 0 || !test1.toString().equals(""))
            return false;
        Chugimon node1 = new Chugimon(100, 101);
        if (!test1.add(node1))
            return false;
        if (test1.size() != 1 || !test1.toString().equals(node1.toString()))
            return false;
        Chugimon node2 = new Chugimon(99, 98);
        Chugimon node3 = new Chugimon(50, 40);
        Chugimon node4 = new Chugimon(120, 123);
        Chugimon node5 = new Chugimon(140, 123);
        test1.add(node2);
        test1.add(node3);
        test1.add(node4);
        test1.add(node5);
        if (test1.size() != 5)
            return false;
        if (test1.add(node3))
            return false;
        return true; // Default return statement added to resolve compiler errors
    }

    /**
     * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
     * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
     * calling the lookup() method on an empty ChugiTree returns false. (2) Consider a ChugiTree of
     * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
     * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
     * and left subtrees at different levels considering successful and unsuccessful search
     * operations. Make sure that the lookup() method returns the expected output for every method
     * call.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testLookup() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        if (test1.lookup(30, 23) != null)
            return false;
        Chugimon node1 = new Chugimon(100, 101);
        Chugimon node2 = new Chugimon(99, 98);
        Chugimon node3 = new Chugimon(50, 40);
        Chugimon node4 = new Chugimon(120, 123);
        Chugimon node5 = new Chugimon(140, 123);
        test1.add(node1);
        test1.add(node2);
        test1.add(node3);
        test1.add(node4);
        test1.add(node5);
        if (test1.lookup(100, 101) == null || !test1.lookup(100, 101).equals(node1))
            return false;
        if (test1.lookup(140, 123) == null || !test1.lookup(140, 123).equals(node5))
            return false;
        if (test1.lookup(131, 122) != null)
            return false;
        return true; // Default return statement added to resolve compiler errors
    }

    /**
     * Checks for the correctness of ChugiTree.countType() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testCountType() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        Chugimon node1 = new Chugimon(100, 101);
        Chugimon node2 = new Chugimon(99, 98);
        Chugimon node3 = new Chugimon(50, 40);
        Chugimon node4 = new Chugimon(120, 123);
        Chugimon node5 = new Chugimon(140, 123);
        test1.add(node1);
        test1.add(node2);
        test1.add(node3);
        test1.add(node4);
        test1.add(node5);
        return test1.countType(ChugiType.WATER) == 2; // Default return statement added to resolve compiler errors
    }

    /**
     * Checks for the correctness of ChugiTree.height() method. This test must consider several
     * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
     * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
     * a ChugiTree with four levels for instance, is 4.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testHeight() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        if (test1.height() != 0)
            return false;
        Chugimon node1 = new Chugimon(100, 101);
        Chugimon node2 = new Chugimon(99, 98);
        Chugimon node3 = new Chugimon(50, 40);
        Chugimon node4 = new Chugimon(120, 123);
        Chugimon node5 = new Chugimon(140, 123);
        test1.add(node3);
        if (test1.height() != 1)
            return false;
        test1.add(node1);
        test1.add(node2);
        test1.add(node4);
        test1.add(node5);
        if (test1.height() != 4)
            return false;
        return true; // Default return statement added to resolve compiler errors
    }

    /**
     * Checks for the correctness of ChugiTree.getFirst() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testGetFirst() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        test1.add(new Chugimon(2, 1));
        test1.add(new Chugimon(1, 2));
        return test1.getFirst().equals(new Chugimon(1, 2)); // Default return statement added to resolve compiler errors
    }

    /**
     * Checks for the correctness of ChugiTree.getLast() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testGetLast() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        test1.add(new Chugimon(1, 2));
        test1.add(new Chugimon(2, 1));
        return test1.getLast().equals(new Chugimon(2, 1));
    }

    /**
     * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
     * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
     * node. For each of these scenarios, check that the size of the tree was decremented by one and
     * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
     * returns false when called on an Chugimon that is not present in the BST.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testDelete() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        Chugimon node1 = new Chugimon(100, 101);
        Chugimon node2 = new Chugimon(99, 98);
        Chugimon node3 = new Chugimon(50, 40);
        Chugimon node4 = new Chugimon(120, 123);
        Chugimon node5 = new Chugimon(140, 123);
        test1.add(node1);
        test1.add(node2);
        test1.add(node3);
        test1.add(node4);
        test1.add(node5);
        if (!test1.delete(node3))
            return false;
        if (!test1.delete(node1))
            return false;
        if (test1.delete(node3))
            return false;
        return true; // Default return statement added to resolve compiler errors
    }

    /**
     * Checks for the correctness of ChugiTree.next() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testNext() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        test1.add(new Chugimon(1, 2));
        test1.add(new Chugimon(2, 1));
        return test1.next(new Chugimon(1, 2)).equals(new Chugimon(2, 1));
    }

    /**
     * Checks for the correctness of ChugiTree.previous() method.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testPrevious() {
        // TODO complete the implementation of this method
        ChugiTree test1 = new ChugiTree();
        test1.add(new Chugimon(2, 1));
        test1.add(new Chugimon(1, 2));
        return test1.previous(new Chugimon(2, 1)).equals(new Chugimon(1, 2));
    }

    /**
     * Calls the test methods
     *
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
        System.out.println("testChugimonToString(): " + testChugimonToString());
        System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
        System.out.println("testAddToStringSize(): " + testAddToStringSize());
        System.out.println("testLookup(): " + testLookup());
        System.out.println("testHeight(): " + testHeight());
        System.out.println("testCountType(): " + testCountType());
        System.out.println("testGetFirst(): " + testGetFirst());
        System.out.println("testGetLast(): " + testGetLast());
        System.out.println("testDelete(): " + testDelete());
        System.out.println("testNext(): " + testNext());
        System.out.println("testPrevious(): " + testPrevious());
    }

}
