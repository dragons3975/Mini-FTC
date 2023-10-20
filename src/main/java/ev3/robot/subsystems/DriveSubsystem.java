package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.math.controller.PIDController;
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
    private final PIDController m_zPID = new PIDController(0.025, 0, 0);
    
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private final SampleProvider m_gyroSampleProvider = m_gyroSensor.getAngleAndRateMode();
    private float[] m_gyroSample = new float[m_gyroSampleProvider.sampleSize()];
    private double m_degre = 0;
    private double m_degreOffset = 0;

    private double m_xSpeed = 0;
    private double m_zRotation = 0; 

    private boolean m_zPID_enabled = false;
    private double m_zTarget = 0;

    public DriveSubsystem() {
        m_leftMotor.brake();
        m_rightMotor.brake();
        resetGyro();
        m_zPID.setTolerance(3);
    }

    @Override
    public void periodic() {
        m_gyroSampleProvider.fetchSample(m_gyroSample, 0);
        m_degre = (int)m_gyroSample[0];
        Telemetry.putNumber("degre", getDegre());

        if (m_zPID_enabled) {
            double zRotation = m_zPID.calculate(getDegre(), m_zTarget);
            m_robotDrive.arcadeDrive(m_xSpeed, zRotation);
        }
        else {
            m_robotDrive.arcadeDrive(m_xSpeed, m_zRotation);
        }

        Telemetry.putNumber("distance", getCentimetreParcourus());  
    }

    public void resetGyro() {
        m_gyroSampleProvider.fetchSample(m_gyroSample, 0);
        m_degreOffset = (int)m_gyroSample[0];
    }

    public double getDegre() {
        return (m_degre - m_degreOffset) % 360;
    }

    public boolean isAtSettPoint() {
        return m_zPID.atSetpoint();
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
        m_zPID_enabled = false;
    }

    public void autoDrive(double xSpeed, double zAngle) {
        m_xSpeed = xSpeed;
        m_zTarget = zAngle;
        m_zPID_enabled = true;
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
