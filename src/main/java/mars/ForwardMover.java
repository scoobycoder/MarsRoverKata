package mars;

public class ForwardMover implements Mover {

	private Coordinates coordinates;

	public ForwardMover(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public Coordinates move(Direction directionPointed) {
		
		if (north(directionPointed))
			coordinates = createNewCoordinates(0, 1);
		else if (south(directionPointed))
			coordinates = createNewCoordinates(0, -1);
		else if (east(directionPointed))
			coordinates = createNewCoordinates(1, 0);
		else
			coordinates = createNewCoordinates(-1, 0);
		return coordinates;
	}
	
	
	private Coordinates createNewCoordinates(int adjustX, int adjustY) {
		return new Coordinates(coordinates.getX() + adjustX, coordinates.getY()
				+ adjustY);
	}
	
	private boolean east(Direction direction) {
		return direction.equals(Direction.EAST);
	}

	private boolean north(Direction direction) {
		return direction.equals(Direction.NORTH);
	}

	private boolean south(Direction direction) {
		return direction.equals(Direction.SOUTH);
	}

}
