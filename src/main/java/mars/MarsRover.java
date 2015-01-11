package mars;

import java.util.ArrayList;

public class MarsRover {

	private Coordinates coordinates;
	private Direction direction;

	public MarsRover(Coordinates startCoordinates, Direction startDirection) {
		coordinates = startCoordinates;
		direction = startDirection;
	}

	public boolean alive() {
		return true;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		 
		for (RoverCommand command : commands) {
			
			if (command == RoverCommand.LEFTTURN) {
				if (direction.equals(Direction.WEST)) {
					direction = Direction.SOUTH;
				} else {
					direction = Direction.WEST;
				}
			}
			else if (command == RoverCommand.RIGHTTURN) {
				if (direction.equals(Direction.EAST)) {
					direction = Direction.SOUTH;
				}
				else {
					direction = Direction.EAST;
				}
			}
			
			
			if (command == RoverCommand.FORWARD && direction.equals(Direction.NORTH)) {
				coordinates = new Coordinates(coordinates.getX(),coordinates.getY() + 1);
			}
			else if (command == RoverCommand.FORWARD && direction.equals(Direction.SOUTH)) {
				coordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
			}
			else if (command == RoverCommand.BACKWARD && direction.equals(Direction.NORTH)) {
				coordinates = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
			}
			else if (command == RoverCommand.BACKWARD && direction.equals(Direction.WEST)) {
				coordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY());
			}
			else if (command == RoverCommand.BACKWARD && direction.equals(Direction.EAST)) {
				coordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
			}
			else if (command == RoverCommand.FORWARD && direction.equals(Direction.WEST)) {
				coordinates = new Coordinates(coordinates.getX() - 1,coordinates.getY());
			}
			else if (command == RoverCommand.FORWARD && direction.equals(Direction.EAST)) {
				coordinates = new Coordinates(coordinates.getX() + 1,coordinates.getY());
			}
		}
		
		return coordinates;
	}
	
}
