package mars;

public class BackwardMover implements Mover {

	private Coordinates coordinates;

	public BackwardMover(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public Coordinates move(Direction directionPointed) {
		
		if (north(directionPointed)) {
			coordinates = createNewCoordinates(0, -1);
		} else if (west(directionPointed)) {
			coordinates = createNewCoordinates(1, 0);
		} else if (east(directionPointed)) {
			coordinates = createNewCoordinates(-1, 0);
		} else
			coordinates = createNewCoordinates(0, 1);
		
		return coordinates;
	}
	
	private Coordinates createNewCoordinates(int adjustX, int adjustY) {
		return new Coordinates(coordinates.getX() + adjustX, coordinates.getY()
				+ adjustY);
	}
	
	private boolean east(Direction direction) {
		return direction.equals(Direction.EAST);
	}

	private boolean west(Direction direction) {
		return direction.equals(Direction.WEST);
	}

	private boolean north(Direction direction) {
		return direction.equals(Direction.NORTH);
	}

}
