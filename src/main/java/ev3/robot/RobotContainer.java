package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.TelemetryBoolCommand;
import ev3.robot.commands.TelemetryStringCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.DriveSubsystem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final TelemetryBoolCommand mTelemetryBoolCommand = new TelemetryBoolCommand("X");
    private final TelemetryStringCommand mTelemetryStringCommand = new TelemetryStringCommand("Down", "yes", "no");

    private final AutonomousCommandGroup mAutonomousCommandGroup;

    public RobotContainer() {

        mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);

        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        //JoystickButton buttonX = new JoystickButton(mXboxController, Button.kA.value);
        //buttonX.whileTrue(mDriveCommand);
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kX.value);
        buttonA.whileTrue(mTelemetryBoolCommand);

        JoystickButton buttonDown = new JoystickButton(mXboxController, Button.kDown.value);
        buttonDown.whileTrue(mTelemetryStringCommand);
    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        return mAutonomousCommandGroup;
    }
}
