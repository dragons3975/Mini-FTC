package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.BrasSubsystem;

public class BrasTestCommand extends Command {

    private final BrasSubsystem mBrasSubsystem;

    public BrasTestCommand(BrasSubsystem brasSubsystem) {
        mBrasSubsystem = brasSubsystem;

        addRequirements(brasSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
       // mBrasSubsystem.descend();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       if (mBrasSubsystem.tickcount() < 0) {
           mBrasSubsystem.descend();
       }
       else {
           mBrasSubsystem.monte();
       }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mBrasSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return mBrasSubsystem.isCapteurAppuye() || mBrasSubsystem.tickcount() > -15 && mBrasSubsystem.tickcount()< 15 ;
    }

}
