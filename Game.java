import java.io.*;
import java.util.*;

public class Game {
  public static int[][] board = new int[4][4];
  public static int score = 0;
  public static final int STARTX = 3;
  public static final int STARTY = 3;

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Text.hideCursor();
    Text.clear();
    Text.go(1 + STARTX, 1 + STARTY);

    Scanner in = new Scanner(System.in);
    String input = "";
    boolean moved = true;
    addToBoard();
    while( !(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) && movesLeft()) {
      moved = false;
      if (input.equalsIgnoreCase("s")) moved = down();
      if (input.equalsIgnoreCase("w")) moved = up();
      if (input.equalsIgnoreCase("a")) moved = left();
      if (input.equalsIgnoreCase("d")) moved = right();
      if (moved) addToBoard();
      drawBoard();
      Text.go(26 + STARTX, 1 + STARTY);
      System.out.println(Text.colorize("Current Score: " + score + "\n", Text.WHITE, Text.BOLD));
      Text.go(28 + STARTX, 1 + STARTY);
      System.out.print(Text.colorize("Enter q or quit to end the game.", Text.WHITE));
      Text.go(29 + STARTX, 1 + STARTY);
      System.out.print(Text.colorize("Enter W, A, S, and D to moved up, left, down and right.", Text.WHITE));
      Text.go(30 + STARTX, 1 + STARTY);
      Text.showCursor();
      input = in.nextLine();
    }
  }

  public static void drawBorder() {
    Text.clear();
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*6);
      DrawScreen.drawHorizontal(x + STARTX ,1 + STARTY , 41);
    }
    for (int i = 0; i < 5; i++) {
      int x = 1 + (i*10);
      DrawScreen.drawVertical(1 + STARTX, x + STARTY, 25);
    }
  }

  public static void drawTitle() {
    Text.go(2, 8);
    System.out.print(Text.colorize("The Terminal Version of 2048 Game", Text.WHITE, Text.BOLD));
  }

  public static void drawBoard() {
    Text.clear();
    drawBorder();
    drawTitle();
    Text.hideCursor();
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        if (board[row][col] == 0) DrawScreen.drawBlank(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 2) DrawScreen.draw2(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 4) DrawScreen.draw4(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 8) DrawScreen.draw8(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 16) DrawScreen.draw16(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 32) DrawScreen.draw32(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 64) DrawScreen.draw64(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 128) DrawScreen.draw128(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 256) DrawScreen.draw256(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 512) DrawScreen.draw512(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 1024) DrawScreen.draw1024(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 2048) DrawScreen.draw2048(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
        else if (board[row][col] == 4096) DrawScreen.draw4096(row*6 + 2 + STARTX, col*10 + 2 + STARTY);
      }
    }
  }

  public static boolean movesLeft() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) return true;
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
      boolean temp = shiftDown(col);
      if (temp) shifted = true;
      for (int row = 3; row > 0; row--) {
        if (board[row][col] == board[row-1][col] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          score += board[row][col];
          board[row-1][col] = 0;
          merged = true;
        }
        temp = shiftDown(col);
        if (temp) shifted = true;
      }
    }
    return (merged || shifted);
  }

  public static boolean shiftDown(int col) {
    boolean shift = false;
    for (int y = 0; y < 4; y++) {
      for (int i = 3; i > 0; i--) {
        if (board[i][col] == 0 && board[i-1][col] != 0) {
          board[i][col] = board[i-1][col];
          board[i-1][col] = 0;
          shift = true;
        }
      }
    }
    return shift;
  }

  public static boolean up() {
    boolean merged = false;
    boolean shifted = false;
    for (int col = 0; col <= 3; col++) {
      boolean temp = shiftUp(col);
      if (temp) shifted = true;
      for (int row = 0; row < 3; row++) {
        if (board[row][col] == board[row+1][col] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          score += board[row][col];
          board[row+1][col] = 0;
          merged = true;
        }
      }
      temp = shiftUp(col);
      if (temp) shifted = true;
    }
    return (merged || shifted);
  }

  public static boolean shiftUp(int col) {
    boolean shift = false;
    for (int x = 0; x < 4; x++) {
      for (int i = 0; i < 3; i++) {
        if (board[i][col] == 0 && board[i+1][col] != 0) {
          board[i][col] = board[i+1][col];
          board[i+1][col] = 0;
          shift = true;
        }
      }
    }
    return shift;
  }

  public static boolean right() {
    boolean merged = false;
    boolean shifted = false;
    for (int row = 0; row <= 3; row++) {
      boolean temp = shiftRight(row);
      if (temp) shifted = true;
      for (int col = 3; col > 0; col--) {
        if (board[row][col] == board[row][col-1] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          score += board[row][col];
          board[row][col-1] = 0;
          merged = true;
        }
        temp = shiftRight(row);
        if (temp) shifted = true;
      }
    }
    return (merged || shifted);
  }

  public static boolean shiftRight(int row) {
    boolean shift = false;
    for (int y = 0; y < 4; y++) {
      for (int i = 3; i > 0; i--) {
        if (board[row][i] == 0 && board[row][i-1] != 0) {
          board[row][i] = board[row][i-1];
          board[row][i-1] = 0;
          shift = true;
        }
      }
    }
    return shift;
  }

  public static boolean left() {
    boolean merged = false;
    boolean shifted = false;
    for (int row = 0; row <= 3; row++) {
      boolean temp = shiftLeft(row);
      if (temp) shifted = true;
      for (int col = 0; col < 3; col++) {
        if (board[row][col] == board[row][col+1] && board[row][col] != 0) {
          board[row][col] = 2*(board[row][col]);
          score += board[row][col];
          board[row][col+1] = 0;
          merged = true;
        }
      }
      temp = shiftLeft(row);
      if (temp) shifted = true;
    }
    return (merged || shifted);
  }

  public static boolean shiftLeft(int row) {
    boolean shift = false;
    for (int x = 0; x < 4; x++) {
      for (int i = 0; i < 3; i++) {
        if (board[row][i] == 0 && board[row][i+1] != 0) {
          board[row][i] = board[row][i+1];
          board[row][i+1] = 0;
          shift = true;
        }
      }
    }
    return shift;
  }

}
