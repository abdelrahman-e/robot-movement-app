# robot-movement-app

## Develop a simple environment for a robot where you could control it using this predefined script:
POSITION 1 3 EAST //sets the initial position for the robot
<br/>
FORWARD 3 //lets the robot do 3 steps forward
<br/>
WAIT //lets the robot do nothing
<br/>
TURNAROUND //lets the robot turn around
<br/>
FORWARD 1 //lets the robot do 1 step forward
<br/>
RIGHT //lets the robot turn right
<br/>
FORWARD 2 //lets the robot do 2 steps forward
<br/>
<br/>
This script should be sent from frontend to backend as a single chunk using POST Method. After
script execution UI should render a new robot position on the grid and direction it looks to.
Please implement a movement/business logic using Java+Spring in backend. Frontend should be only
responsible for submitting the script and rendering robot on the grid.
For aesthetic reasons you should limit the grid in the Frontend for the robot to 5 x 5 steps. The initial
grid position is 0,0 and is in the top left corner.
It is optional, if the backend will be also aware of the grid limits.
Frontend should be styled. You could do it yourself or use some framework.

## Assumptions and Info

* Added start.bat and start.sh to start the backend and frontend automatically
* Can also be started manually by navigating to robot directory and run `.\mvnw spring-boot:run` from Windows terminal,
  and
  navigating to robot-ui and `npm start`

### Backend

* POSITION must be sent in the script in the first line, and it's assumed to be x y
* x is X axis so EAST and WEST movement, and y is Y axis, so North and South
* The robot won't move if the forward commands exceeds grid dimensions
* Directions and commands must be sent similar to the ENUMS, otherwise a 400 status code is returned

### Frontend

* if the position isn't sent, then it prepends it to the script to make it more convenient
