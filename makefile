play: Game.class
	@java Game

Game.class:
	@javac Game.java

clean:
	@rm *.class
