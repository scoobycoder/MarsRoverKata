package mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {

	private static final RoverCommand RIGHTTURN = RoverCommand.RIGHTTURN;
	private static final RoverCommand LEFTTURN = RoverCommand.LEFTTURN;
	private static final RoverCommand DETECTROCK = RoverCommand.DETECTROCK;
	private Coordinates coordinates;
	private Direction direction;
	private Turner turner;
	private Mover mover;
	private boolean rockDetected;

	public MarsRover(Coordinates startCoordinates, Direction startDirection,
			Turner turner, Mover mover) {
		coordinates = startCoordinates;
		direction = startDirection;
		this.turner = turner;
		this.mover = mover;
	}

	public Coordinates move(ArrayList<RoverCommand> commands) {
		rockDetected = false;
		for (RoverCommand command : commands) {
			checkForRocks(command);
			resetRockDetectedWhenTurning(command);
			if (noRocks())
				move(command);
		}
		return coordinates;
	}

	private boolean noRocks() {
		return rockDetected == false;
	}

	private void checkForRocks(RoverCommand command) {
		if (command == DETECTROCK)
			rockDetected = true;
	}

	private void resetRockDetectedWhenTurning(RoverCommand command) {
		if (isTurnCommand(command))
			rockDetected = false;
	}

	private boolean isTurnCommand(RoverCommand command) {
		return command == LEFTTURN || command == RIGHTTURN;
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
