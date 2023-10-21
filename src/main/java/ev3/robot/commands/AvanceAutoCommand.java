package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;


public class AvanceAutoCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;

    private int mXSpeed;
    private double Parcourue; 
    private double Parcourir;

    public AvanceAutoCommand(DriveSubsystem driveSubsystem, int x, double p_CM) {
        mDriveSubsystem = driveSubsystem;
        Parcourir = p_CM;
        
        mXSpeed = x;
        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Parcourue = mDriveSubsystem.getDistance();
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
        // Commande infinie car la commande sera appellée avec un withTimeout()
        // donc elle sera interrompue à la fin du timeout
        return Parcourue >= Parcourir;
    }
}
