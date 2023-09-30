package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class DriveAutoCommand extends Command {
    private final DriveSubsystem mDriveSubsystem;
    private double mDistance;

    private double mXSpeed;
    private double mZRotation;

    public DriveAutoCommand(DriveSubsystem driveSubsystem, double x, double z, double distance) {
        mDriveSubsystem = driveSubsystem;
        mDistance = distance;

        mXSpeed = x;
        mZRotation = z;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mDriveSubsystem.resetTachos();
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
        if (mDriveSubsystem.getCentimetreParcourus() > mDistance) {
            return true;
        }
        return false;
        // Commande infinie car la commande sera appellée avec un withTimeout()
        // donc elle sera interrompue à la fin du timeout
    }
}
