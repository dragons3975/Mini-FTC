package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.AvionSubsystem;
import ev3.robot.subsystems.PinceSubsystem;

public class AvionCommand extends Command {

    private AvionSubsystem mAvionSubsystem;
    
    public AvionCommand(AvionSubsystem avionSubsystem) {
    mAvionSubsystem = avionSubsystem;
    addRequirements(avionSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    mAvionSubsystem.AvionLancement();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    mAvionSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
    return false;
    }
}
