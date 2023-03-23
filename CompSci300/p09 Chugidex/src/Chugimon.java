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

/**
 * This class models the Chugimon data type.
 */
public class Chugimon
        implements Comparable<Chugimon>
{
    /**
     * The minimum ID number
     */
    public static final int MIN_ID = 1;

    /**
     * The maximum ID number
     */
    public static final int MAX_ID = 151;

    /**
     * The name of the Chugimon
     */
    private final String NAME;

    /**
     * The first ID of the Chugimon
     */
    private final int FIRST_ID;

    /**
     * The second ID of the Chugimon
     */
    private final int SECOND_ID;

    /**
     * The primary type of the Chugimon; cannot be null; cannot be the same as the secondary type
     */
    private final ChugiType PRIMARY_TYPE;

    /**
     * The secondary type of the Chugimon; may be null; cannot be the same as the primary type
     */
    private final ChugiType SECONDARY_TYPE;

    /**
     * The height of the Chugimon in meters
     */
    private final double HEIGHT;

    /**
     * The weight of the Chugimon in kilograms
     */
    private final double WEIGHT;

    /**
     *
     * @param firstID the first ID of the Chugimon, between 1-151
     * @param secondID the second ID of the Chugimon, between 1-151
     */
    public Chugimon(int firstID, int secondID)
    {
        if (firstID == secondID ||
                firstID < MIN_ID ||
                firstID > MAX_ID ||
                secondID < MIN_ID ||
                secondID > MAX_ID)
            throw new IllegalArgumentException();
        this.FIRST_ID = firstID;
        this.SECOND_ID = secondID;
        this.NAME = ChugidexUtility.getChugimonName(this.FIRST_ID, this.SECOND_ID);
        this.PRIMARY_TYPE = ChugidexUtility.getChugimonTypes(this.FIRST_ID, this.SECOND_ID)[0];
        this.SECONDARY_TYPE = ChugidexUtility.getChugimonTypes(this.FIRST_ID, this.SECOND_ID)[1];
        this.HEIGHT = ChugidexUtility.getChugimonHeight(this.FIRST_ID, this.SECOND_ID);
        this.WEIGHT = ChugidexUtility.getChugimonWeight(this.FIRST_ID, this.SECOND_ID);
    }

    /**
     * Gets the name of this Chugimon
     * @return the name of the Chugimon
     */
    public String getName()
    {
        return this.NAME;
    }

    /**
     * Gets the first ID of this Chugimon
     * @return
     */
    public int getFirstID()
    {
        return this.FIRST_ID;
    }

    /**
     * Gets the second ID of thid Chugimon
     * @return the second ID of the Chugimon
     */
    public int getSecondID()
    {
        return this.SECOND_ID;
    }

    /**
     * Gets the primary type of this Chugimon
     * @return the primary type of the Chugimon
     */
    public ChugiType getPrimaryType()
    {
        return this.PRIMARY_TYPE;
    }

    /**
     * Gets the secondary type of this Chugimon
     * @return the secondary type of the Chugimon
     */
    public ChugiType getSecondaryType()
    {
        return this.SECONDARY_TYPE;
    }

    /**
     * Gets the height of this Chugimon
     * @return the height of the Chugimon
     */
    public double getHeight()
    {
        return this.HEIGHT;
    }

    /**
     * Gets the the weight of the Chugimon.
     * @return the weight of the Chugimon.
     */
    public double getWeight()
    {
        return this.WEIGHT;
    }

    /**
     * Determines the ordering of Chugimon. Chugimon are ordered by:
     * 1) name (alphabetical)
     * 2) the first ID (if name is equal). The one with the smaller first ID is less than the other.
     * 3) the second ID (if name and first ID are equal). The one with the smaller second ID is less
     * than the other.
     * A Chugimon with identical #1-3 are considered equal.
     * @param otherChugi the object to be compared.
     * @return a negative int if this Chugimon is less than other,
     * a positive int if this Chugimon is greater than other,
     * or 0 if this and the other Chugimon are equal.
     */
    @Override
    public int compareTo(Chugimon otherChugi)
    {
        if (this.getName().compareTo(otherChugi.getName()) != 0)
            return this.getName().compareTo(otherChugi.getName());
        if (Integer.compare(this.getFirstID(), otherChugi.getFirstID()) != 0)
            return Integer.compare(this.getFirstID(), otherChugi.getFirstID());
        return Integer.compare(this.getSecondID(), otherChugi.getSecondID());
    }

    /**
     * A Chugimon's String representation is its name followed by
     * "#FIRST_ID.SECOND_ID" -- Example: "Zapchu#145.25"
     * @return a String representation of this Chugimon
     */
    @Override
    public String toString()
    {
        return this.getName() + "#" + this.getFirstID() + "." + this.getSecondID();
    }

    /**
     * Equals method for Chugimon.
     * This Chugimon equals another object if other is a Chugimon with the exact same name,
     * and their both first and second IDs match.
     * @param other Object to determine equality against this Chugimon
     * @return true if this Chugimon and other Object are equal, false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this)
            return true;
        if (!(other instanceof Chugimon tmp))
            return false;
        return tmp.compareTo(this) == 0;
    }
}
