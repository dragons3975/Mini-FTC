package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.GripperSubsystem;

public class GripperCommand extends Command {

    private final XboxController mXboxController;
    private final GripperSubsystem mGripperSubsystem;

    public GripperCommand(GripperSubsystem gripperSubsystem, XboxController xboxController) {
       mXboxController = xboxController;
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
