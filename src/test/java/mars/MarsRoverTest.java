package mars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MarsRoverTest {

	private MarsRover rover;

	@Before
	public void setup() {
		rover = new MarsRover(0, 0, Direction.NORTH);
	}
	
	@Test
	public void roverShouldTakeInitialCoordinates() {
		assertEquals(true, rover.alive());
	}

	@Test
	public void roverShouldReceiveNullCommandsAndGoNowhere() {
		String[] commands = new String[10];

		assertEquals(false, rover.move(commands));
	}

	@Test
	public void roverShouldReceiveEmptyCommandsAndGoNowhere() {
		String[] commands = new String[10];
		commands[0] = "";

		assertEquals(false, rover.move(commands));
	}

	@Test
	public void roverShouldReceiveOneCommandAndReportItMoved() {
		String[] commands = new String[10];
		commands[0] = "N";

		assertEquals(true, rover.move(commands));
	}
	
	@Test @Ignore
	public void roverShouldTurnLeftAndReportSuccess() {
		
	}

}
