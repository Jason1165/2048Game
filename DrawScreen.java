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

  }

  public static void draw32(int xcor, int ycor) {

  }

  public static void draw64(int xcor, int ycor) {

  }

  public static void draw128(int xcor, int ycor) {

  }

  public static void draw256(int xcor, int ycor) {

  }

  public static void draw512(int xcor, int ycor) {

  }

  public static void draw1024(int xcor, int ycor) {

  }

  public static void draw2048(int xcor, int ycor) {

  }

  public static void draw4096(int xcor, int ycor) {

  }

}
