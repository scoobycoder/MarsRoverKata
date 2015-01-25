package mars;

public class DirectionFinder {

	private Direction direction;

	public DirectionFinder(Direction directionPointed) {
		this.direction = directionPointed;
	}

	public int[] coordinateChange() {
		int[] coordinates = new int[2];

		if (north())
			moveNorth(coordinates);
		else if (south())
			moveSouth(coordinates);
		else if (east())
			moveEast(coordinates);
		else
			moveWest(coordinates);

		return coordinates;
	}

	private void moveWest(int[] coordinates) {
		coordinates[0] = -1;
		coordinates[1] = 0;
	}

	private void moveEast(int[] coordinates) {
		coordinates[0] = 1;
		coordinates[1] = 0;
	}

	private void moveSouth(int[] coordinates) {
		coordinates[0] = 0;
		coordinates[1] = -1;
	}

	private void moveNorth(int[] coordinates) {
		coordinates[0] = 0;
		coordinates[1] = 1;
	}

	private boolean east() {
		return direction.equals(Direction.EAST);
	}

	private boolean north() {
		return direction.equals(Direction.NORTH);
	}

	private boolean south() {
		return direction.equals(Direction.SOUTH);
	}

}
