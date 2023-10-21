package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class BrasSubsystem extends Subsystem {

   
    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void mars(double sped) {
        //mMiddleMotor.set(sped);
    }
    
    public void stop() {
        //mMiddleMotor.set(0);
    }
}
