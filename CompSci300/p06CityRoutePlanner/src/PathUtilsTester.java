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
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Tester class for PathUtils
 */
public class PathUtilsTester {
    /**
     * Tests the case of countPaths() when there are no valid Paths.
     * For example, when the start position is Intersection(1, 1)
     * and the ending position is Intersection(0, 1),
     * there should be no valid Paths, so countPaths() should return 0.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsNoPath() {
        Intersection a = new Intersection(10,10);
        Intersection b = new Intersection(0, 0);
        if (PathUtils.countPaths(a, b) != 0) {
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there is a single valid Path.
     * For example, when the start position is Intersection(1, 1)
     * and the ending position is Intersection(1, 2),
     * there should be a single Path, so countPaths() should return 1.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsOnePath() {
        Intersection a = new Intersection(1, 1);
        Intersection b = new Intersection(1, 2);
        if (PathUtils.countPaths(a, b) != 1) {
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there are multiple possible paths.
     * For example, when the start position is Intersection(0, 0)
     * and the ending position is Intersection(1, 2),
     * there should be three possible Paths, so countPaths() should return 3.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsRecursive() {
        Intersection a = new Intersection(0, 0);
        Intersection b = new Intersection(1, 2);
        if (PathUtils.countPaths(a, b) != 3) {
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are no valid Paths.
     * For example, when the start position is Intersection(1, 1)
     * and the ending position is Intersection(0, 1),
     * there should be no valid Paths, so findAllPaths() should return an empty ArrayList.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath() {
        Intersection a = new Intersection(1, 1);
        Intersection b = new Intersection(0, 1);
        if (!PathUtils.findAllPaths(a, b).isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there is a single valid Path.
     * For example, when the start position is Intersection(1, 1)
     * and the ending position is Intersection(1, 2),
     * there should be a single Path.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath() {
        Intersection a = new Intersection(1, 1);
        Intersection b = new Intersection(1, 2);
        ArrayList<Path> ans = PathUtils.findAllPaths(a, b);
        if (ans.size() == 1 && ans.get(0).getHead() == a && ans.get(0).getTail() == b) {
            return true;
        }
        return false;
    }

    /**
     * Tests the case of findAllPaths() when there are multiple possible paths.
     * For example, when the start position is Intersection(0, 0)
     * and the ending position is Intersection(1, 2),
     * there should be three possible Paths.
     * For each of your cases, ensure that there is both the correct number of Paths,
     * and that the returned Paths exactly match what you expect to see.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsRecursive() {
        Intersection a = new Intersection(1, 1);
        Intersection b = new Intersection(2, 2);
        ArrayList<Path> ans = PathUtils.findAllPaths(a, b);
        if (ans.size() != 2) {
            return false;
        }
        ArrayList<String> temp1 = new ArrayList<>();
        for (Path p: ans) {
            temp1.add(p.toString());
        }
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("(1,1)->(1,2)->(2,2)");
        temp2.add("(1,1)->(2,1)->(2,2)");
        return temp2.containsAll(temp1) && temp1.containsAll(temp2);
    }

    public static void main(String[] args) {
        System.out.println("testCountPathsNoPath: " + PathUtilsTester.testCountPathsNoPath());
        System.out.println("testCountPathsOnePath: " + PathUtilsTester.testCountPathsOnePath());
        System.out.println("testCountPathsRecursive: " + PathUtilsTester.testCountPathsRecursive());
        System.out.println("testFindAllPathsNoPath: " + PathUtilsTester.testFindAllPathsNoPath());
        System.out.println("testFindAllPathsOnePath: " + PathUtilsTester.testFindAllPathsOnePath());
        System.out.println("testFindAllPathsRecursive: " + PathUtilsTester.testFindAllPathsRecursive());
    }
}
