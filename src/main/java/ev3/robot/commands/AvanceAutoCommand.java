package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class AvanceAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private int mXSpeed;
    private double mConsigneDistanceCm;
    private double mDistanceInitiale;

    public AvanceAutoCommand(DriveSubsystem driveSubsystem, int x, double distance) {
        mDriveSubsystem = driveSubsystem;

        mXSpeed = x;
        mConsigneDistanceCm = distance;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mDistanceInitiale = mDriveSubsystem.getDistanceCm();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mDriveSubsystem.arcadeDrive(mXSpeed, 0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mDriveSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return mDriveSubsystem.getDistanceCm() >= mDistanceInitiale + mConsigneDistanceCm;
    }
}
