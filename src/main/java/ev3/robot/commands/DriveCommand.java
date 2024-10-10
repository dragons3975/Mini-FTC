package ev3.robot.commands;

import dragons.ev3.Ev3TouchSensor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;
    private final XboxController mXboxController;

    public DriveCommand(DriveSubsystem driveSubsystem, XboxController xboxController) {
        mDriveSubsystem = driveSubsystem;
        mXboxController = xboxController;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mDriveSubsystem.mecanumDrive(-mXboxController.getLeftY(), mXboxController.getLeftX(), mXboxController.getRightX());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mDriveSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
