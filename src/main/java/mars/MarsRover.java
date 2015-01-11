package mars;

import java.util.ArrayList;

public class MarsRover {

	private Coordinates coordinates;

	public MarsRover(Coordinates startCoordinates, Direction north) {
		coordinates = new Coordinates(0,0);
	}

	public boolean alive() {
		return true;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		 
		for (RoverCommand command : commands) {
			if (command == RoverCommand.FORWARD) {
				coordinates = new Coordinates(0,coordinates.getY() + 1);
			}
		}
		
		return coordinates;
	}
	
}
