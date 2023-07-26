import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import userEvent from '@testing-library/user-event';
import { moveAndRetrieveRobotApi } from '../api/RobotMovementApi';
import { directionToIcon, Robot } from '@/types/RobotTypes';
import RobotPage from '../app/RobotPage';
import React from 'react';

jest.mock('../api/RobotMovementApi');

describe('TokenPage', () => {
  afterAll(() => {
    jest.clearAllMocks();
    jest.resetAllMocks();
  });

  it('should update robot position and direction', async () => {
    const mockRobotResponse = { x: 3, y: 1, direction: 'NORTH' } satisfies Robot;
    (moveAndRetrieveRobotApi as jest.Mock).mockResolvedValueOnce(mockRobotResponse);
    const renderedPage = render(<RobotPage />);
    const { getByTestId } = renderedPage;
    // Enter a movement script
    const movementScriptText = getByTestId('movementScriptText');
    await userEvent.type(movementScriptText, 'FORWARD 3');

    const movementScriptButton = getByTestId('movementScriptButton');
    await userEvent.click(movementScriptButton);

    expect(screen.getByText(directionToIcon.NORTH)).toBeInTheDocument();

    //checks to see that the position is similar to the testid
    expect(screen.getByTestId(mockRobotResponse.x + '.' + mockRobotResponse.y)).toBeInTheDocument();
  });
});
