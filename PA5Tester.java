///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA5Tester
// File:               PA5Tester.java
// Quarter:            Winter 2022
//
// Author:             Dorsa DaneshDezfuli
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Arrays;
import java.util.Random;

public class PA5Tester {

    // Seed passed to random generator to match the expected output
    private static int SEED = 2017;

    /**
     * Main method runs a series of test on the Board object.
     *
     * @param args (not used)
     */
    public static void main(String[] args) {

        PA5Tester solver = new PA5Tester();

        System.out.println("\n\n*************** Testing PA5 *****************");

        int score = 0;
        score += solver.testPrintBoard();
        score += solver.testCanMove();
        score += solver.testMove();

        // This is just a reminder to implement more tests.
        // Once you have implemented the required tests for this PA, you can
        // remove this if statement/println if you want (you don't have to)
        // if (score == 2) {
        // System.out.println(
        // "NOTE: MAKE SURE TO CREATE MORE UNIT TESTS");
        // }

        System.out.println("*************************************************");

    }

    /************************ TEST PRINT BOARD ************************/

    /**
     * Test the board's printBoard method.
     *
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testPrintBoard() {
        System.out.println("Testing printBoard method .......................");

        Board board1 = new Board(new Random(SEED), new int[][] {
                { 2, 4, 0, 0 },
                { 0, 0, 8, 4 },
                { 0, 16, 0, 4 },
                { 1024, 2, 4, 256 } });

        System.out.println("\nPrinting current board ......................\n");
        board1.printBoard();
        System.out.println("\nPrinting board after moving UP ..............\n");
        board1.printBoard(board1.UP);
        System.out.print("\nPrinting board to see previous ");
        System.out.println("board remains ........\n");
        board1.printBoard();
        System.out.println("\nPrinting board after moving LEFT ............\n");
        board1.printBoard(board1.LEFT);
        System.out.print("\nPrinting board to see previous ");
        System.out.println("board remains ........\n");
        board1.printBoard();
        System.out.println("\n***********************************************");
        return 0;
    }

    /************************ TEST CAN MOVE ************************/

    /**
     * Test the board's canMove method.
     * TODO: Add tests to this method.
     * 
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testCanMove() {
        System.out.print("Testing canMove method......................");

        Board board = new Board(new Random(SEED), new int[][] {
                { 0, 0, 0, 4 },
                { 0, 0, 0, 4 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } });

        if (board.canMove(board.LEFT)) {
            // Passed, do nothing.
        } else {
            System.out.println("FAILED!\nBoard should be able to move left:");
            board.printBoard();
            return 0;
        }

        if (board.canMove(board.UP) && !board.canMove(board.RIGHT) &&
                board.canMove(board.DOWN)) {
            // Passed, do nothing.
        } else {
            System.out.println("FAILED!");
            if (!board.canMove(board.UP)) {
                System.out.println("Board should be able to move UP:");
            }
            if (board.canMove(board.RIGHT)) {
                System.out.println("Board should NOT be able to move RIGHT:");
            }
            if (!board.canMove(board.DOWN)) {
                System.out.println("Board should be able to move DOWN:");
            }
            board.printBoard();
            return 0;
        }

        // More Tests:
        Board boardTest1 = new Board(new Random(SEED), new int[][] {
                { 0, 0, 0, 0 },
                { 8, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 16, 2, 0, 0 } });

        if (boardTest1.canMove(boardTest1.LEFT)) {
            System.out.println("FAILED!\nBoard should not be able to move left:");
            boardTest1.printBoard();
            return 0;
        } else {
            // passed
        }
        System.out.println("Passed extra testcase1!");
        return 1;

    }

    /************************ TEST MOVE ************************/
    /**
     * Test the board's move method.
     * TODO: Add tests to this method.
     * 
     * @return 1 if the tests pass, 0 if they fail
     */
    public int testMove() {
        System.out.print("Testing move method.........................");
        int passed = 1;

        Board board_left = new Board(new Random(SEED), new int[][] {
                { 0, 2, 2, 0 },
                { 0, 0, 16, 8 },
                { 2, 128, 128, 32 },
                { 16, 16, 16, 16 } });

        board_left.move(board_left.LEFT);
        if (!isEqualArray(boardToArray(board_left), new int[][] {
                { 4, 0, 0, 0 },
                { 16, 8, 0, 0 },
                { 2, 256, 32, 0 },
                { 32, 32, 0, 0 } })) {
            System.out.println("FAILED!");
            System.out.println("move(Board.LEFT) implemented incorrectly");
            return 0;
        }

        // TODO: Add more tests for moveLeft here.

        Board board_right = new Board(new Random(SEED), new int[][] {
                { 2, 4, 8, 2 },
                { 2, 4, 8, 2 },
                { 2, 4, 8, 0 },
                { 2, 4, 8, 2 } });

        board_right.move(board_right.RIGHT);
        if (!isEqualArray(boardToArray(board_right), new int[][] {
                { 2, 4, 8, 2 },
                { 2, 4, 8, 2 },
                { 0, 2, 4, 8 },
                { 2, 4, 8, 2 } })) {
            System.out.println("FAILED!");
            System.out.println("move(Board.RIGHT) is implemented incorrectly");
            return 0;
        }

        Board board_up = new Board(new Random(SEED), new int[][] {
                { 0, 8, 4, 8 },
                { 0, 0, 128, 8 },
                { 2, 8, 128, 256 },
                { 0, 0, 2, 64 } });

        board_up.move(board_up.UP);
        if (!isEqualArray(boardToArray(board_up), new int[][] {
                { 2, 16, 4, 16 },
                { 0, 0, 256, 256 },
                { 0, 0, 2, 64 },
                { 0, 0, 0, 0 } })) {
            System.out.println("FAILED!");
            System.out.println("move(Board.UP) implemented incorrectly");
            return 0;
        }

        Board board_down = new Board(new Random(SEED), new int[][] {
                { 2, 0, 0, 2 },
                { 2, 0, 8, 2 },
                { 2, 4, 8, 0 },
                { 2, 4, 0, 2 } });

        board_down.move(board_down.DOWN);
        if (!isEqualArray(boardToArray(board_down), new int[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 4, 0, 0, 2 },
                { 4, 8, 16, 4 } })) {
            System.out.println("FAILED!");
            System.out.println("move(Board.DOWN) implemented incorrectly");
            return 0;
        }

        // TODO: Add more tests here.

        System.out.println("Passed!");
        return 1;
    }

    /**
     * Creates int[][] given a board object. Helper method to make sure
     * tests are working correctly.
     *
     * @return the array representation of the board's grid.
     */
    private int[][] boardToArray(Board board) {
        if (board == null) {
            return null;
        }
        int[][] array = new int[board.GRID_SIZE][board.GRID_SIZE];
        for (int r = 0; r < board.GRID_SIZE; r++) {
            for (int c = 0; c < board.GRID_SIZE; c++) {
                array[r][c] = board.getTileValue(r, c);
            }
        }
        return array;
    }

    /**
     * Compares two 2D int arrays. Helper method to make sure
     * tests are working correctly.
     *
     * Precondition: The arrays are the same size and not null.
     *
     * @return true if the arrays contain all the same values, false otherwise
     */
    private boolean isEqualArray(int[][] grid1, int[][] grid2) {
        for (int r = 0; r < grid1.length; ++r) {
            for (int c = 0; c < grid1.length; ++c) {
                if (grid1[r][c] != grid2[r][c])
                    return false;
            }
        }
        return true;
    }
}
