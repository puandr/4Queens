package com.company;

public class Main {

    // All queens have to be on different rows, so this array will display it
    // Each array index represent one row, so queen Q0 on row 0, queen Q1 on row 1 etc.
    // Each array cell value will represent column on which this current queen is standing
    static int[] queenRows = {0, 0, 0, 0};
    static final int numberOfQueens = 4;

    public static void main(String[] args) {
        for (int queen0Column = 0; queen0Column < numberOfQueens; queen0Column++) {
            queenRows[0] = queen0Column;
            for (int queen1Column = 0; queen1Column < numberOfQueens; queen1Column++) {
                queenRows[1] = queen1Column;
                if (checkQueensCollision(1)) {
                    continue;
                }
                for (int queen2Column = 0; queen2Column < numberOfQueens; queen2Column++) {
                    queenRows[2] = queen2Column;
                    if (checkQueensCollision(2)) {
                        continue;
                    }
                    for (int queen3Column = 0; queen3Column < numberOfQueens; queen3Column++) {
                        queenRows[3] = queen3Column;
                        if (checkQueensCollision(3)) {
                            continue;
                        } else {
                            printSolution();
                        }
                    }
                }
            }
        }
    }

    public static boolean checkQueensCollision(int queenToCheck) {
        for (int i = 0; i < queenToCheck; i++) {
            if (queenRows[i] == queenRows[queenToCheck]) {
                return true;
            }
            if (diagonalCollision(queenToCheck)) {
                return true;
            }
        }
        return false;
    }

    public static boolean diagonalCollision(int queenToCheck) {
        for (int i = 0; i < queenToCheck; i++) {
            if(Math.abs(i - queenToCheck) == Math.abs(queenRows[i] - queenRows[queenToCheck])) {
                return true;
            }
        }
        return false;
    }

    public static void printSolution() {
        System.out.println();
        System.out.println("-----------------");
        for (int row = 0; row < numberOfQueens; row++) {
            for (int column = 0; column < numberOfQueens; column++) {
                if (thereIsQueen(row, column)) {
                    System.out.print("| Q ");
                } else if ((column + row) % 2 == 0){
                    System.out.print("| * ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
            System.out.println("-----------------");
        }
    }

    public static boolean thereIsQueen(int row, int column) {
        return queenRows[row] == column;
    }
}
