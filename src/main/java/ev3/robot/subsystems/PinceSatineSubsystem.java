package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class PinceSatineSubsystem extends Subsystem {
     
    
    private EV3MediumRegulatedMotor mPinceMotor = new EV3MediumRegulatedMotor(MotorPort.D);
    private EV3TouchSensor mCapteurTactile = new EV3TouchSensor(SensorPort.S1);
    

    public PinceSatineSubsystem() {
    }

    @Override
    public void periodic() {
    }
  
    public void SatineOuvre(double speed) { 
        mPinceMotor.set(speed);
    }
    public void SatineFerme(double speed) { 
        mPinceMotor.set(-1);
    }
    public void stop() {
        mPinceMotor.set(0);
    }

    public boolean isBoutonAppuye() {
        return mCapteurTactile.isPressed();
    }

}
