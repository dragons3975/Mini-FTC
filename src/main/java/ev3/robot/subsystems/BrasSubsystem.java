package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;

/*
 * Idée générale du bras:
 * Deux moteurs inversés qui vont tourner
 * Un bras qui monte et descend
 */

public class BrasSubsystem extends Subsystem {
    
    private final ArduinoMotor mMiddleMotor1 = new ArduinoMotor(0);
   
    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void set(double speed) {
        mMiddleMotor1.set(speed);
    }
    
    public void stop() {
        mMiddleMotor1.set(0);
       
    }

    public void MouvementBrasHaut() {
        mMiddleMotor1.set(0.3);
    }

    public void MouvementBrasBas() {
        mMiddleMotor1.set(-0.3);
    }

}
