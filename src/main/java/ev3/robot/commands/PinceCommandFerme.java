package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.PinceSubsystem;

public class PinceCommandFerme extends Command {

    private PinceSubsystem mPinceSubsystem;
    
    public PinceCommandFerme(PinceSubsystem pinceSubsystem) {
        mPinceSubsystem = pinceSubsystem;
        addRequirements(pinceSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        mPinceSubsystem.MouvementPinceFerme();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mPinceSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
