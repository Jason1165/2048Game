public class DrawScreen {
  public static void main(String[] args) {

  }

  public static void drawHorizontal(int xcor, int ycor, int length){
    Text.hideCursor();
    Text.go(xcor, ycor);
    for (int i = 0; i < length; i++) {
      System.out.print(Text.colorizeBackground(" ", 185, 171, 158));
    }
  }

  public static void drawVertical(int xcor, int ycor, int length) {
    Text.hideCursor();
    Text.go(xcor, ycor);
    for (int i = 0; i < length; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground(" ", 185, 171, 158));
    }
  }

  public static void drawBlank(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 245, 245, 220 ));
    }
  }

  public static void draw2(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 203, 191, 179));
    }
    Text.go(xcor+2, ycor + 4);
    System.out.print(Text.colorizeBackground("2", 203, 191, 179, Text.BLACK, Text.BOLD));
  }

  public static void draw4(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 237, 224, 201));
    }
    Text.go(xcor+2, ycor + 4);
    System.out.print(Text.colorizeBackground("4", 237, 224, 201, Text.BLACK, Text.BOLD));
  }

  public static void draw8(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 244, 175, 120));
    }
    Text.go(xcor+2, ycor + 4);
    System.out.print(Text.colorizeBackground("8", 244, 175, 120, Text.BLACK, Text.BOLD));
  }

  public static void draw16(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 246, 150, 100));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("1", 246, 150, 100, Text.BLACK, Text.BOLD));
    Text.go(xcor+2, ycor + 5);
    System.out.print(Text.colorizeBackground("6", 246, 150, 100, Text.BLACK, Text.BOLD));
  }

  public static void draw32(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 247, 124, 95));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("3", 247, 124, 95, Text.BLACK, Text.BOLD));
    Text.go(xcor+2, ycor + 5);
    System.out.print(Text.colorizeBackground("2", 247, 124, 95, Text.BLACK, Text.BOLD));
  }

  public static void draw64(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 247, 95, 59));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("6", 247, 95, 59, Text.BLACK, Text.BOLD));
    Text.go(xcor+2, ycor + 5);
    System.out.print(Text.colorizeBackground("4", 247, 95, 59, Text.BLACK, Text.BOLD));
  }

  public static void draw128(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 237, 208, 115));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("128", 237, 208, 115, Text.BLACK, Text.BOLD));
  }

  public static void draw256(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 237, 204, 98));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("256", 237, 204, 98, Text.BLACK, Text.BOLD));
  }

  public static void draw512(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 237, 201, 80));
    }
    Text.go(xcor+2, ycor + 3);
    System.out.print(Text.colorizeBackground("512", 237, 201, 70, Text.BLACK, Text.BOLD));
  }

  public static void draw1024(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 230, 195, 86));
    }
    Text.go(xcor+1, ycor + 3);
    System.out.print(Text.colorizeBackground("1 0", 230, 195, 86, Text.BLACK, Text.BOLD));
    Text.go(xcor+3, ycor + 3);
    System.out.print(Text.colorizeBackground("2 4", 230, 195, 86, Text.BLACK, Text.BOLD));
  }

  public static void draw2048(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 232, 190, 78));
    }
    Text.go(xcor+1, ycor + 3);
    System.out.print(Text.colorizeBackground("2 0", 232, 190, 78, Text.BLACK, Text.BOLD));
    Text.go(xcor+3, ycor + 3);
    System.out.print(Text.colorizeBackground("4 8", 232, 190, 78, Text.BLACK, Text.BOLD));
  }

  public static void draw4096(int xcor, int ycor) {
    Text.go(xcor, ycor);
    for (int i = 0; i < 5; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorizeBackground("         ", 120, 161, 54));
    }
    Text.go(xcor+1, ycor + 3);
    System.out.print(Text.colorizeBackground("4 0", 120, 161, 54, Text.BLACK, Text.BOLD));
    Text.go(xcor+3, ycor + 3);
    System.out.print(Text.colorizeBackground("9 6", 120, 161, 54 Text.BLACK, Text.BOLD));
  }

}
