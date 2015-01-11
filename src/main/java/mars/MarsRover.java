package mars;

import java.util.ArrayList;

public class MarsRover {

	private Coordinates coordinates;
	private Direction direction;

	public MarsRover(Coordinates startCoordinates, Direction startDirection) {
		coordinates = new Coordinates(0,0);
		direction = startDirection;
	}

	public boolean alive() {
		return true;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		 
		for (RoverCommand command : commands) {
			
			if (command == RoverCommand.LEFTTURN) {
				direction = Direction.WEST;
			}
			
			if (command == RoverCommand.FORWARD && direction.equals(Direction.NORTH)) {
				coordinates = new Coordinates(coordinates.getX(),coordinates.getY() + 1);
			}
			else if (command == RoverCommand.FORWARD && direction.equals(Direction.WEST)) {
				coordinates = new Coordinates(coordinates.getX() + 1,coordinates.getY());
			}
		}
		
		return coordinates;
	}
	
}
