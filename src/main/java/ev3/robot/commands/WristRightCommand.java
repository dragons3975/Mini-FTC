package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.WristSubsystem;

public class WristRightCommand extends Command {

    private final WristSubsystem mWristSubsystem;

    public WristRightCommand(WristSubsystem wristSubsystem) {
       mWristSubsystem = wristSubsystem; 

        addRequirements(mWristSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mWristSubsystem.WristRight();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mWristSubsystem.Stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
