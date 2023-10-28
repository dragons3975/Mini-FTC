package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class ExtendSubsystem extends Subsystem {

    private EV3TouchSensor mCapteurTactile = new EV3TouchSensor(SensorPort.S1);
    private ArduinoMotor mMotorExtend = new ArduinoMotor(0);
  
    public ExtendSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void SatineExtend(double speed) { 
        mMotorExtend.set(1);
    }

    public void SatineRetract(double speed) {
        mMotorExtend.set(-1);
    }

    public void stop() {
        mMotorExtend.set(0);
    }

    public boolean isBoutonAppuye() {
        return mCapteurTactile.isPressed();
    }

}