package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {

    private final DriveSubsystem mDriveSubsystem;
    private final XboxController mXboxController;
    private double mX;
    private double mY;
    private double mZ;


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
        
    if (mXboxController.getLeftX() > 0.1 || mXboxController.getLeftX() < -0.1){ 
        mX = -mXboxController.getLeftX(); } else {mX = 0;}

    if (mXboxController.getLeftY() > 0.1 || mXboxController.getLeftY() < -0.1){ 
        mY = mXboxController.getLeftY(); } else {mY = 0;}

    if (mXboxController.getRightX() > 0.1 || mXboxController.getRightX() < -0.1){ 
        mZ = -mXboxController.getRightX(); } else {mZ = 0;}
            




    mDriveSubsystem.mecanumDrive(mX, mY, mZ);
        
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
