package mars;

public class ForwardMover implements Mover {

	private DirectionFinder directionFinder;
	private Coordinates coordinates;

	public ForwardMover(DirectionFinder directionFinder, Coordinates coordinates) {
		this.directionFinder = directionFinder;
		this.coordinates = coordinates;
	}
	
	@Override
	public Coordinates move(Direction directionPointed) {
		int[] coordinates = directionFinder.coordinateChange();
		
		return createNewCoordinates(coordinates[0], coordinates[1]);
	}
	
	
	private Coordinates createNewCoordinates(int adjustX, int adjustY) {
		return new Coordinates(coordinates.getX() + adjustX, coordinates.getY()
				+ adjustY);
	}

}
