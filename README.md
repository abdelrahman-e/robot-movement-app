# robot-movement-app

## Assumptions and Info

* POSITION must be sent in the script in the first line
* The robot won't move if the forward commands exceeds grid dimensions
* x is X axis so EAST and WEST movement, and y is Y axis, so North and South
* Directions and commands must be sent similar to the ENUMS, otherwise a 400 status code is returned