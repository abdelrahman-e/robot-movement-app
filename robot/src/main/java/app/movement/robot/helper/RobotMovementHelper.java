package app.movement.robot.helper;

public class RobotMovementHelper {

    public static boolean canMoveNorth(int y, int steps) {
        return y - steps >= 0;
    }

    public static boolean canMoveSouth(int y, int steps, int gridHeight) {
        return y + steps < gridHeight;
    }

    public static boolean canMoveEast(int x, int steps, int gridWidth) {
        return x + steps < gridWidth;
    }

    public static boolean canMoveWest(int x, int steps) {
        return x - steps >= 0;
    }
}
