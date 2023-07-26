package app.movement.robot.service;

import app.movement.robot.dto.Robot;
import app.movement.robot.enums.DirectionEnum;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotServiceTest {

    RobotService robotService = new RobotService();

    @Test
    void testValidRobotMovement() {
        String movementScript = """
                POSITION 1 3 EAST
                FORWARD 3
                WAIT
                TURNAROUND
                FORWARD 1
                RIGHT
                FORWARD 2
                """;
        Robot result = robotService.moveAndRetrieveRobot(movementScript);
        assertAll(() -> assertEquals(3, result.getX()), () -> assertEquals(1, result.getY()));
    }

    @Test
    void testMissingPosition() {
        String movementScript = """
                1 3 EAST
                FORWARD 3
                WAIT
                TURNAROUND
                FORWARD 1
                RIGHT
                FORWARD 2
                """;
        Robot result = robotService.moveAndRetrieveRobot(movementScript);
        assertEquals(null, result);
    }

    @Test
    void testNoScript() {
        Robot result = robotService.moveAndRetrieveRobot("");
        assertEquals(null, result);
    }
}
