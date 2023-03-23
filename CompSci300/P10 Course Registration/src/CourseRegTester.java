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

import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Course,  CourseIterator, 
 * CourseQueue and CourseReg classes in P10.
 *
 * Be aware that all methods in this class will be run against not only your code, but also our own
 * working and broken implementations to verify that your tests are working appropriately!
 */
public class CourseRegTester {
	
	/**
	 * START HERE, and continue with testCompareTo() after this.
	 *
	 * This method must test the Course constructor, accessor, and mutator methods, as well as its
	 * toString() implementation. The compareTo() method will get its own test.
	 *
	 * @see Course
	 * @return true if the Course implementation is correct; false otherwise
	 */
	public static boolean testCourse() {
		Course test1 = new Course("CS", 400, 3, 195);
		if (test1.getNumCredits() != 3)
			return false;
		test1.setProfessor("A", 3.4);
		if (!test1.toString().equals("CS 400 (195 seats) with A (3.4)"))
			return false;
		boolean ans = false;
		try
		{
			test1.setProfessor("A", -1);
		}
		catch (IllegalArgumentException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		ans = false;
		try
		{
			Course test2 = new Course("", 400, 3, 195);
		}
		catch (IllegalArgumentException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		ans = false;
		try
		{
			Course test2 = new Course("CS", -1, 3, 195);
		}
		catch (IllegalArgumentException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		ans = false;
		try
		{
			Course test2 = new Course("CS", 400, -1, 195);
		}
		catch (IllegalArgumentException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		ans = false;
		try
		{
			Course test2 = new Course("CS", 400, 3, -1);
		}
		catch (IllegalArgumentException e)
		{
			ans = true;
		}
		return ans;// TODO: complete this test
	}
	
	/**
	 * This method must test the Course compareTo() implementation. Be sure to test ALL FOUR levels
	 * of the comparison here!
	 * <p>
	 * Once you complete this test, finish the Course implementation if you have not done so already,
	 * then move to testCourseQueue() and testEnqueueDequeue().
	 *
	 * @see Course#compareTo(Course)
	 * @return true if the compareTo() implementation is correct; false otherwise
	 */
	public static boolean testCompareTo() {
		Course test1 = new Course("CS", 400, 3, 195);
		Course test2 = new Course("Math", 221, 3, 200);
		if (test1.compareTo(test2) <= 0)
			return false;
		test1 = new Course("CS", 400, 3, 0);
		test2 = new Course("CS", 300, 3, 195);
		if (test1.compareTo(test2) >= 0)
			return false;
		test1 = new Course("CS", 400, 3, 195);
		test2 = new Course("CS", 400, 3, 195);
		test1.setProfessor("A", 3.5);
		if (test1.compareTo(test2) <= 0)
			return false;
		test2.setProfessor("B", 3.2);
		return test1.compareTo(test2) > 0;// TODO: complete this test
	}
	
	/**
	 * This method must test the other methods in CourseQueue (isEmpty, size, peek). Verify normal
	 * cases and error cases, as well as a filled and re-emptied queue.
	 *
	 * Once you have completed this method, implement the required methods in CourseQueue and verify
	 * that they work correctly.
	 *
	 * @see CourseQueue
	 * @return true if CourseQueue's other methods are implemented correctly; false otherwise
	 */
	public static boolean testCourseQueue() {
		CourseQueue test = new CourseQueue(2);
		if (!test.isEmpty())
			return false;
		if (test.size() != 0)
			return false;
		boolean ans = false;
		try
		{
			test.peek();
		}
		catch (NoSuchElementException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		Course test1 = new Course("CS", 400, 3, 195);
		Course test2 = new Course("Math", 252, 3, 300);
		test.enqueue(test1);
		test.enqueue(test2);
		if (test.isEmpty())
			return false;
		if (test.size() != 2)
			return false;
		if (!test.peek().equals(test1))
			return false;
		test.dequeue();
		test.dequeue();
		if (!test.isEmpty())
			return false;
		if (test.size() != 0)
			return false;
		ans = false;
		try
		{
			test.peek();
		}
		catch (NoSuchElementException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		return true;
	}
	
	/**
	 * This method must test the enqueue and dequeue methods in CourseQueue. Verify normal cases and
	 * error cases, as well as filling and emptying the queue.
	 *
	 * You may also test the percolate methods directly, though this is not required.
	 *
	 * Once you have completed this method, implement the enqueue/dequeue and percolate methods in
	 * CourseQueue and verify that they work correctly, then move on to testCourseIterator().
	 *
	 * @see CourseQueue#enqueue(Course)
	 * @see CourseQueue#dequeue()
	 * @return true if the CourseQueue enqueue/dequeue implementations are correct; false otherwise
	 */
	public static boolean testEnqueueDequeue() {
		CourseQueue test = new CourseQueue(2);
		boolean ans = false;
		try
		{
			test.dequeue();
		}
		catch (NoSuchElementException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		Course test1 = new Course("CS", 300, 3, 195);
		Course test2 = new Course("Math", 240, 3, 33);
		test.enqueue(test1);
		test.enqueue(test2);
		ans = false;
		try
		{
			test.enqueue(test1);
		}
		catch (IllegalStateException e)
		{
			ans = true;
		}
		if (!ans)
			return false;
		return true; // TODO: complete this test
	}
	
	/**
	 * This method must test the CourseIterator class. The CourseIterator iterates through a deep copy
	 * of a CourseQueue in decreasing order of priority, returning each Course object in turn.
	 *
	 * Once you have completed this method, implement the CourseIterator class and make CourseQueue
	 * into an Iterable class. Verify that this works correctly, and then move on to the final test
	 * method: testCourseReg().
	 *
	 * @see CourseIterator
	 * @return true if the CourseIterator implementation is correct; false otherwise
	 */
	public static boolean testCourseIterator() {
		Course test1 = new Course("CS", 300, 3, 195);
		Course test2 = new Course("Math", 200, 3, 33);
		Course test3 = new Course("Math", 222, 3, 0);
		CourseQueue test = new CourseQueue(3);
		test.enqueue(test1);
		test.enqueue(test2);
		test.enqueue(test3);
		Course[] comp = new Course[]{test1, test2, test3};
		int id = 0;
		for (Course course: test)
		{
			if (!course.equals(comp[id]))
				return false;
			id += 1;
		}
		return true; // TODO: complete this test
	}
	
	/**
	 * This method must test the constructor and three methods of the CourseReg class (setCreditLoad,
	 * add, and getRecommendedCourses). Verify normal cases and error cases.
	 *
	 * Once you have completed this method, implement CourseReg and verify that it works correctly.
	 * Then you're DONE! Save and submit to gradescope, and enjoy being DONE with programming
	 * assignments in CS 300 !!!
	 *
	 * @see CourseReg
	 * @return true if CourseReg has been implemented correctly; false otherwise
	 */
	public static boolean testCourseReg() {
		try
		{
			CourseReg test = new CourseReg(3, 3);
			boolean ans = false;
			try
			{
				test.setCreditLoad(-200);
			}
			catch (IllegalArgumentException e)
			{
				ans = true;
			}
			if (!ans)
				return false;
			test.setCreditLoad(3);
			Course test1 = new Course("CS", 300, 1, 111);
			Course test2 = new Course("CS", 300, 4, 0);
			Course test3 = new Course("Math", 400, 1, 54);
			if (!test.add(test1))
				return false;
			if (!test.add(test2))
				return false;
			if (!test.add(test3))
				return false;
			if (test.add(test2))
				return false;
//			System.out.println("\n" + test.getRecommendedCourses().trim());
			if (!test.getRecommendedCourses().trim().equals(test1.toString().trim() + "\n" + test3.toString().trim())
			&& !test.getRecommendedCourses().trim().equals(test3.toString().trim() + "\n" + test1.toString().trim()))
				return false;
			return true; // TODO: complete this test
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	/**
	 * This method calls all test methods defined by us; you may add additional methods to this if
	 * you like. All test methods must be public static boolean.
	 *
	 * @return true if all tests in this class return true; false otherwise
	 */
	public static boolean runAllTests() {
		boolean testVal = true;
		
		// test Course
		System.out.print("testCourse(): ");
		if (!testCourse()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		// test compareTo
		System.out.print("testCompareTo(): ");
		if (!testCompareTo()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		// test CourseIterator
		System.out.print("testCourseIterator(): ");
		if (!testCourseIterator()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		// test CourseQueue enqueue/dequeue
		System.out.print("testEnqueueDequeue(): ");
		if (!testEnqueueDequeue()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		// test CourseQueue
		System.out.print("testCourseQueue(): ");
		if (!testCourseQueue()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		// test CourseReg
		System.out.print("testCourseReg(): ");
		if (!testCourseReg()) {
			System.out.println("FAIL");
			testVal = false;
		} else { System.out.println("pass"); }
		
		return testVal;
	}
	
	/**
	 * Calls runAllTests() so you can verify your program
	 *
	 * @param args input arguments if any.
	 */
	public static void main(String[] args) {
		runAllTests();
	}
}
