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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for Courses in a priority queue, which returns the Courses in order from highest
 * priority to lowest.
 */
public class CourseIterator implements Iterator<Course> {

    // data field - you may NOT add any additional data fields to this class!
    private CourseQueue queue; // a DEEP COPY of the priority queue of courses to iterate over

    /**
     * Creates a new CourseIterator which iterates over the elements of the given CourseQueue
     * in order from the highest-priority course to the lowest-priority course
     *
     * @param queue a DEEP COPY of the queue to iterate over
     */
    public CourseIterator(CourseQueue queue) {
        this.queue = queue.deepCopy();
    }

    /**
     * Returns true if the iteration has more elements.
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return !this.queue.isEmpty();
    }

    /**
     * Returns the next element in the iteration. Consider how to use the priority queue's methods
     * to get the next course in descending order.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Course next() throws NoSuchElementException {
        // TODO Auto-generated method stub
        if (!hasNext())
            throw new NoSuchElementException();
        return this.queue.dequeue();
    }

}
