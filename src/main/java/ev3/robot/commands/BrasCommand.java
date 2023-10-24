package ev3.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.BrasSubsystem;

public class BrasCommand extends Command {

    private double mOuvre;
    private double mMonte;

    private final BrasSubsystem mBrasSubsystem;

    public BrasCommand(BrasSubsystem brasSubsystem, double ouvre, double monte) {
        mBrasSubsystem = brasSubsystem;
        mOuvre = ouvre;
        mMonte = monte;

        addRequirements(brasSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (mOuvre == 0) {
            mBrasSubsystem.ouvre();
        } else if (mOuvre == 2) {
            mBrasSubsystem.ferme();
        }
        if (mMonte == 0) {
            mBrasSubsystem.monte();
        } else if (mMonte == 2) {
            mBrasSubsystem.baisse();
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
        return false;
    }
}
