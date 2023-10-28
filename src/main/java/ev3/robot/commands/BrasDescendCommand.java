package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.BrasSubsystem;

public class BrasDescendCommand extends Command {
   
    private XboxController mXboxController;
    private BrasSubsystem mBrasSubsystem;

    public BrasDescendCommand(BrasSubsystem brasSubsystem) { 
        mBrasSubsystem = brasSubsystem;
        addRequirements(brasSubsystem);
    }

    public BrasDescendCommand(BrasSubsystem brasSubsystem, XboxController xboxController) { 
        mBrasSubsystem = brasSubsystem;
        mXboxController = xboxController;

        addRequirements(brasSubsystem);
    }
    

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
       mBrasSubsystem.SatineDescend(1); 
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mBrasSubsystem.stop();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return mBrasSubsystem.isBoutonAppuye();
    }
} 
