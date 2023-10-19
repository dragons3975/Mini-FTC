package ev3.robot.commands;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Command;

public class TelemetryBoolCommand extends Command {
    private String mVariableName;
    public TelemetryBoolCommand(String variableName) {
        mVariableName = variableName;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Telemetry.putBoolean(mVariableName, true);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Telemetry.putBoolean(mVariableName, false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
