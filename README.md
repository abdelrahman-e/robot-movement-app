# robot-movement-app

## Assumptions and Info

* Added start.bat and start.sh to start the backend and frontend automatically
* Can also be started manually by navigating to robot directory and run `.\mvnw spring-boot:run` from Windows terminal,
  and
  navigating to robot-ui and `npm start`

### Backend

* POSITION must be sent in the script in the first line
* The robot won't move if the forward commands exceeds grid dimensions
* x is X axis so EAST and WEST movement, and y is Y axis, so North and South
* Directions and commands must be sent similar to the ENUMS, otherwise a 400 status code is returned

### Frontend

* if the position isn't sent, then it prepends it to the script to make it more convenient
