package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutoCommandg1;
import ev3.robot.commandGroups.AutoCommandg2;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commands.BrasTestCommand;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.TogglePinceCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.ColorSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.PinceSubsystem;
import lejos.robotics.Color;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final ColorSubsystem mColorSubsystem = new ColorSubsystem();
    private final PinceSubsystem mPinceSubsystem = new PinceSubsystem();
    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final BrasTestCommand mBrasTestCommand = new BrasTestCommand(mBrasSubsystem);
    private final TogglePinceCommand mTogglePinceCommand = new TogglePinceCommand(mPinceSubsystem);
    

    private final AutonomousCommandGroup mAutonomousCommandGroup;
    private final AutoCommandg1 mAutoCommandg1;
    private final AutoCommandg2 mAutoCommandg2;

    public RobotContainer() {

        mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kA.value);
        buttonA.onTrue(mBrasTestCommand);

        JoystickButton buttonB = new JoystickButton(mXboxController, Button.kB.value);
        buttonB.onTrue(mTogglePinceCommand);
        
    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        if (mColorSubsystem.getcolor() == Color.RED)
        {
            return mAutonomousCommandGroup;
        }
        if (mColorSubsystem.getcolor() == Color.BLUE)
        {
            return mAutoCommandg1;
        }
        if (mColorSubsystem.getcolor() == Color.GREEN)
        {
            return mAutoCommandg2;        
        }
        
        return null;
    }
}
