/*              "+---------------------+--------+-----------+-------+-------+\n" +
                "|                     | Insert | Selection | Quick | Merge |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 100 Random          |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 1000 Random         |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 1000 few unique     |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 1000 nearly ordered |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 1000 reverse order  |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 1000 sorted         |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+\n" +
                "| 10000 random        |        |           |       |       |\n" +
                "+---------------------+--------+-----------+-------+-------+"  */

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    private static final double DELTA = 1e-15;
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

