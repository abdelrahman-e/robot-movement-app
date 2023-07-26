@echo off
REM Start the robot service
cd robot
start mvnw spring-boot:run
cd ..
REM Start the frontend application
cd robot-ui
start npm start
cd ..
