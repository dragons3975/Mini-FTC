package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {
    
    private final EV3MediumRegulatedMotor m_moteurPince = new EV3MediumRegulatedMotor(MotorPort.C);

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
        System.out.println("ouvre");
    }

    public void stop () {
        m_moteurPince.set(0);
    }

}
