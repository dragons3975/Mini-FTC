package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroupRED;
import ev3.robot.commandGroups.AutonomousCommandGroupGREEN;
import ev3.robot.commandGroups.AutonomousCommandGroupBLUE;


import lejos.robotics.Color;

import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.ColorSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.GripperSubsystem;
import ev3.robot.subsystems.WristSubsystem;

import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.BrasBackwardCommand;
import ev3.robot.commands.BrasForwardCommand;
import ev3.robot.commands.GripperCloseCommand;
import ev3.robot.commands.GripperOpenCommand;
import ev3.robot.commands.WristLeftCommand;
import ev3.robot.commands.WristRightCommand;






public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final ColorSubsystem mColorSubsystem = new ColorSubsystem();
    private final WristSubsystem mWristSubsystem = new WristSubsystem();
    private final GripperSubsystem mGripperSubsystem = new GripperSubsystem();

    private final BrasForwardCommand mBrasForwardCommand = new BrasForwardCommand(mBrasSubsystem);
    private final BrasBackwardCommand mBrasBackwardCommand = new BrasBackwardCommand(mBrasSubsystem);

    private final WristLeftCommand mWristLeftCommand = new WristLeftCommand(mWristSubsystem);
    private final WristRightCommand mWristRightCommand = new WristRightCommand(mWristSubsystem);
    
    private final GripperOpenCommand mGripperOpenCommand = new GripperOpenCommand(mGripperSubsystem);
    private final GripperCloseCommand mGripperCloseCommand = new GripperCloseCommand(mGripperSubsystem);

    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);

    private final AutonomousCommandGroupRED mAutonomousCommandGroupRED;
    private final AutonomousCommandGroupBLUE mAutonomousCommandGroupBLUE;
    private final AutonomousCommandGroupGREEN mAutonomousCommandGroupGREEN;

    public RobotContainer() {

        mAutonomousCommandGroupRED = new AutonomousCommandGroupRED(mDriveSubsystem);
        mAutonomousCommandGroupBLUE = new AutonomousCommandGroupBLUE(mDriveSubsystem);
        mAutonomousCommandGroupGREEN = new AutonomousCommandGroupGREEN(mDriveSubsystem);

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kA.value);
        buttonA.whileTrue(mWristLeftCommand);

        JoystickButton buttonB = new JoystickButton(mXboxController, Button.kB.value);
        buttonB.whileTrue(mWristRightCommand);

        JoystickButton buttonX = new JoystickButton(mXboxController, Button.kX.value);
        buttonX.whileTrue(mGripperOpenCommand);

        JoystickButton buttonY = new JoystickButton(mXboxController, Button.kY.value);
        buttonY.whileTrue(mGripperCloseCommand);
        
    

    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        if (mColorSubsystem.GetColorID() == Color.RED){
            return mAutonomousCommandGroupRED;

        } else if (mColorSubsystem.GetColorID() == Color.GREEN) {
            return mAutonomousCommandGroupGREEN;
        } else if (mColorSubsystem.GetColorID() == Color.BLUE) {
            return mAutonomousCommandGroupBLUE;
        }
        return null;
        
    }
}
