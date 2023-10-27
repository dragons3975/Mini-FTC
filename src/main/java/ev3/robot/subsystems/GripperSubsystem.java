package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3.robot.Constants;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class GripperSubsystem extends Subsystem {

    
    //private final ArduinoMotor GripperMotor = new ArduinoMotor(3);
    private final EV3LargeRegulatedMotor GripperMotor = new EV3LargeRegulatedMotor(MotorPort.C);

    public GripperSubsystem() {
    }

    @Override
    public void periodic() {
    }


    public void GripperOpen() {
        GripperMotor.set(0.5);
    }

    public void GripperClose() {
        GripperMotor.set(-0.5);

    }

    public void Stop() {
        GripperMotor.set(0);
    }

}
