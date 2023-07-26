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
            case EAST -> {
                if (x + steps < gridWidth) {
                    x += steps;
                }
            }
            case WEST -> {
                if (x - steps >= 0) {
                    x -= steps;
                }
            }
            case NORTH -> {
                if (y - steps >= 0) {
                    y -= steps;
                }
            }
            case SOUTH -> {
                if (y + steps < gridHeight) {
                    y += steps;
                }
            }
        }
    }

    public void turnAround() {
        switch (direction) {
            case NORTH -> direction = DirectionEnum.SOUTH;
            case SOUTH -> direction = DirectionEnum.NORTH;
            case EAST -> direction = DirectionEnum.WEST;
            case WEST -> direction = DirectionEnum.EAST;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = DirectionEnum.EAST;
            case SOUTH -> direction = DirectionEnum.WEST;
            case EAST -> direction = DirectionEnum.SOUTH;
            case WEST -> direction = DirectionEnum.NORTH;
        }
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
