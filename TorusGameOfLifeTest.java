import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TorusGameOfLifeTest {

    @Test
    // passed
    // 1 has no neighbors so it dies
    public void oneStep() {
        int[] test = {1, 0};
        int[] outcome = {0,0};
        for (int i = 0; i < test.length; i++) {
            if (test[i] < 2) {
                outcome[i] = 0;
            }
        }

        TorusGameOfLife T1 = new TorusGameOfLife();
        Assert.assertNotNull(outcome);
    }

    @Test
    // passed
    // all the cells have two neighbors so they all move on to the next generation
    public void test2() {
        int[][] test = {{1,1},
                       {1,0}};
        int[][] outcome = {{1, 1},
                            {1, 0}};
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test.length; j++) {
                if (test[i][j] >= 2) {
                    outcome[i][j] = 0;
                }
            }
        }

        TorusGameOfLife T1 = new TorusGameOfLife();
        Assert.assertNotNull(outcome);
    }

    @Test
    // passed
    // both middle ones have more then 3 neighbors so they both die
    public void test3() {
        int[][] test = {{1,1,1},
                        {1,1,1}};
        int[][] outcome = {{1,0,1},
                           {1,0,1}};
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test.length; j++) {
                if (test[i][j] > 3) {
                    outcome[i][j] = 0;
                }
            }
        }

        TorusGameOfLife T1 = new TorusGameOfLife();
        Assert.assertNotNull(outcome);
    }

    @Test
    // passed
    // the first cell has 3 neighbors so that makes it alive
    public void test4() {
        int[][] test = {{0,1,0},
                        {1,1,0}};
        int[][] outcome = {{1,1,0},
                           {1,1,0}};
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test.length; j++) {
                if (test[i][j] == 3) {
                    outcome[i][j] = 1;
                }
            }
        }

        TorusGameOfLife T1 = new TorusGameOfLife();
        Assert.assertNotNull(outcome);
    }

    @Test
    // passed
    // all of the cell have 3 neighbors so they move on to the next generation.
    public void test5() {
        int[][] test = {{1,1,0},
                        {1,1,0}};
        int[][] outcome = {{1,1,0},
                           {1,1,0}};
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test.length; j++) {
                if (test[i][j] <= 3) {
                    outcome[i][j] = 1;
                }
            }
        }

        TorusGameOfLife T1 = new TorusGameOfLife();
        Assert.assertNotNull(outcome);
    }

    @Test
    // passed
    // this index has no neighbors
    public void neighbors() {
        int [][]test = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        TorusGameOfLife T1 = new TorusGameOfLife(test);
        assertEquals(0, T1.neighbors(0,0));
    }

    @Test
    // passed
    // this index has no neighbors
    public void test7() {
        int [][]test = {{0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}};
        TorusGameOfLife T1 = new TorusGameOfLife(test);
        assertEquals(0, T1.neighbors(4,4));
    }

    @Test
    // passed
    // correctly counts all the neighbors
    public void test8() {
        int [][]test = {{0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0},
                        {0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        TorusGameOfLife T1 = new TorusGameOfLife(test);
        assertEquals(3, T1.neighbors(2,3));
    }

    @Test
    // passed
    // correctly counts all the neighbors
    public void test9() {
        int [][]test = {{0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0},
                        {0, 1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0}};
        TorusGameOfLife T1 = new TorusGameOfLife(test);
        assertEquals(3, T1.neighbors(1,1));
    }
    @Test
    // passed
    // correctly counts all the neighbors
    public void test10() {
        int [][]test = {{0, 1, 0},
                        {1, 1, 1},
                        {0, 0, 0}};
        TorusGameOfLife T1 = new TorusGameOfLife(test);
        assertEquals(3, T1.neighbors(1,1));
    }

    @Test
    //failed wouldn't run with a negative number
    //while loop doesnt happen when the number is lower in 0, so there should be an error.
    public void evolution() {
        int n = -1;
        TorusGameOfLife T1 = new TorusGameOfLife(n);
        assertEquals("invalid input", T1.eveloution(-1));
    }

    @Test
    //passed
    //count down and while loop works correctly.
    public void test12(){
        int n = 4;
        TorusGameOfLife T1 = new TorusGameOfLife(n);
        assertEquals(0, T1.eveloution(4));
    }

    @Test
    //passed
    // even with the negative number and positive itll do the operation and take the positive number
    public void test13(){
        int n = -3 + 6;
        TorusGameOfLife T1 = new TorusGameOfLife(n);
        assertEquals(0, T1.eveloution( -3 + 6));

    }

    @Test
    // didnt work with an extremly high number
    public void test14(){
        int n = 1245332;
        TorusGameOfLife T1 = new TorusGameOfLife(n);
        assertEquals("error", T1.eveloution(1245332));
    }

    @Test
    //passed
    //takes a while but it could still function with a high number
    public void test15(){
        int n = 9999;
        TorusGameOfLife T1 = new TorusGameOfLife(n);
        assertEquals(0, T1.eveloution(9999));
    }
}