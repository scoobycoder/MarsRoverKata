package mars;

public class RoverMover implements Mover {

	private Coordinates coordinates;
	private Globe globe;
	
	public RoverMover(Coordinates coordinates, Globe globe) {
		this.coordinates = coordinates;
		this.globe = globe;
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
		
		printCoordinates();
		
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
		
		printCoordinates();

		return coordinates;
	}
	
	private void printCoordinates() {
		System.out.println(coordinates.getX() + ", " + coordinates.getY());
	}
	
	private Coordinates createNewCoordinates(int adjustX, int adjustY) {
		if (isAtYBoundary())
			return new Coordinates(coordinates.getX(), 0);
		
		if (isAtXBoundary())
			return new Coordinates(0, coordinates.getY());
		
		return new Coordinates(coordinates.getX() + adjustX, coordinates.getY()
				+ adjustY);
	}

	private boolean isAtXBoundary() {
		return Math.abs(coordinates.getX()) == Math.abs(globe.getxMax());
	}

	private boolean isAtYBoundary() {
		return Math.abs(coordinates.getY()) == Math.abs(globe.getyMax());
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
