package app.movement.robot.dto;

import app.movement.robot.enums.DirectionEnum;

public class Robot {
    private int x;
    private int y;
    private DirectionEnum direction;

    public Robot(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void goForward(int steps, int gridWidth, int gridHeight) {
        switch (direction) {
            case EAST:
                if (x + steps < gridWidth) {
                    x += steps;
                }
                break;
            case WEST:
                if (x - steps >= 0) {
                    x -= steps;
                }
                break;
            case NORTH:
                if (y - steps >= 0) {
                    y -= steps;
                }
                break;
            case SOUTH:
                if (y + steps < gridHeight) {
                    y += steps;
                }
                break;
        }
    }

    public void turnAround() {
        switch (direction) {
            case NORTH:
                direction = DirectionEnum.SOUTH;
                break;
            case SOUTH:
                direction = DirectionEnum.NORTH;
                break;
            case EAST:
                direction = DirectionEnum.WEST;
                break;
            case WEST:
                direction = DirectionEnum.EAST;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH:
                direction = DirectionEnum.EAST;
                break;
            case SOUTH:
                direction = DirectionEnum.WEST;
                break;
            case EAST:
                direction = DirectionEnum.SOUTH;
                break;
            case WEST:
                direction = DirectionEnum.NORTH;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
