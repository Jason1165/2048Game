import java.io.*;
import java.util.*;

public class Game {
  public static int[][] board = new int[4][4];

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Text.hideCursor();
    Text.clear();
    Text.go(1,1);

    Scanner in = new Scanner(System.in);
    String input = "";
    boolean moved = true;
    addToBoard();
    while( !(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) && movesLeft()) {
      if (moved) addToBoard();
      drawBoard();
      Text.go(26, 1);
      System.out.print(Text.colorize("Enter q or quit to end the game.", Text.WHITE));
      Text.go(27, 1);
      System.out.print(Text.colorize("Enter W, A, S, and D to moved up, left, down and right.", Text.WHITE));
      Text.go(28, 1);
      if (input.equals("s")) moved = down();
      Text.showCursor();
      input = in.nextLine();
    }
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

  public static void drawBoard() {
    Text.clear();
    drawBorder();
    Text.hideCursor();
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        if (board[row][col] == 0) DrawScreen.drawBlank(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 2) DrawScreen.draw2(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 4) DrawScreen.draw4(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 8) DrawScreen.draw8(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 16) DrawScreen.draw16(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 32) DrawScreen.draw32(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 64) DrawScreen.draw64(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 128) DrawScreen.draw128(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 256) DrawScreen.draw256(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 512) DrawScreen.draw512(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 1024) DrawScreen.draw1024(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 2048) DrawScreen.draw2048(row*6 + 2, col*10 + 2);
        else if (board[row][col] == 4096) DrawScreen.draw4096(row*6 + 2, col*10 + 2);
      }
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

  public static boolean down() {
    boolean merged = false;
    boolean shifted = false;
    for (int col = 0; col <= 3; col++) {
      for (int row = 3; row > 0; row--) {
        if (board[row][col] == board[row-1][col] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          board[row-1][col] = 0;
          merged = true;
        }
        shifted = shiftDown(col);
      }
    }
    return (merged || shifted);
  }

  public static boolean shiftDown(int col) {
    boolean shift = false;
    for (int i = 3; i > 0; i--) {
      if (board[i][col] == 0) {
        board[i][col] = board[i-1][col];
        board[i-1][col] = 0;
        shift = true;
      }
    }
    return shift;
  }

  public static boolean up() {
    boolean moved = false;
    for (int col = 0; col <= 3; col++) {
      for (int row = 0; row < 3; row++) {
        if (board[row][col] == board[row+1][col] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          board[row+1][col] = 0;
          moved = true;
        }
      }
      shiftUp(col);
    }
    return moved;
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

  public static boolean right() {
    boolean moved = false;
    for (int row = 0; row <= 3; row++) {
      for (int col = 3; col > 0; col--) {
        if (board[row][col] == board[row][col-1] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          board[row][col-1] = 0;
          moved = true;
        }
        shiftRight(row);
      }
    }
    return moved;
  }

  public static void shiftRight(int row) {
    for (int i = 3; i > 0; i--) {
      if (board[row][i] == 0) {
        board[row][i] = board[row][i-1];
        board[row][i-1] = 0;
      }
    }
  }

  public static boolean left() {
    boolean moved = false;
    for (int row = 0; row <= 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (board[row][col] == board[row][col+1] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          board[row][col+1] = 0;
          moved = true;
        }
      }
      shiftLeft(row);
    }
    return moved;
  }

  public static void shiftLeft(int row) {
    for (int x = 0; x < 4; x++) {
      for (int i = 0; i < 3; i++) {
        if (board[row][i] == 0) {
          board[row][i] = board[row][i+1];
          board[row][i+1] = 0;
        }
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
