package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class PinceSubsystem extends Subsystem {
    
    private final EV3MediumRegulatedMotor mServoPince = new EV3MediumRegulatedMotor(MotorPort. D);
    private final PIDController mPID = new PIDController(0.05, 0, 0);
    private double mangle = 0;
    private boolean mPosition = false;

    public PinceSubsystem() {
        mServoPince.setInverted(true);
    }

    @Override
    public void periodic() {
        double encodeur = mServoPince.getTachoCount();
        Telemetry.putNumber("Angle", mangle);
        Telemetry.putNumber("encodeur", encodeur);
        double consigne = mPID.calculate(encodeur, mangle);
        Telemetry.putNumber("consigne", consigne);
        mServoPince.set(consigne);
    }

    public void open() {
        mangle = 30;
        mPosition = true;
    }

    public void close() {
        mangle = 0;
        mPosition = false;
    }

    public boolean getPosition() {
        return mPosition;
    }
}
        
