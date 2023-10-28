package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commands.DriveCommand;
import ev3.robot.commands.ExtendCommand;
import ev3.robot.commands.PinceSatineFermeCommand;
import ev3.robot.commands.PinceSatineOuvreCommand;
import ev3.robot.commands.RetractCommand;
import ev3.robot.commands.BrasMonteCommand;
import ev3.robot.commands.BrasDescendCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.CouleurSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.ExtendSubsystem;
import ev3.robot.subsystems.PinceSatineSubsystem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final BrasMonteCommand mBrasMonteCommand = new BrasMonteCommand(mBrasSubsystem);
    private final BrasDescendCommand mBrasDescendCommand = new BrasDescendCommand(mBrasSubsystem);
    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final CouleurSubsystem mCouleurSubsystem = new CouleurSubsystem();
    private final PinceSatineSubsystem mPinceSatineSubsystem = new PinceSatineSubsystem();
    private final PinceSatineOuvreCommand mPinceSatineOuvreCommand = new PinceSatineOuvreCommand(mPinceSatineSubsystem);
    private final PinceSatineFermeCommand mPinceSatineFermeCommand = new PinceSatineFermeCommand(mPinceSatineSubsystem);
    private final AutonomousCommandGroup mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);
    private final ExtendSubsystem mExtendSubsystem = new ExtendSubsystem();
    private final ExtendCommand mExtendCommand = new ExtendCommand(mExtendSubsystem);
    private final RetractCommand mRetractCommand = new RetractCommand(mExtendSubsystem);

    public RobotContainer() {
        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXboxController, Button.kA.value);
        buttonA.whileTrue(mBrasMonteCommand);
        JoystickButton buttonB = new JoystickButton(mXboxController, Button.kB.value);
        buttonB.whileTrue(mBrasDescendCommand);

        JoystickButton leftbumper = new JoystickButton(mXboxController, Button.kLeftBumper.value); 
        leftbumper.whileTrue(mPinceSatineOuvreCommand);
        JoystickButton rightbumper = new JoystickButton(mXboxController, Button.kRightBumper.value);
        rightbumper.whileTrue(mPinceSatineFermeCommand);

        JoystickButton buttonX = new JoystickButton(mXboxController, Button.kX.value);
        buttonX.whileTrue(mExtendCommand);
        JoystickButton buttonY = new JoystickButton(mXboxController, Button.kY.value);
        buttonY.whileTrue(mRetractCommand);
        }   

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        return mAutonomousCommandGroup;
    }
}
