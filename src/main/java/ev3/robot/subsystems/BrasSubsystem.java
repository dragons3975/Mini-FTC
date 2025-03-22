package ev3.robot.subsystems;

import dragons.ev3.ArduinoCRServo;
import dragons.ev3.ArduinoMotor;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class BrasSubsystem extends Subsystem {

    private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);

    double mSpeed = 0;

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
        /*if (m_motorBras1.getTachoCount() > 150)
        {
            mSpeed = 0;
        }*/
        m_motorBras1.set(mSpeed);
        DriverStationJNI.Telemetry.putNumber("Moteur1", m_motorBras1.getTachoCount());
    }

    public void moveBras(double speed) {
        mSpeed = speed;
    }

    public void stop(){
        mSpeed = 0;
    }

}
