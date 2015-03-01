package mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

	private Coordinates coordinates;
	private Direction direction;
	private Turner turner;

	public MarsRover(Coordinates startCoordinates, Direction startDirection, Turner turner) {
		coordinates = startCoordinates;
		direction = startDirection;
		this.turner = turner;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		for (RoverCommand command : commands)
			move(command);

		return coordinates;
	}

	private void move(RoverCommand command) {
		setDirection(command);
		moveDirection(command);
	}

	private void moveDirection(RoverCommand command) {
		if (forwardCommand(command))
			forwardMovement();
		else if (backwardCommand(command))
			backwardMovement();
	}

	private boolean backwardCommand(RoverCommand command) {
		return command == RoverCommand.BACKWARD;
	}

	private boolean forwardCommand(RoverCommand command) {
		return command == RoverCommand.FORWARD;
	}

	private void backwardMovement() {
		DirectionFinder directionFinder = new DirectionFinder(direction);
		Mover mover = new BackwardMover(directionFinder, coordinates);
		coordinates = mover.move(direction);
	}

	private void forwardMovement() {
		DirectionFinder directionFinder = new DirectionFinder(direction);
		Mover mover = new ForwardMover(directionFinder, coordinates);
		coordinates = mover.move(direction);
	}

	private void setDirection(RoverCommand command) {
		direction = turner.turn(command, direction);
	}

}
