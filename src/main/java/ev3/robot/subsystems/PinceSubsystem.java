package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import dragons.ev3.ArduinoServo;
import dragons.ev3.Ev3ColorSensor;
import dragons.ev3.Ev3GyroSensor;
import dragons.ev3.Ev3TouchSensor;
import dragons.ev3.Ev3UltrasonicSensor;
import dragons.ev3.RemoteEv3;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class PinceSubsystem extends Subsystem {

    // private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);
    // private final ArduinoMotor m_motorBras2 = new ArduinoMotor(1);
    // private final Ev3TouchSensor touch = new Ev3TouchSensor();
    // private final Ev3ColorSensor color = new Ev3ColorSensor();
    // private final Ev3UltrasonicSensor ultra = new Ev3UltrasonicSensor();
    // private final Ev3GyroSensor gyro = new Ev3GyroSensor();

    //private final ArduinoServo m_servo2 = new ArduinoServo(2) ;
    //private final ArduinoServo m_servo3 = new ArduinoServo(3) ;
    //private final ArduinoServo m_servo4 = new ArduinoServo(4) ;
  
    public PinceSubsystem() {
        openPince();
    }

    @Override
    public void periodic() {
    }

    public void openPince() {
        //m_servo2.setAngle(0);
        //m_servo3.setAngle(180);
        //m_servo4.setAngle(180);
    }

    public void closePince() {
        //m_servo2.setAngle(90);
        //m_servo3.setAngle(90);
        //m_servo4.setAngle(90);
    }

}
