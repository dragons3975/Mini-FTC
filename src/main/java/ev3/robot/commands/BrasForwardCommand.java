package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.BrasSubsystem;

public class BrasForwardCommand extends Command {

    private final BrasSubsystem mBrasSubsystem;

    public BrasForwardCommand(BrasSubsystem brasSubsystem) {
       mBrasSubsystem = brasSubsystem; 

        addRequirements(mBrasSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mBrasSubsystem.BrasBackward();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mBrasSubsystem.Stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
