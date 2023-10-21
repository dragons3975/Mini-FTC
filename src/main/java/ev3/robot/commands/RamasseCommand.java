package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.subsystems.RamasseurSubsystem;

public class RamasseCommand extends Command {

        private final RamasseurSubsystem mRamasseurSubsystem;
    public RamasseCommand(RamasseurSubsystem ramasseurSubsystem) {
        mRamasseurSubsystem = ramasseurSubsystem;
      

        addRequirements(ramasseurSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mRamasseurSubsystem.ramasser(.3);
    }


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mRamasseurSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
