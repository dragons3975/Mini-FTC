package ev3.robot.subsystems;

import dragons.ev3.ArduinoCRServo;
import dragons.ev3.ArduinoMotor;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class BrasSubsystem extends Subsystem {

    private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);
    private final ArduinoMotor m_motorBras2 = new ArduinoMotor(1);
    private final ArduinoCRServo m_motorBras5 = new ArduinoCRServo(4);

    double mSpeed = 0;

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
        m_motorBras1.set(mSpeed);
        m_motorBras2.set(mSpeed);
        m_motorBras5.set(mSpeed);
        DriverStationJNI.Telemetry.putNumber("Moteur1", m_motorBras1.getTachoCount());
        DriverStationJNI.Telemetry.putNumber("Moteur2", m_motorBras2.getTachoCount());
    }

    public void moveBras(double speed) {
        mSpeed = speed;
    }

    public void stop(){
        mSpeed = 0;
    }

}
