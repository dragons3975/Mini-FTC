package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class BrasSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_brasmotor = new EV3LargeRegulatedMotor(MotorPort.C);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void descendre(){
        m_brasmotor.set(1);
    }

    public void monter(){
        m_brasmotor.set(-1);
    }

    public void stop(){
        m_brasmotor.set(0);
    }

}
