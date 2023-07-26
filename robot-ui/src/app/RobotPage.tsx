'use client';

import { useState } from 'react';
import { Avatar, Grid, TextField, Button, Box } from '@mui/material';
import { directionToIcon, RobotDirection } from '@/types/RobotTypes';
import { moveAndRetrieveRobotApi } from '@/api/RobotMovementApi';
import { GRID_HEIGHT, GRID_WIDTH } from '@/constants/RobotConstants';

export default function RobotPage() {
  const [positionState, setPositionState] = useState({ x: 0, y: 0 });
  const [directionState, setDirection] = useState<RobotDirection>('EAST');
  const [movementScriptState, setMovementScriptState] = useState('');

  const handleSubmit = async () => {
    let movementScript = '';

    if (!movementScriptState.includes('POSITION')) {
      movementScript = 'POSITION ' + positionState.x + ' ' + positionState.y + ' ' + directionState + ' \n';
    }
    movementScript += movementScriptState;

    const robot = await moveAndRetrieveRobotApi(movementScript);
    const position = { x: robot.x, y: robot.y };
    setPositionState(position);
    setDirection(robot.direction);
  };

  return (
    <Box>
      <Grid
        container
        sx={{
          width: '250px',
          height: '250px'
        }}
      >
        {[...Array(GRID_HEIGHT)].map((_, y) => (
          <Grid item container key={y}>
            {[...Array(GRID_WIDTH)].map((_, x) => (
              <Grid
                item
                key={x}
                sx={{
                  width: '50px',
                  height: '50px',
                  border: '1px solid black'
                }}
              >
                {positionState.x === x && positionState.y === y && (
                  <>
                    <Avatar data-testid={`${x}.${y}`}>{directionToIcon[directionState]}</Avatar>
                  </>
                )}
              </Grid>
            ))}
          </Grid>
        ))}
      </Grid>
      <br />
      <TextField
        label="Movement Script"
        value={movementScriptState}
        onChange={(event) => setMovementScriptState(event.target.value)}
        required
        multiline
        data-testid="movementScriptText"
      />
      <Button data-testid="movementScriptButton" onClick={handleSubmit}>
        Submit
      </Button>
    </Box>
  );
}
