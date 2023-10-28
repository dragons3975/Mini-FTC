package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commandGroups.LeftCommandGroup;
import ev3.robot.commands.AvionCommand;
import ev3.robot.commands.BrasCommandBas;
import ev3.robot.commands.BrasCommandHaut;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.PinceCommandFerme;
import ev3.robot.commands.PinceCommandOuvre;
import ev3.robot.subsystems.AvionSubsystem;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.ColorSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.PinceSubsystem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);
    private final XboxController mXboxController2 = new XboxController(OIConstants.kDriverControllerPort2);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final ColorSubsystem mColorSubsystem = new ColorSubsystem();
    private final PinceSubsystem mPinceSubsystem = new PinceSubsystem();
    private final AvionSubsystem mAvionSubsystem = new AvionSubsystem();

    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final BrasCommandHaut mBrasCommandHaut = new BrasCommandHaut(mBrasSubsystem);
    private final BrasCommandBas mBrasCommandBas = new BrasCommandBas(mBrasSubsystem);
    
    private final PinceCommandOuvre mPinceCommandOuvre = new PinceCommandOuvre(mPinceSubsystem);
    private final PinceCommandFerme mPinceCommandFerme = new PinceCommandFerme(mPinceSubsystem);

    private final AvionCommand mAvionCommand = new AvionCommand(mAvionSubsystem);

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
        JoystickButton buttonA = new JoystickButton(mXboxController2, Button.kA.value);
        buttonA.whileTrue(mBrasCommandBas);

        JoystickButton buttonY = new JoystickButton(mXboxController2, Button.kY.value);
        buttonY.whileTrue(mBrasCommandHaut);

        JoystickButton buttonX = new JoystickButton(mXboxController2, Button.kX.value);
        buttonX.whileTrue(mPinceCommandOuvre);

        JoystickButton buttonB = new JoystickButton(mXboxController2, Button.kB.value);
        buttonB.whileTrue(mPinceCommandFerme);

        JoystickButton StartButton = new JoystickButton(mXboxController2, Button.kStart.value);
StartButton.whileTrue(mAvionCommand);
    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);

    }

    public Command getAutonomousCommand() {
        return mAutonomousCommandGroup;
    }
}
