package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {

    public final EV3LargeRegulatedMotor mMiddleMotor = new EV3LargeRegulatedMotor(MotorPort.C);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void mars(double sped) {
        mMiddleMotor.set(sped);
    }
    
    public void stop() {
        mMiddleMotor.set(0);
    }
}
