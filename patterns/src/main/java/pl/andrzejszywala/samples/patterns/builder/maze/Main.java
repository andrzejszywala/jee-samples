package pl.andrzejszywala.samples.patterns.builder.maze;

public class Main {

	public static void main(String[] args) {
		Maze maze;
		MazeGame game = new MazeGame();
		StandardMazeBuilder builder = new StandardMazeBuilder();
		game.createMaze(builder);
		maze = builder.getMaze();
		printMaze(maze);
	}

	private static void printMaze(Maze maze) {
		// TODO Auto-generated method stub
		
	}

}
