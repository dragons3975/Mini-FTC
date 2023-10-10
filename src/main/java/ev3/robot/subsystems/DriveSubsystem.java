package ev3.robot.subsystems;

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

    private final EV3GyroSensor m_gyroSensor = new EV3GyroSensor(SensorPort.S1);
    
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private final SampleProvider m_gyroSampleProvider = m_gyroSensor.getAngleAndRateMode();
    private float[] m_gyroSample = new float[m_gyroSampleProvider.sampleSize()];
    private double m_degre = 0;

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

        m_gyroSampleProvider.fetchSample(m_gyroSample, 0);
        m_degre = (int)m_gyroSample[0];
        Telemetry.putNumber("degre", m_degre);
    }

    public double getDegre() {
        return m_degre;
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
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
