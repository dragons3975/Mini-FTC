package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Subsystem;
//import ev3dev.sensors.ev3.EV3TouchSensor;
//import lejos.hardware.port.SensorPort;

public class BrasSubsystem extends Subsystem {

    private final ArduinoMotor mMoteurBras = new ArduinoMotor(1); 
    private final PIDController mPID = new PIDController(0.03, 0, 0);

    private double mConsigne = 0;

    public BrasSubsystem() {
        mPID.setTolerance(1000);
        stop();
    }

    @Override
    public void periodic() {
        double encodeur = mMoteurBras.getTachoCount();
        Telemetry.putNumber("encodeur bras", encodeur);

        double speed = mPID.calculate(encodeur, mConsigne);
        Telemetry.putNumber("speed bras", speed);
        mMoteurBras.set(speed);
    }

    public void stop() {
        mConsigne = mMoteurBras.getTachoCount();
    }

    public void changeConsigne(double valeur){
        mConsigne += 100*valeur;
    }


}
        
