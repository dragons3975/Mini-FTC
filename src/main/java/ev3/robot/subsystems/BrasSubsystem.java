package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class BrasSubsystem extends Subsystem {

    private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);
    private final ArduinoMotor m_motorBras2 = new ArduinoMotor(1);
    private final ArduinoMotor m_motorBras3 = new ArduinoMotor(2);
    private final ArduinoMotor m_motorBras4 = new ArduinoMotor(3);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
        /*m_motorBras1.set(0.1);
        m_motorBras2.set(0.2);
        m_motorBras3.set(0.3);
        m_motorBras4.set(0.4);
        m_motorBras1.get();
        m_motorBras2.get();
        m_motorBras3.get();
        m_motorBras4.get();
        System.out.println(m_motorBras1.getTachoCount());
        m_motorBras2.getTachoCount();
        m_motorBras3.getTachoCount();
        m_motorBras4.getTachoCount();*/
    }

}
