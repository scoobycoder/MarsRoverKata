package mars;

public class RoverMover implements Mover {

	private Coordinates coordinates;
	
	public RoverMover(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public Coordinates moveForward(Direction startDirection) {
		if (north(startDirection)) {
			coordinates = createNewCoordinates(0, 1);
		} else if (west(startDirection)) {
			coordinates = createNewCoordinates(-1, 0);
		} else if (east(startDirection)) {
			coordinates = createNewCoordinates(1, 0);
		} else
			coordinates = createNewCoordinates(0, -1);
		return coordinates;
	}

	@Override
	public Coordinates moveBackward(Direction startDirection) {
		
		if (north(startDirection)) {
			coordinates = createNewCoordinates(0, -1);
		} else if (west(startDirection)) {
			coordinates = createNewCoordinates(1, 0);
		} else if (east(startDirection)) {
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
