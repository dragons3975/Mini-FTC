package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class DriveAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private int mXSpeed;
    private int mZRotation;
    private double mConsigneDistanceCm;
    private double mDistanceInitiale;

    public DriveAutoCommand(DriveSubsystem driveSubsystem, int x, int z, double distance) {
        mDriveSubsystem = driveSubsystem;

        mXSpeed = x;
        mZRotation = z; 
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
        mDriveSubsystem.arcadeDrive(mXSpeed, mZRotation);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mDriveSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Commande infinie car la commande sera appellée avec un withTimeout()
        // donc elle sera interrompue à la fin du timeout
        return mDriveSubsystem.getDistanceCm() >= mDistanceInitiale + mConsigneDistanceCm;
    }
}
