package ev3.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import ev3.robot.subsystems.BrasSubsystem;

public class BrasTestCommand extends Command {

    private final BrasSubsystem mBrasSubsystem;
    private final XboxController mXboxController;

    public BrasTestCommand(BrasSubsystem brasSubsystem, XboxController kxboxControllerCP) {
        mBrasSubsystem = brasSubsystem;
        mXboxController = kxboxControllerCP;

        addRequirements(brasSubsystem);
    } 

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        mBrasSubsystem.changeConsigne(mXboxController.getRightY());
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
