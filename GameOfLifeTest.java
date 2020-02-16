import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {

    @Test
    // passed wont do out of bounds
    public void neighbors() {
        int[][] test1 = {{0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 1, 1, 1, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0}};
        GameOfLife T1 = new GameOfLife(test1);
        assertEquals(0, T1.neighbors(0,0));

    }
    @Test
    // passed wont go out of bounds
    public void test7() {
        int[][] test1 = {{0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 1, 1, 1, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0}};
        GameOfLife T1 = new GameOfLife(test1);
        assertEquals(0, T1.neighbors(4,4));

    }

    @Test
    // correctly counts the number of neighbors
    public void test8() {
        int[][] test1 = {{0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0},
                         {0, 0, 1, 1, 1, 0},
                         {0, 1, 1, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0}};
        GameOfLife T1 = new GameOfLife(test1);
        assertEquals(4, T1.neighbors(2,3));

    }

    @Test
    // correctly counts the number of neighbors
    public void test9() {
        int[][] test1 = {{0, 0, 0, 0, 0, 0},
                         {0, 1, 1, 0, 0, 0},
                         {0, 1, 1, 0, 0, 0},
                         {0, 0, 0, 1, 1, 0},
                         {0, 0, 0, 1, 1, 0},
                         {0, 0, 0, 0, 0, 0}};
        GameOfLife T1 = new GameOfLife(test1);
        assertEquals(4, T1.neighbors(3,3));

    }

    @Test
    // keeps going out of bounds i am not sure why, says it doing out of bounds on 11
    public void test10() {
        int[][] test1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        GameOfLife T1 = new GameOfLife(test1);
        assertEquals(0, T1.neighbors(10, 10));

    }
}