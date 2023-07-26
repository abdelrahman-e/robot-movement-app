package app.movement.robot.dto;

import app.movement.robot.enums.DirectionEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
    @Test
    void testGoForwardEast() {
        Robot robot = new Robot(0, 0, DirectionEnum.EAST);
        robot.goForward(1, 5, 5);
        assertAll(
                () -> assertEquals(1, robot.getX()),
                () -> assertEquals(0, robot.getY())
        );
    }

    @Test
    void testGoForwardEastExceedingBoundary() {
        Robot robot = new Robot(4, 0, DirectionEnum.EAST);
        robot.goForward(2, 5, 5);
        assertAll(
                () -> assertEquals(4, robot.getX()),
                () -> assertEquals(0, robot.getY())
        );
    }

    @Test
    void testGoForwardNorth() {
        Robot robot = new Robot(0, 1, DirectionEnum.NORTH);
        robot.goForward(1, 5, 5);
        assertAll(
                () -> assertEquals(0, robot.getX()),
                () -> assertEquals(0, robot.getY())
        );
    }

    @Test
    void testGoForwardNorthExceedingBoundary() {
        Robot robot = new Robot(0, 0, DirectionEnum.NORTH);
        robot.goForward(2, 5, 5);
        assertAll(
                () -> assertEquals(0, robot.getX()),
                () -> assertEquals(0, robot.getY())
        );
    }

    @Test
    void testGoForwardSouth() {
        Robot robot = new Robot(4, 3, DirectionEnum.SOUTH);
        robot.goForward(1, 5, 5);
        assertAll(
                () -> assertEquals(4, robot.getX()),
                () -> assertEquals(4, robot.getY())
        );
    }

    @Test
    void testGoForwardSouthExceedingBoundary() {
        Robot robot = new Robot(4, 4, DirectionEnum.SOUTH);
        robot.goForward(2, 5, 5);
        assertAll(
                () -> assertEquals(4, robot.getX()),
                () -> assertEquals(4, robot.getY())
        );
    }


    @Test
    void testGoForwardWest() {
        Robot robot = new Robot(4, 4, DirectionEnum.WEST);
        robot.goForward(1, 5, 5);
        assertAll(
                () -> assertEquals(3, robot.getX()),
                () -> assertEquals(4, robot.getY())
        );
    }

    @Test
    void testGoForwardWestExceedingBoundary() {
        Robot robot = new Robot(0, 4, DirectionEnum.WEST);
        robot.goForward(2, 5, 5);
        assertAll(
                () -> assertEquals(0, robot.getX()),
                () -> assertEquals(4, robot.getY())
        );
    }

    @Test
    void testTurnAroundFromEast() {
        Robot robot = new Robot(0, 0, DirectionEnum.EAST);
        robot.turnAround();
        assertEquals(DirectionEnum.WEST, robot.getDirection());
    }

    @Test
    void testTurnAroundFromSouth() {
        Robot robot = new Robot(0, 0, DirectionEnum.SOUTH);
        robot.turnAround();
        assertEquals(DirectionEnum.NORTH, robot.getDirection());
    }

    @Test
    void testTurnAroundFromWest() {
        Robot robot = new Robot(0, 0, DirectionEnum.WEST);
        robot.turnAround();
        assertEquals(DirectionEnum.EAST, robot.getDirection());
    }

    @Test
    void testTurnAroundFromNorth() {
        Robot robot = new Robot(0, 0, DirectionEnum.NORTH);
        robot.turnAround();
        assertEquals(DirectionEnum.SOUTH, robot.getDirection());
    }

    @Test
    void testTurnRightFromEast() {
        Robot robot = new Robot(0, 0, DirectionEnum.EAST);
        robot.turnRight();
        assertEquals(DirectionEnum.SOUTH, robot.getDirection());
    }

    @Test
    void testTurnRightFromNorth() {
        Robot robot = new Robot(0, 0, DirectionEnum.NORTH);
        robot.turnRight();
        assertEquals(DirectionEnum.EAST, robot.getDirection());
    }

    @Test
    void testTurnRightFromSouth() {
        Robot robot = new Robot(0, 0, DirectionEnum.SOUTH);
        robot.turnRight();
        assertEquals(DirectionEnum.WEST, robot.getDirection());
    }

    @Test
    void testTurnRightFromWest() {
        Robot robot = new Robot(0, 0, DirectionEnum.WEST);
        robot.turnRight();
        assertEquals(DirectionEnum.NORTH, robot.getDirection());
    }
}


