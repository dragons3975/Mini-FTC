package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class BrasSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_brasmotor = new EV3LargeRegulatedMotor(MotorPort.C);
    private final EV3TouchSensor m_capteur = new EV3TouchSensor(SensorPort.S1);
    
    public BrasSubsystem() {
    }

    public boolean isCapteurEnfonce(){
        return m_capteur.isPressed();
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
