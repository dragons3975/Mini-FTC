package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class RotateAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;
    private final Double m_degreeC;
    private int m_degreeinit;

    private final double mZRotation;

    public RotateAutoCommand(DriveSubsystem driveSubsystem, double z, double angle) {
        mDriveSubsystem = driveSubsystem;
        m_degreeC = angle;


        mZRotation = z;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_degreeinit = mDriveSubsystem.getAngle();

        mDriveSubsystem.arcadeDrive(0, mZRotation);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
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
        return mDriveSubsystem.getAngle() > m_degreeinit + m_degreeC;

    }
}
