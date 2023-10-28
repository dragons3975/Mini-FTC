package ev3.robot.subsystems;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

/*
 * Idée générale du bras:
 * Deux moteurs inversés qui vont tourner
 * Un bras qui monte et descend
 */

public class AvionSubsystem extends Subsystem {
    
    private EV3MediumRegulatedMotor mAvion = new EV3MediumRegulatedMotor(MotorPort.C);

    public AvionSubsystem() {
}

    @Override
    public void periodic() {
}

    public void set(double speed) {
    mAvion.set(speed);
}
    
    public void stop() {
    mAvion.set(0);
       
}

    public void AvionLancement() {
    mAvion.set(0.5);
}

}
