package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class BrasSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor mMoteurBras = new EV3LargeRegulatedMotor(MotorPort.C);
    //private final EV3TouchSensor mtouchsensor = new EV3TouchSensor(SensorPort.S1);

    public BrasSubsystem() {
    }

    @Override
    public void periodic() {
        Telemetry.putNumber("­tacho", tickcount());
    }

    public void descend() {
        mMoteurBras.set(0.40);
    }

    public void monte() {
        mMoteurBras.set(-0.40);
    }

    public void stop() {
        mMoteurBras.set(0);
    }
 
    public boolean isCapteurAppuye() { 
        return false;//mtouchsensor.isPressed();
    }

    public int tickcount() {
        return mMoteurBras.getTachoCount();
    }
}
        
