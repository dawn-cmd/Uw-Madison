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
 * Utility methods for planning a trip through a grid of city intersections
 */
public class PathUtils {
    /**
     * Finds the number of valid Paths between the given start and end Intersections.
     * If it is not possible to get from the start to the end intersection by moving up or right,
     * then 0 should be returned.
     * @param start Intersection to start at
     * @param end Intersection to end at
     * @return the number of valid Paths which start and end at the given Intersections
     */
    public static int countPaths(Intersection start, Intersection end) {
        if (start.equals(end)) {
            return 1;
        }
        if (start.getX() > end.getX() || start.getY() > end.getY()) {
            return 0;
        }
        return PathUtils.countPaths(start.goNorth(), end) + PathUtils.countPaths(start.goEast(), end);
    }

    /**
     * Finds all valid Paths between the given start and end Intersections.
     * If it is not possible to get from the start to the end intersection by moving up or right,
     * then an empty ArrayList should be returned.
     * @param start
     * @param end
     * @return
     */
    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
        if (start.equals(end)) {
            Path path = new Path();
            path.addHead(end);
            ArrayList<Path> ans = new ArrayList<Path>();
            ans.add(path);
            return ans;
        }
        if (start.getX() > end.getX() || start.getY() > end.getY()) {
            return new ArrayList<>();
        }
        ArrayList<Path> ans = new ArrayList<Path>();
        Intersection[] direction = new Intersection[2];
        direction[0] = start.goEast();
        direction[1] = start.goNorth();
        for (Intersection next: direction) {
            for (Path path: PathUtils.findAllPaths(next, end)) {
                path.addHead(start);
                ans.add(path);
            }
        }
        return ans;
    }
}
