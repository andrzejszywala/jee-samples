package pl.andrzejszywala.samples.patterns.builder.maze;

public class MazeGame {

	public Maze createMaze(MazeBuilder builder) {
		builder.buildMaze();
		builder.buildRoom(1);
		builder.buildRoom(2);
		builder.buildDor(1, 2);
		return builder.getMaze();
	}
}
