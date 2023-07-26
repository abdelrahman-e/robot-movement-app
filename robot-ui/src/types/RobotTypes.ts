export type RobotDirection = 'NORTH' | 'EAST' | 'SOUTH' | 'WEST';

export const directionToIcon: Record<RobotDirection, string> = {
    NORTH: '⬆️',
    EAST: '➡️',
    SOUTH: '⬇️',
    WEST: '⬅️',
};

export type Robot = {
    x: number;
    y: number;
    direction: RobotDirection;
}