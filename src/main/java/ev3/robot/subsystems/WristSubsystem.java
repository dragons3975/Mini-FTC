package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3.robot.Constants;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class WristSubsystem extends Subsystem {

    /*private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);
    private final ArduinoMotor m_motorBras2 = new ArduinoMotor(1);
    private final ArduinoMotor m_motorBras3 = new ArduinoMotor(2);
    private final ArduinoMotor m_motorBras4 = new ArduinoMotor(3);
    */

    private final EV3LargeRegulatedMotor WristMotor = new EV3LargeRegulatedMotor(SensorPort.S3);

    public WristSubsystem() {
    }

    @Override
    public void periodic() {
    }


    public void WristLeft() {
        WristMotor.set(-0.5);
    }

    public void WristRight() {
        WristMotor.set(0.5);
    }

    public void Stop() {
        WristMotor.set(0);
    }

}
