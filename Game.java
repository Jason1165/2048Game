import java.io.*;
import java.util.*;

public class Game {
  public static int[][] board = new int[4][4];

  public static void main(String[] args) {
    // Text.clear();
    // Text.hideCursor();
    // drawBorder();
    // Text.go(4, 6);
    // System.out.print(Text.colorize("4", Text.WHITE));
    // Text.go(4, 15);
    // System.out.print(Text.colorize("512", Text.WHITE));
    // Text.go(27, 1);
    // Text.showCursor();
    // printBoardArray();
    for (int i = 0; i < 16; i++) {
      addToBoard();
    }
    printBoardArray();
    right();
    printBoardArray();
    up();
    printBoardArray();
  }

  public static void drawBorder() {
    Text.clear();
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*6);
      DrawScreen.drawHorizontal(x ,1, 41);
    }
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*10);
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

  public static void addToBoard() {
    boolean filled = false;
    while (!filled) {
      int x = (int)(Math.random()*4);
      int y = (int)(Math.random()*4);
      int z = (int)(Math.random()*8);
      if (board[x][y] == 0) {
        board[x][y] = 2;
        if (z == 0) board[x][y] = 4;
        filled = true;
      }
    }
  }

  public static void down() {
    for (int col = 0; col <= 3; col++) {
      for (int row = 3; row > 0; row--) {
        if (board[row][col] == board[row-1][col]) {
          board[row][col] = 2*(board[row][col]);
          board[row-1][col] = 0;
        }
        shiftDown(col);
      }
    }
  }

  public static void shiftDown(int col) {
    for (int i = 3; i > 0; i--) {
      if (board[i][col] == 0) {
        board[i][col] = board[i-1][col];
        board[i-1][col] = 0;
      }
    }
  }

  public static void up() {
    for (int col = 0; col <= 3; col++) {
      for (int row = 0; row < 3; row++) {
        if (board[row][col] == board[row+1][col]) {
          board[row][col] = 2*(board[row][col]);
          board[row+1][col] = 0;
        }
      }
      shiftUp(col);
    }
  }

  public static void shiftUp(int col) {
    for (int x = 0; x < 4; x++) {
      for (int i = 0; i < 3; i++) {
        if (board[i][col] == 0) {
          board[i][col] = board[i+1][col];
          board[i+1][col] = 0;
        }
      }
    }
  }

  public static void right() {
    for (int row = 0; row <= 3; row++) {
      for (int col = 3; col > 0; col--) {
        if (board[row][col] == board[row][col-1]) {
          board[row][col] = 2*(board[row][col]);
          board[row][col-1] = 0;
        }
        shiftRight(row);
      }
    }
  }

  public static void shiftRight(int row) {
    for (int i = 3; i > 0; i--) {
      if (board[row][i] == 0) {
        board[row][i] = board[row][i-1];
        board[row][i-1] = 0;
      }
    }
  }


  public static void printBoardArray() {
    String s = "";
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        s += board[i][j] + " ";
      }
      s += "\n";
    }
    System.out.println(s);
  }


}
