package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.PinceSubsystem;

public class TogglePinceCommand extends Command {

private final PinceSubsystem mPinceSubsystem;

public TogglePinceCommand(PinceSubsystem pinceSubsyem) {
    mPinceSubsystem = pinceSubsyem;

    addRequirements(pinceSubsyem);
}

 // Called when the command is initially scheduled.
 @Override
 public void initialize() {
    if (mPinceSubsystem.getPosition())
    {
        mPinceSubsystem.close();
    }
    else
    {
        mPinceSubsystem.open();
    }

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