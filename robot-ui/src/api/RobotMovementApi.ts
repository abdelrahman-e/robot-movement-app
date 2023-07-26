import {ROBOT_MOVEMENT_API_URI} from '@/constants/RobotConstants';
import {Robot} from "@/types/RobotTypes";

export const moveAndRetrieveRobotApi = async (movementScript: string): Promise<Robot> => {
    try {
        const response = await fetch(ROBOT_MOVEMENT_API_URI, {
            method: 'POST',
            body: movementScript
        });

        const robot: Robot = await response.json();
        if (!response.ok) {
            throw new Error(`An error occurred: ${response.status}` + robot);
        }
        return robot;
    } catch (err) {
        console.log(err);
        throw new Error(err as string);
    }
};
