package CompSci300.cQuiz01.src;

///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: HuaiYuan Jing
// Campus ID: 9084099523
// WiscEmail: hjing7@wisc.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

////////////////////////////////////////////////////////////////////////////////
//
// This file contains ONE class. You will need to complete the implementation
// this class with respect to the provided requirements in the TODO tags for
// full credit.
//
// When creating new exception objects, including messages within these objects
// is optional.
////////////////////////////////////////////////////////////////////////////////

/**
 * This class implements methods to store and manage the list of courses in a campus. The list of
 * courses is stored in an oversize array defined by a reference to an array of strings which stores
 * course labels and an int variable which keeps track of the size of the array. Examples of course
 * labels: "cs200", "cs300", "me407", "ece252", etc.
 *
 * We assume that all the course labels are correctly formatted.
 *
 * The array courses is an oversize array. This means it contains non null references from index 0
 * to index size-1. All references in the range of indexes size .. courses.length-1 MSUT be null.
 *
 * In this courseList class, new courses are added to the end of the array. Removal operations are
 * made from the beginning of the array.
 *
 * All string comparisons are CASE-SENSITIVE.
 *
 */
public class CourseList {

    /**
     * Inserts a new course to the end of the oversize array of courses defined by courses and size.
     *
     * @param courses   an array which stores course labels
     * @param size      number of courses stored in the courses array
     * @param newCourse courses to be inserted in the courses array
     * @return the size of the oversize array after trying to insert newCourse to the list of courses
     * @throws IllegalStateException if the array courses is full
     */
    public static int addLast(String[] courses, int size, String newCourse)
            throws IllegalStateException {
        // TODO
        // 1. throw an IllegalStateException if courses array is full
        if (size == courses.length) {
            throw new IllegalStateException();
        }
        // 2. add newCourse to the end of the oversize array
        size++;
        courses[size - 1] = newCourse;
        // 3. return size
        return size; // default return statement added to avoid compiler errors. Feel free to change it.
    }

    /**
     * Gets the number of computer science courses in the course list defined by courses and size. A
     * CS course is identified by the two first characters of its label, which must be equal to "cs".
     *
     * @param courses an array which stores strings representing labels of courses taught in a campus
     * @param size    number of course labels stored in courses
     * @return the number of cs courses stored in the oversize array courses.
     */
    public static int getCsCoursesCount(String[] courses, int size) {
        // TODO implement this method
        int cnt = 0;
        for (int i = 0; i < size; ++i) {
            if (courses[i].substring(0, 2).equals("cs")) {
                cnt++;
            }
        }
        return cnt; // default return statement added to avoid compiler errors. Feel free to change it.
    }

    /**
     * Removes the course stored at index zero of the oversize array defined by courses and size.
     *
     * If the array is empty (its siz message:
     * e is zero), this method prints the following
     * "Error! Empty course list."
     *
     * @param courses an array which stores course labels
     * @param size    size of the courses array
     * @return the size of the oversize array after trying to remove the course at index 0.
     */
    public static int removeFirst(String[] courses, int size) {
        // TODO Complete the implementation of this method
        // Hint: Removing the element at index zero involves a shift operation
        // For instance if the original array courses contained
        // {e0, e1, e2, e3, null, null} and size was 4,
        // after calling removeFirst(courses, size) the array courses should contain
        // {e1, e2, e3, null, null, null} and the returned value should be 3.
        if (size == 0) {
            System.out.println("Error! Empty course list.");
            return 0;
        }
        for (int i = 0; i < size - 1; ++i) {
            courses[i] = courses[i + 1];
        }
        courses[size - 1] = null;
        size -= 1;
        return size; // default return statement added to avoid compiler errors. Feel free to change it.
    }

    /**
     * Checks whether the correctness of the CourseList.addLast() method when passed a non-full
     * oversize array.
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testSuccessfulAddLast() {
        // TODO
        // 1. Create an NON-full oversize array of Strings which already contains 3 courses.
        String[] courses = new String[] {"cs100", "cs200", "cs300", null, null, null, null};
        int size = 3;
        // 2. Try to call CourseList.addLast() to add "ep547" to the list of courses
        size = addLast(courses, size, "ep547");
        // 3. Expected behavior: The new course must be added at the end of the array and the method
        // should return 4 (new size of the oversize array)
        // Check that the method addLast() did make the expected changes to the contents of the original
        // array passed as input.
        // You DO NOT need to check for unexpected exceptions in this tester.
        if (size != 4) {
            return false;
        }
        String[] expected = new String[] {"cs100", "cs200", "cs300", "ep547", null, null, null};
        if (!Arrays.deepEquals(courses, expected)) {
            return false;
        }
        // 4. This tester returns true if no bugs are detected

        return true; // default return statement added to avoid compiler errors. Feel free to change
        // it.
    }

    /**
     * Checks the correctness of the implementation of the CourseList.getCsCoursesCount() method when
     * passed an non-empty array containing a few cs courses.
     *
     * @return true if the method passes this test and false otherwise
     */
    public static boolean testGetCsCoursesCount() {
        // This tester method does not check for all test scenarios to check the correctness of
        // getCsCoursesCount() method. This is NOT a programming assignment. You do not need to check
        // for
        // everything in an exam.

        // test scenario: non-empty oversize array of course labels
        String[] courses =
                new String[] {"cs200", "ece252", "cs300", "art101", "me407", "cs502", null, null, null};
        int size = 6;
        int expectedCount = 3; // expected output
        String[] original =
                new String[] {"cs200", "ece252", "cs300", "art101", "me407", "cs502", null, null, null};
        try {
            // call getCsCoursesCount() and check whether it returns the expected output without making
            // any
            // changes to the contents of the array passed as input
            int count = getCsCoursesCount(courses, size);
            if (count != expectedCount) // bug! incorrect output
                return false;
            if (!Arrays.deepEquals(courses, original)) // bug! changes made to the courses array
                return false;


        } catch (Exception e) { // catches any unexpected exception
            return false;
        }
        return true; // no bugs detected by this tester
    }

    /**
     * Checks whether the CourseList.removeFirst method works as expected when called to remove the
     * course at index zero from a non-empty oversize array of Strings
     *
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testFirstCourseRemoval() {
        // create an non-empty oversize array
        String[] courses =
                new String[] {"cs240", "art200", "cs300", "ece252", "cs400", null, null, null};
        int size = 5;
        // expected output and array after removing the first course
        String[] expectedCourses =
                new String[] {"art200", "cs300", "ece252", "cs400", null, null, null, null};
        int expectedOutput = 4;
        try {
            // try to remove the course at index zero
            size = removeFirst(courses, size);
            // check whether the returned size and the content of the array are correct
            if (size != expectedOutput)
                return false;
            if (!Arrays.deepEquals(courses, expectedCourses))
                return false;
        } catch (Exception e) {
            return false; // no exception is expected to be thrown
        }

        return true; // no bugs detected by this tester
    }

    /**
     * Main method to call the test methods
     *
     * @param args - input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("testGetCsCoursesCount(): " + testGetCsCoursesCount());
        System.out.println("testFirstCourseRemoval(): " + testFirstCourseRemoval());
        System.out.println("testSuccessfulAddLast(): " + testSuccessfulAddLast());
    }
}
