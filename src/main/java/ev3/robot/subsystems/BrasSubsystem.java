package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {
    
    private final EV3MediumRegulatedMotor m_moteurPince = new EV3MediumRegulatedMotor(MotorPort.C);
    private final ArduinoMotor m_moteurBras = new ArduinoMotor(0);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void ferme() {
        m_moteurPince.set(-1);
    }

    public void ouvre() {
        m_moteurPince.set(1);
    }

    public void monte() {
        m_moteurBras.set(-0.1);
    }

    public void baisse() {
        Telemetry.putData("oui", "oui");;
        m_moteurBras.set(0.5);
    }

    public double getTacho() {
        return m_moteurBras.getTachoCount();
    }

    public void stop () {
        m_moteurPince.set(0);
        m_moteurBras.set(0);
    }

}
