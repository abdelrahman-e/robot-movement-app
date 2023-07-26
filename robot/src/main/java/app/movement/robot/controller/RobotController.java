package app.movement.robot.controller;

import app.movement.robot.dto.Robot;
import app.movement.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/robot")
public class RobotController {
    Logger logger = Logger.getLogger(RobotController.class.getName());
    private final RobotService robotService;

    @Autowired
    RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/move")
    public ResponseEntity<Robot> getGeneratedToken(@RequestBody String movementSteps) {

        Robot robot = robotService.moveAndRetrieveRobot(movementSteps);
        if (robot == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An error occurred while moving robot");
        }
        return ResponseEntity.status(HttpStatus.OK).body(robot);
    }
}
