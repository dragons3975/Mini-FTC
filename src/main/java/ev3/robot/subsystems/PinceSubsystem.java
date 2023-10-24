package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

/*
 * Idée générale du bras:
 * Deux moteurs inversés qui vont tourner
 * Un bras qui monte et descend
 */

public class PinceSubsystem extends Subsystem {

    private final EV3MediumRegulatedMotor mMiddleMotor2 = new EV3MediumRegulatedMotor(MotorPort.D);
   
    public PinceSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void set(double speed) {
        mMiddleMotor2.set(speed);
    }
    
    public void stop() {
        mMiddleMotor2.set(0);
    }

    public void MouvementPinceOuvre() {
        mMiddleMotor2.set(0.5);
    }

    public void MouvementPinceFerme() {
        mMiddleMotor2.set(-0.5);
    }

}
