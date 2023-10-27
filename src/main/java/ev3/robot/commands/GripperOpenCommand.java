package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.GripperSubsystem;

public class GripperOpenCommand extends Command {

    private final GripperSubsystem mGripperSubsystem;

    public GripperOpenCommand(GripperSubsystem gripperSubsystem) {
       mGripperSubsystem = gripperSubsystem; 

        addRequirements(mGripperSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mGripperSubsystem.GripperOpen();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
