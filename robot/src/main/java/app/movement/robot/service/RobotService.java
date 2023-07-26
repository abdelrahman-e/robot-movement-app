package app.movement.robot.service;

import app.movement.robot.dto.Robot;
import app.movement.robot.enums.CommandEnum;
import app.movement.robot.enums.DirectionEnum;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.movement.robot.constants.RobotConstants.GRID_HEIGHT;
import static app.movement.robot.constants.RobotConstants.GRID_WIDTH;

@Service
public class RobotService {
    Logger logger = Logger.getLogger("RobotService");

    public Robot moveAndRetrieveRobot(String movementScript) {
        try (Scanner scanner = new Scanner(movementScript)) {
            String currentPositionCommand = scanner.next();

            if (!currentPositionCommand.equals("POSITION")) {
                logger.log(Level.WARNING, "Couldnt find initial position");
                return null;
            }
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            DirectionEnum direction = DirectionEnum.valueOf(scanner.next());

            Robot robot = new Robot(x, y, direction);

            while (scanner.hasNext()) {
                CommandEnum command = CommandEnum.valueOf(scanner.next());

                switch (command) {
                    case FORWARD:
                        int steps = scanner.nextInt();
                        robot.goForward(steps, GRID_WIDTH, GRID_HEIGHT);
                        break;
                    case TURNAROUND:
                        robot.turnAround();
                        break;
                    case RIGHT:
                        robot.turnRight();
                        break;
                    default:
                        break;
                }
            }
            return robot;
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            return null;
        }
    }

}
