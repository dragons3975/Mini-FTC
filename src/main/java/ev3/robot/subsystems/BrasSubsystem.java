package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {
    
    private final EV3LargeRegulatedMotor m_moteurPince = new EV3LargeRegulatedMotor(MotorPort.C);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void ferme() {
        m_moteurPince.set(-1.0);
    }

    public void ouvre() {
        m_moteurPince.set(1.0);
    }

    public void stop () {
        m_moteurPince.set(0);
    }

}
