package ev3.robot.commands;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Command;

public class TelemetryStringCommand extends Command {
    private String mVariableName;
    private String mInitialValue;
    private String mEndValue;
    public TelemetryStringCommand(String variableName, String initialValue, String endValue) {
        mVariableName = variableName;
        mInitialValue = initialValue;
        mEndValue = endValue;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Telemetry.putData(mVariableName, mInitialValue);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Telemetry.putData(mVariableName, mEndValue);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
