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

     // win scenario:
      // every row (part 1)
      // every column (part 2)
      //every left diagonal (part 3)
      //every right diagonal

      public static int checkWin(char[][] board) {
        int count = 0;
        
        /*************************************************************************** */

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
        /**************************************************************************** */

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

        /****************************************************************************** */

        //part 3: left diagonal
        // 00, 11, 22
        //using the same index

        for (int i = 0; i < 3; i++) {

          // i = 0, 00
          // i = 1, 11
          // i = 2, 22
          // break the loop
          // verify the condition for count == 3
          if (board[i][i] == 'X') {
            count++; 
          } else if (board[i][i] == 'O') {
            count--;
          }
        }

        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0; // reset to 0
        }
        

        /************************************************************************** */

        //part 4: right diagonal


        return count;
      }

}
