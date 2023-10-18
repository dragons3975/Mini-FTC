package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class TourneAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private int mZRotation;
    private double mConsigneAngle;
    private double mAngleInitial;

    public TourneAutoCommand(DriveSubsystem driveSubsystem, int z, int angle) {
        mDriveSubsystem = driveSubsystem;

        mZRotation = z; 
        mConsigneAngle = angle;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mAngleInitial = mDriveSubsystem.getAngle();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mDriveSubsystem.arcadeDrive(0, mZRotation);
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
