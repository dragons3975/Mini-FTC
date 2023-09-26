package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {

    private EV3LargeRegulatedMotor mMotorBras = new EV3LargeRegulatedMotor(MotorPort.C);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void SatineBouge() { 
        mMotorBras.set(1.0);
    }

    public void stop() {
        mMotorBras.set(0);
    }

}
