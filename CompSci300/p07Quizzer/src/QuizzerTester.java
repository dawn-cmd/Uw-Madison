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
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class checks the correctness of the implementation of cs300 Fall 2022 p07 Quizzer
 */
public class QuizzerTester
{
    /**
     * This method test and make use of the MultipleChoiceQuestion constructor,
     * an accessor (getter) method,
     * overridden method toString() and equal() method defined in the MultipleChoiceQuestion class.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testMultipleChoiceQuestion()
    {
        String[] ans = new String[]{"a", "b"};
        MultipleChoiceQuestion a = new MultipleChoiceQuestion(
                "A",
                "what?",
                ans,
                0,
                5);
        if (!a.getQuestion().equals("what?"))
            return false;
        if (!a.getAnswers().equals("1. a\n2. b"))
            return false;
        if (!a.getTitle().equals("A"))
            return false;
        if (a.getPointsPossible() != 5)
            return false;
        if (a.getCorrectAnswerIndex() != 0)
            return false;
        a.setStudentAnswerIndex(1);
        if (a.getStudentAnswerIndex() != 1)
            return false;
        if (!a.toString().equals("QUESTION TITLE: \"A\"\nQuestion:\nwhat?\nAvailable Answers:\n1. a\n2. b"))
            return false;
        return a.equals(a.copy());
    }

    /**
     * This method test and make use of the LinkedNode constructor,
     * an accessor (getter) method,
     * and a mutator (setter) method defined in the LinkedNode class.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean testLinkedNode()
    {
        LinkedNode<Integer> cur = new LinkedNode<>(5);
        LinkedNode<Integer> nxt = new LinkedNode<>(7);
        cur.setNext(nxt);
        return cur.getNext().getData() == 7;
    }

    /**
     * Runs all the tester methods defined in this QuizzerTester
     * @return true if all tests pass and false if any of the tests fails
     */
    public static boolean runAllTests()
    {
        return testMultipleChoiceQuestion()
                && testLinkedNode();
    }

    /**
     * Main method
     * @param args list of input arguments if any
     */
    public static void main(String[] args)
    {
        System.out.println(runAllTests());
    }
}
