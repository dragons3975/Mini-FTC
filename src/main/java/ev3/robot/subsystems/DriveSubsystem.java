package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;

public class DriveSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor m_rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    private static EV3GyroSensor m_gyroSensor = new EV3GyroSensor(SensorPort.S1);
    
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private static double degre = 0;
    final SampleProvider sp = m_gyroSensor.getAngleAndRateMode();
    private double m_xSpeed = 0;
    private double m_zRotation = 0; 

    public DriveSubsystem() {
        m_leftMotor.brake();
        m_rightMotor.brake();
    }

    @Override
    public void periodic() {
        m_robotDrive.arcadeDrive(m_xSpeed, m_zRotation);
        Telemetry.putNumber("distance", getCentimetreParcourus());
        float [] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        degre = (int)sample[0];
        Telemetry.putNumber("degre", degre);
    }

    public static double getDegre() {
        return degre;
    }

    public void arcadeDrive(double xSpeed, double zRotation){
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
    }

    public void resetTachos() {
        m_leftMotor.resetTachoCount();
    }

    public double getCentimetreParcourus() {
        return (m_leftMotor.getTachoCount() * ((Math.PI * 9.5) / 360));
    }

    public void stop () {
        m_xSpeed = 0;
        m_zRotation = 0;
    }

}
