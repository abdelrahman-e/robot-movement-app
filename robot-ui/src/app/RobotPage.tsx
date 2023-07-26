'use client';

import {useState, FormEvent, ChangeEvent} from 'react';
import {Avatar, Grid, TextField, Button, Box} from '@mui/material';
import {directionToIcon, Robot, RobotDirection} from "@/types/RobotTypes";
import {moveAndRetrieveRobot} from "@/api/RobotMovementApi";


export default function RobotPage() {
    const [positionState, setPositionState] = useState({x: 0, y: 0});
    const [directionState, setDirection] = useState<RobotDirection>("EAST");
    const [movementScriptState, setMovementScriptState] = useState('');

    const handleSubmit = async () => {
        let movementScript = "";
        //Adds position to script if it doesn't exist
        if (!movementScriptState.includes("POSITION")) {
            movementScript = "POSITION " + positionState.x + " " + positionState.y + " " + directionState + " \n";
        }
        movementScript += movementScriptState;

        const robot = await moveAndRetrieveRobot(movementScript);
        const position = {x: robot.x, y: robot.y};
        setPositionState(position);
        setDirection(robot.direction);
    };

    const handleChange = (event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        setMovementScriptState(event.target.value);
    };

    return (
        <Box>
            <Grid
                container
                sx={{
                    width: '250px',
                    height: '250px',
                }}
            >
                {[...Array(5)].map((_, y) => (
                    <Grid item container key={y}>
                        {[...Array(5)].map((_, x) => (
                            <Grid
                                item
                                key={x}
                                sx={{
                                    width: '50px',
                                    height: '50px',
                                    border: '1px solid black',
                                }}
                            >
                                {positionState.x === x && positionState.y === y && (
                                    <>
                                        <Avatar>{directionToIcon[directionState]}</Avatar>
                                    </>
                                )}
                            </Grid>
                        ))}
                    </Grid>
                ))}
            </Grid>
            <br/>
            <TextField
                label="Movement Script"
                value={movementScriptState}
                onChange={handleChange}
                required
                multiline
            />
            <Button onClick={handleSubmit}>Submit</Button>
        </Box>
    );
}
