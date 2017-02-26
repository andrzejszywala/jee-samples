package pl.andrzejszywala.samples.patterns.builder.maze;

public class Door implements MapSide {

	private Room room1;
	private Room room2;
	private boolean open;
	
	public Door(Room room1, Room room2) {
		this.room1 = room1;
		this.room2 = room2;
	}
	
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	public Room otherSideFrom(Room room) {
		return room == room1 ? room2 : room1;
	}
}
