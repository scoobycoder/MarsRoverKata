package mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

	private Coordinates coordinates;
	private Direction direction;
	private Turner turner;
	private Mover mover;

	public MarsRover(Coordinates startCoordinates, Direction startDirection, Turner turner, Mover mover) {
		coordinates = startCoordinates;
		direction = startDirection;
		this.turner = turner;
		this.mover = mover;
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
		if (isForwardCommand(command))
			forwardMovement();
		else if (isBackwardCommand(command))
			backwardMovement();
	}

	private boolean isBackwardCommand(RoverCommand command) {
		return command == RoverCommand.BACKWARD;
	}

	private boolean isForwardCommand(RoverCommand command) {
		return command == RoverCommand.FORWARD;
	}

	private void backwardMovement() {
		coordinates = mover.moveBackward(direction);
	}

	private void forwardMovement() {
		coordinates = mover.moveForward(direction);
	}

	private void setDirection(RoverCommand command) {
		direction = turner.turn(command, direction);
	}

}
