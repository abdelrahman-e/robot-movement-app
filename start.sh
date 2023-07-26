#!/bin/sh

cd robot
# Start the GeneratorService SpringBoot application
./mvnw spring-boot:run &
# Capture the process ID of the GeneratorService application
ROBOT_PID=$!
cd ..


# Wait for 5 seconds before starting the frontend application
sleep 5

cd robot-ui
# Start the frontend React Next.js application
npm start &
cd ..

# Set up a trap to kill all processes when the script is closed
trap "kill ROBOT_PID ; npx kill-port 8080" SIGINT SIGTERM



# Wait for all processes to exit
wait $GENERATOR_PID
