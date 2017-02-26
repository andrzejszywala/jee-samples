package pl.andrzejszywala.samples.patterns.builder.maze;

public class StandardMazeBuilder extends MazeBuilder {
	
	private Maze currentMaze;
	
	private Direction commonWal(Room room1, Room room2) {
		return null;
	}
	
	@Override
	public void buildMaze() {
		currentMaze = new Maze();
	}
	
	public Maze getMaze() {
		return currentMaze;
	}
	
	@Override
	public void buildRoom(int roomNo) {
		if (currentMaze.roomNo(roomNo) == null) {
			Room room = new Room(roomNo);
			currentMaze.addRoom(room);
			room.setSide(Direction.North, new Wall());
			room.setSide(Direction.South, new Wall());
			room.setSide(Direction.East, new Wall());
			room.setSide(Direction.West, new Wall());
		}
	}
	
	@Override
	public void buildDor(int roomFrom, int roomTo) {
		Room r1 = currentMaze.roomNo(roomFrom);
		Room r2 = currentMaze.roomNo(roomTo);
		Door door = new Door(r1, r2);
		r1.setSide(commonWal(r1, r2), door);
		r2.setSide(commonWal(r2, r1), door);
	}
}
