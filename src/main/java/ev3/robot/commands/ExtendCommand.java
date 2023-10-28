package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.ExtendSubsystem;

public class ExtendCommand extends Command {
    
    private XboxController mXboxController;
    private ExtendSubsystem mExtendSubsystem;

    public ExtendCommand(ExtendSubsystem ExtendSubsystem) { 
        mExtendSubsystem = ExtendSubsystem;
        addRequirements(ExtendSubsystem);
    }
    
    public ExtendCommand(ExtendSubsystem ExtendSubsystem, XboxController xboxController) { 
        mExtendSubsystem = ExtendSubsystem;
        mXboxController = xboxController;

        addRequirements(ExtendSubsystem);
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() { 
     mExtendSubsystem.SatineExtend(-1);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mExtendSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return mExtendSubsystem.isBoutonAppuye();
    }
}
