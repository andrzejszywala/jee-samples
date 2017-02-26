package pl.andrzejszywala.samples.patterns.builder.maze;

public class Room implements MapSide {

	private MapSide[] sides = new MapSide[4];
	private int roomNumber;
	
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	public MapSide getSide(Direction direction) {
		return sides[direction.ordinal()];
	}
	
	public void setSide(Direction direction, MapSide mapSide) {
		sides[direction.ordinal()] = mapSide;
	}

}
