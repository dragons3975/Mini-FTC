package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.OpenPinceCommand;
import ev3.robot.commands.ClosePinceCommand;
import ev3.robot.commands.LiftBrasCommand;
import ev3.robot.commands.LowerBrasCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.PinceSubsystem;
import ev3.robot.subsystems.DriveSubsystem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final PinceSubsystem mPinceSubsystem = new PinceSubsystem();
    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();

    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);

    private final OpenPinceCommand mOpenPinceCommand = new OpenPinceCommand(mPinceSubsystem);
    private final ClosePinceCommand mClosePinceCommand = new ClosePinceCommand(mPinceSubsystem);

    private final LiftBrasCommand mLiftBrasCommand = new LiftBrasCommand(mBrasSubsystem);
    private final LowerBrasCommand mLowerBrasCommand = new LowerBrasCommand(mBrasSubsystem);


    private final AutonomousCommandGroup mAutonomousCommandGroup;

    public RobotContainer() {

        mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kA.value);
        buttonA.onTrue(mOpenPinceCommand);
        JoystickButton buttonB = new JoystickButton(mXboxController, Button.kB.value);
        buttonB.onTrue(mClosePinceCommand);

        JoystickButton buttonUp = new JoystickButton(mXboxController, Button.kUp.value);
        buttonUp.whileTrue(mLiftBrasCommand);
        JoystickButton buttonDown = new JoystickButton(mXboxController, Button.kDown.value);
        buttonDown.whileTrue(mLowerBrasCommand);

    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        return mAutonomousCommandGroup;
    }

}
