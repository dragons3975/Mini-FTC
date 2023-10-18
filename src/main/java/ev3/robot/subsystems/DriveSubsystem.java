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
    
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private double m_xSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    private double m_zRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.

    private final EV3GyroSensor m_gyroSensor =  new EV3GyroSensor(SensorPort.S4);
    private final SampleProvider m_sampleProvider = m_gyroSensor.getAngleMode();
    private float[] m_sample = new float[m_sampleProvider.sampleSize()];
    private int m_angle;

    public DriveSubsystem() {
        m_leftMotor.brake();
        m_rightMotor.brake();
    }

    @Override
    public void periodic() {
        m_robotDrive.arcadeDrive(m_xSpeed, m_zRotation);

        m_sampleProvider.fetchSample(m_sample, 0);
        m_angle = (int)m_sample[0];
        //m_angle = m_gyroSensor.getAngle();
        Telemetry.putNumber("angle", m_angle);
    }

    public void arcadeDrive(double xSpeed, double zRotation){
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
    }

    public void stop () {
        m_xSpeed = 0;
        m_zRotation = 0;
    }
    
    public double getDistanceCm() {
        return m_leftMotor.getTachoCount() * 9.5 * Math.PI / 360;
    }

    public int getAngle() {
        return m_angle;
    }
}
