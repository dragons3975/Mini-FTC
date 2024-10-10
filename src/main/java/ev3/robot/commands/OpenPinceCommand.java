package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.PinceSubsystem;

public class OpenPinceCommand extends Command {

    private final PinceSubsystem mPinceSubsystem;

    public OpenPinceCommand(PinceSubsystem pinceSubsystem) {
        mPinceSubsystem = pinceSubsystem;

        addRequirements(pinceSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mPinceSubsystem.openPince();
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
        return true;
    }
}
