package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class BrasSubsystem extends Subsystem {

    private EV3LargeRegulatedMotor mMotorBras = new EV3LargeRegulatedMotor(MotorPort.C);

    private EV3TouchSensor mCapteurTactile = new EV3TouchSensor(SensorPort.S1);

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

    public boolean isBoutonAppuye() {
        return mCapteurTactile.isPressed();
    }

}
