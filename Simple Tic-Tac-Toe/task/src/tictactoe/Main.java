package tictactoe;

import java.util.Scanner;

public class Main {
    public static char[][] initializeGrid(char[][] newTicTacToeGrid) {

        for(int i = 0; i < newTicTacToeGrid.length; ++i) {
            for(int j = 0; j < newTicTacToeGrid[i].length; ++j){
                newTicTacToeGrid[i][j] = ' ';
            }
        }
        return newTicTacToeGrid;
    }
    public static void printGrid(char[][] ticTacToeArray) {
        System.out.println("--------");
        for (int i = 0; i < ticTacToeArray.length; ++i) {
            System.out.print("| ");
            for(int j = 0; j < ticTacToeArray[i].length; ++j) {
                System.out.print(ticTacToeArray[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("--------");

    }
    // To check if X wins
    public static boolean xWins(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == 'X') { // Horizontal check
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == 'X') { // Vertical check
                return true;
            } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == 'X') { // Diagonal L to R check
                return true;
            } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == 'X') { // Diagonal R to L check
                return true;
            }
        }
        return false;
    }

    // To check if O wins
    public static boolean oWins(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == 'O') { // Horizontal check
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == 'O') { // Vertical check
                return true;
            } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == 'O') { // Diagonal L to R check
                return true;
            } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == 'O') { // Diagonal R to L check
                return true;
            }
        }
        return false;
    }
    public static char[][] playGame(char[][] ticTacToeArray, int row, int col, char playerSign) {
        ticTacToeArray[row][col] = playerSign;
        return ticTacToeArray;
    }

    public static void main(String[] args) {
        // Game variables
        boolean gameOn = true;
        int gridSize = 3;
        char[][] ticTacToeArray = new char[gridSize][gridSize];
        String result = " ";
        int gameCounter = 1;

        ticTacToeArray = initializeGrid(ticTacToeArray);

        // write your code here
        Scanner scanner = new Scanner(System.in);

        // Printing the grid elements
        printGrid(ticTacToeArray);

        while (gameOn) {
            System.out.println("Enter the coordinates: ");
            int playerRow = scanner.nextInt() - 1;
            int playerCol = scanner.nextInt() - 1;

            if (playerRow % 1 == 0 || playerCol % 1 == 0) {
                if (playerRow >= 0 && playerRow < gridSize && playerCol >= 0 && playerCol < gridSize) {
                    if (ticTacToeArray[playerRow][playerCol] == 'X' || ticTacToeArray[playerRow][playerCol] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (gameCounter % 2 != 0) {
                            printGrid(playGame(ticTacToeArray, playerRow, playerCol, 'X'));
                        } else {
                           printGrid (playGame(ticTacToeArray, playerRow, playerCol, 'O'));
                        }
                        gameCounter += 1;

                        // Game evaluation conditions
                        if (xWins(ticTacToeArray)) {
                            result = "X_wins";
                            gameOn = false;

                        } else if (oWins(ticTacToeArray)) {
                            result = "O_wins";
                            gameOn = false;
                        }
                    }

                } else {
                    System.out.println("Coordinates should be between 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        switch(result) {
            case "X_wins":
                System.out.println("X wins");
                break;
            case "O_wins":
                System.out.println("O wins");
                break;
            default:
                System.out.println("Draw");
                break;
        }
    }
}

