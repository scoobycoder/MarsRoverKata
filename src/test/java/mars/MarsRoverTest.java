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

	private void moveBackward() {
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
	
	private void moveForwardFourTimes() {
		moveForward();
		moveForward();
		moveForward();
		moveForward();
	}

	@Before
	public void setup() {
		Coordinates startCoordinates = new Coordinates(0, 0);
		Turner turner = new RoverTurner();
		Mover mover = new RoverMover(startCoordinates, new Globe(10, 10));
		rover = new MarsRover(startCoordinates, Direction.NORTH, turner, mover);
		commands = new ArrayList<RoverCommand>();
	}

	@Test
	public void roverShouldReceiveOneCommand() {
		moveForward();
		newCoordinatesCorrect(new Coordinates(0, 1), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftAndReportCoordinates() {
		turnLeft();
		newCoordinatesCorrect(new Coordinates(0, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftMoveForward() {
		turnLeft();
		moveForward();
		newCoordinatesCorrect(new Coordinates(-1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnRightMoveForward() {
		turnRight();
		moveForward();
		newCoordinatesCorrect(new Coordinates(1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldMoveBack() {
		turnRight();
		turnRight();
		moveBackward();
		newCoordinatesCorrect(new Coordinates(0, 1), rover.move(commands));
	}
	
	@Test
	public void roverShouldTurnRightTwiceAndMoveBack() {
		moveBackward();
		newCoordinatesCorrect(new Coordinates(0, -1), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftAndMoveBack() {
		turnLeft();
		moveBackward();
		newCoordinatesCorrect(new Coordinates(1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnRightAndMoveBack() {
		turnRight();
		moveBackward();
		newCoordinatesCorrect(new Coordinates(-1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnRightTwiceAndMoveForward() {
		turnTimes(RIGHT, 2);
		moveForward();
		newCoordinatesCorrect(new Coordinates(0, -1), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftTwiceAndMoveForward() {
		turnTimes(LEFT, 2);
		moveForward();
		newCoordinatesCorrect(new Coordinates(0, -1), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftThreeTimesAndMoveForward() {
		turnTimes(LEFT, 3);
		moveForward();
		newCoordinatesCorrect(new Coordinates(1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnLeftFourTimesAndMoveForward() {
		turnTimes(LEFT, 4);
		moveForward();
		newCoordinatesCorrect(new Coordinates(0, 1), rover.move(commands));
	}

	@Test
	public void roverShouldTurnRightThreeTimesAndMoveForward() {
		turnTimes(RIGHT, 3);
		moveForward();
		newCoordinatesCorrect(new Coordinates(-1, 0), rover.move(commands));
	}

	@Test
	public void roverShouldTurnRightFourTimesAndMoveForward() {
		turnTimes(RIGHT, 4);
		moveForward();
		newCoordinatesCorrect(new Coordinates(0, 1), rover.move(commands));
	}
	
	@Test
	public void roverShouldMoveForwardFourTimesTurnLeftAndMoveFourMoreTimes() {
		moveForwardFourTimes();
		turnLeft();
		moveForwardFourTimes();
		newCoordinatesCorrect(new Coordinates(-4, 4), rover.move(commands));
	}
		
	@Test
	public void roverStartPointingWestShouldMoveWestIfForwardCalled() {
		Turner turner = new RoverTurner();
		Coordinates startCoordinates = new Coordinates(0, 0);
		Mover mover = new RoverMover(startCoordinates, new Globe(5, 5));
		rover = new MarsRover(startCoordinates, Direction.WEST, turner, mover);
		
		moveForward();
		
		newCoordinatesCorrect(new Coordinates(-1, 0), rover.move(commands));
	}
	
	@Test
	public void roverShouldReturnToSamePointIfGlobeOneYDistance() {
		Turner turner = new RoverTurner();
		Coordinates startCoordinates = new Coordinates(0, 0);
		Mover mover = new RoverMover(startCoordinates, new Globe(1, 1));
		rover = new MarsRover(startCoordinates, Direction.NORTH, turner, mover);
		
		moveForward();
		moveForward();
		moveForward();
		
		newCoordinatesCorrect(new Coordinates(0, 1), rover.move(commands));
	}
	
	@Test
	public void roverShouldReturnToSamePointIfGlobeOneYDistanceMovingBackward() {
		Turner turner = new RoverTurner();
		Coordinates startCoordinates = new Coordinates(0, 0);
		Mover mover = new RoverMover(startCoordinates, new Globe(1, 1));
		rover = new MarsRover(startCoordinates, Direction.NORTH, turner, mover);
		
		moveBackward();
		moveBackward();
		moveBackward();
		
		newCoordinatesCorrect(new Coordinates(0, -1), rover.move(commands));
	}
	
	@Test
	public void roverShouldReturnToSamePointIfGlobeOneXDistanceMovingForward() {
		Turner turner = new RoverTurner();
		Coordinates startCoordinates = new Coordinates(0, 0);
		Mover mover = new RoverMover(startCoordinates, new Globe(1, 1));
		rover = new MarsRover(startCoordinates, Direction.NORTH, turner, mover);
		
		turnLeft();
		moveForward();
		moveForward();
		moveForward();
		
		newCoordinatesCorrect(new Coordinates(-1, 0), rover.move(commands));
	}
	
	@Test
	public void roverShouldReturnToSamePointIfGlobeOneXDistanceMovingBackward() {
		Turner turner = new RoverTurner();
		Coordinates startCoordinates = new Coordinates(0, 0);
		Mover mover = new RoverMover(startCoordinates, new Globe(1, 1));
		rover = new MarsRover(startCoordinates, Direction.NORTH, turner, mover);
		
		turnLeft();
		moveBackward();
		moveBackward();
		moveBackward();
		
		newCoordinatesCorrect(new Coordinates(1, 0), rover.move(commands));
	}
	
}
