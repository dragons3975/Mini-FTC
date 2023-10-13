package ev3.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ev3.robot.Constants.OIConstants;
import ev3.robot.commandGroups.AutonomousCommandGroup;
import ev3.robot.commandGroups.AutonomousCommandGroup2;
import ev3.robot.commandGroups.AutonomousCommandGroup3;
import ev3.robot.commands.BrasCommand;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.commands.DriveCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.CouleurSubsistem;

public class RobotContainer {

    private final XboxController mXboxController = new XboxController(OIConstants.kDriverControllerPort);

    private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
    private final BrasSubsystem mBrasSubsystem = new BrasSubsystem();
    private final BrasCommand mBrasCommandOuvre = new BrasCommand(mBrasSubsystem, true);
    private final BrasCommand mBrasCommandFerme = new BrasCommand(mBrasSubsystem, false);
    private final DriveCommand mDriveCommand = new DriveCommand(mDriveSubsystem, mXboxController);
    private final CouleurSubsistem mCouleurSubsistem = new CouleurSubsistem();

    private final AutonomousCommandGroup mAutonomousCommandGroup = new AutonomousCommandGroup(mDriveSubsystem);
    private final AutonomousCommandGroup2 mAutonomousCommandGroup2 = new AutonomousCommandGroup2(mDriveSubsystem);
    private final AutonomousCommandGroup3 mAutonomousCommandGroup3 = new AutonomousCommandGroup3(mDriveSubsystem);
    //private final DriveAutoCommand mDriveAutoCommand = new DriveAutoCommand(mDriveSubsystem, 1, 0, 100);

    public RobotContainer() {


        configureButtonBindings();
        configureDefaultCommands();
    }

    private void configureButtonBindings() {
        JoystickButton buttonX = new JoystickButton(mXboxController, Button.kX.value);
        buttonX.whileTrue(mBrasCommandOuvre);
        JoystickButton buttonY = new JoystickButton(mXboxController, Button.kY.value);
        buttonY.whileTrue(mBrasCommandFerme);
    }

    private void configureDefaultCommands() {
        mDriveSubsystem.setDefaultCommand(mDriveCommand);
    }

    public Command getAutonomousCommand() {
        if (mCouleurSubsistem.getColorID() == 5) {
            return mAutonomousCommandGroup;
        }
        else if (mCouleurSubsistem.getColorID() == 3) {
            return mAutonomousCommandGroup2;
        }
        else if (mCouleurSubsistem.getColorID() == 2) {
            return mAutonomousCommandGroup3;
        }
        else {
            return null;
        }
        
    }
}
