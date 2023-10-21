package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;


public class RamasseurSubsystem extends Subsystem {
private final ArduinoMotor mMoteurGauche = new ArduinoMotor(0);
private final ArduinoMotor mMoteurDroite = new ArduinoMotor(1);
    
   
    public RamasseurSubsystem() {
        mMoteurDroite.setInverted(true);
    }

    @Override
    public void periodic() {
    }

    public void ramasser(double speed) {
        mMoteurGauche.set(speed);
        mMoteurDroite.set(speed);
    }
    
    public void stop() {
        mMoteurGauche.set(0);
        mMoteurDroite.set(0);
    }
}
