package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.PinceSatineSubsystem;

public class PinceSatineOuvreCommand extends Command {
    
    private XboxController mXboxController;
    private PinceSatineSubsystem mPinceSatineSubsystem;

    public PinceSatineOuvreCommand(PinceSatineSubsystem PinceSatineSubsystem) { 
        mPinceSatineSubsystem = PinceSatineSubsystem;
        addRequirements(PinceSatineSubsystem);
    }
    
    public PinceSatineOuvreCommand(PinceSatineSubsystem PinceSatineSubsystem, XboxController xboxController) { 
        mPinceSatineSubsystem = PinceSatineSubsystem;
        mXboxController = xboxController;

        addRequirements(PinceSatineSubsystem);
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() { 
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mPinceSatineSubsystem.SatineOuvre(1);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mPinceSatineSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return mPinceSatineSubsystem.isBoutonAppuye();
    }
}
