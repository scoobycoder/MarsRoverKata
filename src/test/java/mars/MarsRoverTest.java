package mars;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MarsRoverTest {

	private static final String RIGHT = "right";
	private static final String LEFT = "left";
	private MarsRover rover;
	private ArrayList<RoverCommand> commands;

	private void newCoordinatesCorrect(Coordinates expectedCoordinates,
			Coordinates actualCoordinates) {
		assertEquals(expectedCoordinates.getX(), actualCoordinates.getX());
		assertEquals(expectedCoordinates.getY(), actualCoordinates.getY());
	}

	private void moveForward() {
		commands.add(RoverCommand.FORWARD);
	}

	private void moveBackwards() {
		commands.add(RoverCommand.BACKWARD);
	}

	private void turnLeft() {
		commands.add(RoverCommand.LEFTTURN);
	}

	private void turnRight() {
		commands.add(RoverCommand.RIGHTTURN);
	}
	
	private void turnTimes(String direction, int times) {
		for (int i = 0; i < times; i++) {
			if (direction.equals(RIGHT))
				turnRight();
			else
				turnLeft();
		}
	}

	@Before
	public void setup() {
		Coordinates startCoordinates = new Coordinates(0, 0);
		rover = new MarsRover(startCoordinates, Direction.NORTH);
		commands = new ArrayList<RoverCommand>();
	}

	@Test
	public void roverShouldReceiveOneCommand() {
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0, 1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftAndReportCoordinates() {
		turnLeft();
		Coordinates expectedCoordinates = new Coordinates(0, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftMoveForward() {
		turnLeft();
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(-1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnRightMoveForward() {
		turnRight();
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldMoveBack() {
		turnRight();
		turnRight();
		moveBackwards();
		Coordinates expectedCoordinates = new Coordinates(0, 1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}
	
	@Test
	public void roverShouldTurnRightTwiceAndMoveBack() {
		moveBackwards();
		Coordinates expectedCoordinates = new Coordinates(0, -1);
		
		Coordinates actualCoordinates = rover.move(commands);
		
		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftAndMoveBack() {
		turnLeft();
		moveBackwards();
		Coordinates expectedCoordinates = new Coordinates(1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnRightAndMoveBack() {
		turnRight();
		moveBackwards();
		Coordinates expectedCoordinates = new Coordinates(-1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnRightTwiceAndMoveForward() {
		turnTimes(RIGHT, 2);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0, -1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftTwiceAndMoveForward() {
		turnTimes(LEFT, 2);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0, -1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftThreeTimesAndMoveForward() {
		turnTimes(LEFT, 3);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnLeftFourTimesAndMoveForward() {
		turnTimes(LEFT, 4);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0, 1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnRightThreeTimesAndMoveForward() {
		turnTimes(RIGHT, 3);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(-1, 0);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void roverShouldTurnRightFourTimesAndMoveForward() {
		turnTimes(RIGHT, 4);
		moveForward();
		Coordinates expectedCoordinates = new Coordinates(0, 1);

		Coordinates actualCoordinates = rover.move(commands);

		newCoordinatesCorrect(expectedCoordinates, actualCoordinates);
	}

}
