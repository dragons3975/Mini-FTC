package ev3.robot.commands;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class AvanceAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;
    private final Double m_distanceC;
    private Double mdistanceinit;

    private final double mXSpeed;

    public AvanceAutoCommand(DriveSubsystem driveSubsystem, double x, double distance) {
        mDriveSubsystem = driveSubsystem;
        m_distanceC = distance;


        mXSpeed = x;

        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mdistanceinit = mDriveSubsystem.distancecm();

        mDriveSubsystem.arcadeDrive(mXSpeed, 0);
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
        return mDriveSubsystem.distancecm() > mdistanceinit + m_distanceC;

    }
}
