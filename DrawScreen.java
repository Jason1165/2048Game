public class DrawScreen {
  public static void main(String[] args) {

  }

  public static void drawHorizontal(int xcor, int ycor, int length){
    Text.hideCursor();
    Text.go(xcor, ycor);
    for (int i = 0; i < length; i++) {
      System.out.print(Text.colorize(" ", Text.WHITE+Text.BACKGROUND));
    }
  }

  public static void drawVertical(int xcor, int ycor, int length) {
    Text.hideCursor();
    Text.go(xcor, ycor);
    for (int i = 0; i < length; i++) {
      Text.go(xcor+i, ycor);
      System.out.print(Text.colorize(" ", Text.WHITE+Text.BACKGROUND));
    }
  }
}
