package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;


public class TournerGaucheCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private int m_zRotation;
    private int Parcourue; 
    private int Parcourir;
    private int gyroInitial; 
    private int gyroFinished;

    public TournerGaucheCommand(DriveSubsystem driveSubsystem, int z, int angle) {
        mDriveSubsystem = driveSubsystem;
        Parcourir = angle;
        
        m_zRotation = z;
        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        gyroInitial = mDriveSubsystem.getAngleGyro();
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Parcourue = mDriveSubsystem.getAngleGyro();
        mDriveSubsystem.arcadeDrive(0, -m_zRotation);
    

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
        

        return Parcourue >= gyroInitial + Parcourir;
    }
}
