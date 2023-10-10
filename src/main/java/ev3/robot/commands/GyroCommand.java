package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class GyroCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private double mDegreInitial;
    private final double mDegre;

    public GyroCommand(DriveSubsystem driveSubsystem, double degre) {
        mDriveSubsystem = driveSubsystem;
        mDegre = degre;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mDegreInitial = mDriveSubsystem.getDegre();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (mDegre > 0) {
            if (mDriveSubsystem.getDegre() >= (mDegreInitial + mDegre)) {
                mDriveSubsystem.arcadeDrive(0, 1);
            }
        }
        else {
            if (mDriveSubsystem.getDegre() <= (mDegreInitial + mDegre)) {
                mDriveSubsystem.arcadeDrive(0, -1);
            }
        }
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
