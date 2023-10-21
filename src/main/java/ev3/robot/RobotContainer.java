package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commandGroups.LeftCommandGroup;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.RamasseCommand;
import ev3.robot.commands.TestBrasCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.ColorSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.RamasseurSubsystem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);
    private final RamasseurSubsystem mRamasseurSubsystem = new RamasseurSubsystem();
    private final RamasseCommand mRamasseCommand = new RamasseCommand(mRamasseurSubsystem);
    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final ColorSubsystem mColorSubsystem = new ColorSubsystem();

    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final TestBrasCommand mTestBrasCommand = new TestBrasCommand(mBrasSubsystem);
    
    private final LeftCommandGroup mLeftCommandGroup = new LeftCommandGroup(mDriveSubsystem);
    private final MiddleCommandGroup mMiddleCommandGroup = new MiddleCommandGroup();
    private final RightCommandGroup mRightCommandGroup = new RightCommandGroup();

    private final AutonomousCommandGroup mAutonomousCommandGroup;

    public RobotContainer() {

        mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kA.value);
        buttonA.onTrue(mTestBrasCommand);
        
        JoystickButton buttonY = new JoystickButton(mXboxController, Button.kY.value);
        buttonY.whileTrue(mRamasseCommand);
    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);

    }

    public Command getAutonomousCommand() {
        return mAutonomousCommandGroup;
    }
}
