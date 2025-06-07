package ev3.robot.subsystems;

import dragons.ev3.ArduinoServo;
import dragons.ev3.Ev3ColorSensor;
import dragons.ev3.Ev3GyroSensor;
import dragons.ev3.Ev3TouchSensor;
import dragons.ev3.Ev3UltrasonicSensor;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class PinceSubsystem extends Subsystem {

    private final ArduinoServo m_servo2 = new ArduinoServo(2);

    private boolean isClosed = true; 
  
    public PinceSubsystem() {
        closePince();
        isClosed = true; 
    }

    @Override
    public void periodic() {
    }

    public void openPince() {
        m_servo2.setAngle(90);
        isClosed = false;
    }

    public void closePince() {
        m_servo2.setAngle(0);
        isClosed = true;
    }

    public void togglePince() {
        if (isClosed) {
            isClosed = false;
            openPince(); 
        } else {
            isClosed = true;
            closePince();
        }
    }
}
