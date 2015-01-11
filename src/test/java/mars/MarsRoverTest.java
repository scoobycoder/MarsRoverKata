package mars;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void roverShouldTakeInitialCoordinates() {
		MarsRover rover = new MarsRover(0, 0, Direction.NORTH);

		assertEquals(true, rover.alive());
	}

	@Test
	public void roverShouldReceiveNullCommandsAndGoNowhere() {

		MarsRover rover = new MarsRover(0, 0, Direction.NORTH);
		String[] commands = new String[10];

		assertEquals(false, rover.move(commands));
	}

	@Test
	public void roverShouldReceiveEmptyCommandsAndGoNowhere() {
		MarsRover rover = new MarsRover(0, 0, Direction.NORTH);
		String[] commands = new String[10];
		commands[0] = "";

		assertEquals(false, rover.move(commands));
	}

	@Test
	public void roverShouldReceiveOneCommandAndReportItMoved() {
		MarsRover rover = new MarsRover(0, 0, Direction.NORTH);
		String[] commands = new String[10];
		commands[0] = "N";

		assertEquals(true, rover.move(commands));
	}

}
