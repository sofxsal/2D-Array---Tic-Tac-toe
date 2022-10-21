import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = {
              {'_', '_', '_'},
              {'_', '_', '_'},
              {'_', '_', '_'}
            };

            printBoard(board);

              for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                  System.out.println("Turn: X");
                  
                  // Use that return value to index the board and populate it
                  // create a new variable to store that return value from askUser method
                  int[] spot = askUser(board);
                  board[spot[0]][spot[1]] = 'X';
                  printBoard(board);
                } else {
                  System.out.println("Turn: O");
                  int[] spot = askUser(board);
                  board[spot[0]][spot[1]] = 'O';
                  printBoard(board);
                }

                int count = checkWin(board);
                if (count == 3) {
                  System.out.println("X wins!!");
                  break;
                } else if (count == -3) {
                  System.out.println("O wins!!");
                  break;
                }

              }



            scan.close();
        }
    public static void printBoard(char[][] board) {
      System.out.print("\n");
      for (int i = 0; i < board.length; i++) {
        System.out.print("\t");
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println("\n\n");
      } 
    }
     

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

     public static int[] askUser(char[][] board) {
      System.out.print("- pick a row and column number: ");
      int row = scan.nextInt();
      int column = scan.nextInt();

      while (board[row][column] == 'X' || board[row][column] == 'O') {
        System.out.println("Spot taken! Try again");
        row = scan.nextInt();
        column = scan.nextInt();
      }
      return new int[] {row, column};
     }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */

     // win scenario:
      // every row (part 1)
      // every column (part 2)
      //every left diagonal
      //every right diagonal

      public static int checkWin(char[][] board) {
        int count = 0;
        
        //Part 1: going through every row and every element in each row
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j <board[i].length; j++) {
            if (board[i][j] == 'X') {
              count++;
            } else if (board[i][j] == 'O') {
              count--;
            }
          }
          //check the count if 3 or -3 for the every row
          if (count == 3 || count == -3) {
            return count;
          } else {
            count = 0; // reset to 0
          }
        }

        //Part 2: going through every column
        //00, 10, 20
        //01, 11, 21

        for (int j = 0; j < board.length; j++) {
          for (int i = 0; i < 3; i++) {
            // when j = 0, i = 0
            // when j = 0, i = 1
            // when j = 0, i = 2
            if (board[i][j] == 'X') {
              count++;
            } else if (board[i][j] == 'O') {
              count--;
            }
          }

          if (count == 3 || count == -3) {
            return count;
          } else {
            count = 0; // reset to 0
          }


        }


        return count;
        
      }

}
