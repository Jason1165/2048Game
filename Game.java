import java.io.*;
import java.util.*;

public class Game {
  public static int[][] board = new int[4][4];

  public static void main(String[] args) {
    for (int i = 0; i < 6; i++) {
      fill();
      printBoardArray();
    }
  }

  public static void drawBorder() {
    Text.clear();
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*6);
      DrawScreen.drawHorizontal(x ,1, 45);
    }
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*11);
      DrawScreen.drawVertical(1, x, 25);
    }
  }

  public static boolean movesLeft() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (j != board[i].length - 1) {
          if (board[i][j] == board[i][j+1]) return true;
        }
        if (i != board.length-1) {
          if (board[i][j] == board[i+1][j]) return true;
        }
      }
    }
    return false;
  }

  public static void fill() {
    boolean filled = false;
    while (!filled) {
      int x = (int)(Math.random()*4);
      int y = (int)(Math.random()*4);
      if (board[x][y] == 0) {
        board[x][y] = 2;
        filled = true;
      }
    }
  }

  public static void printBoardArray() {
    for (int i = 0; i < 4; i++) {
      System.out.print(Arrays.toString(board[i]) + " ");
    }
    System.out.println();
  }


}
