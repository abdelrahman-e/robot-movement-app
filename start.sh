#!/bin/sh

cd robot
# Start the GeneratorService SpringBoot application
./mvnw spring-boot:run &
cd ..


# Wait for 5 seconds before starting the frontend application
sleep 5

cd robot-ui
# Start the frontend React Next.js application
npm start &
cd ..

# Set up a trap to kill all processes when the script is closed using npx
trap "npx kill-port 8080 3000" SIGINT SIGTERM

