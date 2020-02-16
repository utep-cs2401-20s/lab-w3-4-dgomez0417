public class GameOfLife {

    int Size;
    int[][] Board;
    int[][] Previous;

    public GameOfLife() { // default constructor

    }

    public GameOfLife(int s) {
        Size = s;
        Board = new int[Size][Size]; //int Board to size
        Previous = new int[Size][Size];// int Previous to size
    }

    public GameOfLife(int[][] array) {
        Size = array.length;
        Board = new int[Size][Size];
        Previous = new int[Size][Size];
        //for loop and nested for loop: copying from array to Previous
        for (int i = 0; i < Previous.length; i++) {
            for (int j = 0; j < Previous[i].length; j++) {
                Previous[i][j] = array[i][j];
            }
        }
    }

    public int[][] getBoard() {

        return Board;
    }

    public void oneStep() {
        int alive = 1;
        int dead = 0;

        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
                Previous[i][j] = Board[i][j];
            }
        }

        for (int i = 0; i < Previous.length; i++) {
            for (int j = 0; j < Previous[i].length; j++) {
                // if == to one

                // rules of the game

                if (Previous[i][j] == 1) {


                    if (neighbors(i, j) < 2) {
                        Previous[i][j] = 0;
                    } else if (neighbors(i, j) >= 2 || neighbors(i, j) <= 3) {
                        Previous[i][j] = 1;
                    } else if (neighbors(i, j) > 3) {
                        Previous[i][j] = 0;
                    } else if (neighbors(i, j) == 3) {
                        Previous[i][j] = 1;
                    } else {
                        System.out.println("Invalid output");
                    }
                }
            }
        }
    }

    public int neighbors(int row, int col) {
        int n = 0;
        // dont double count

        if(Previous[row][col] == 1) {

            if (row >= 0 && row <= Previous.length && col >= 0 && col <= Previous.length) {
                if (Previous[row + 1][col] == 1) {
                    n++;
                }
                if (Previous[row - 1][col] == 1) {
                    n++;
                }
                if (Previous[row][col + 1] == 1) {
                    n++;
                }
                if (Previous[row][col - 1] == 1) {
                    n++;
                }
                if (Previous[row + 1][col + 1] == 1) {
                    n++;
                }
                if (Previous[row - 1][col - 1] == 1) {
                    n++;
                }
                if (Previous[row - 1][col + 1] == 1) {
                    n++;
                }
                if (Previous[row + 1][col - 1] == 1) {
                    n++;
                }
            }
        }
        return n;
    }

    public int eveloution(int n){

        // count down to make sure all the numbers were preformed.
        while (n != 0) {
            oneStep();
            n--;
        }
        return n;
    }
}
