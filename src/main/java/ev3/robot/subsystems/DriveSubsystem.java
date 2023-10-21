package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3.robot.Constants;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class DriveSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor m_rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);

    private final EV3GyroSensor m_GyroSensor = new EV3GyroSensor(SensorPort.S4);
    private int m_angle = 0;
    private double m_distance = 0;



    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private double m_xSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    private double m_zRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.

    public DriveSubsystem() {
        m_leftMotor.brake();
        m_rightMotor.brake();
    }

    @Override
    public void periodic() {
        m_robotDrive.arcadeDrive(m_xSpeed, m_zRotation);

        m_angle = m_GyroSensor.getAngle();
        Telemetry.putNumber("angle", m_angle);

        m_distance = m_leftMotor.getTachoCount() * Math.PI *  Constants.Robotconstants.k_diametreRoue / 360;
        Telemetry.putNumber("distance", m_distance);
    }

    public void arcadeDrive(double xSpeed, double zRotation){
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
    }

    public void stop() {
        m_xSpeed = 0;
        m_zRotation = 0;
    }

    public int getAngle() {
        return m_angle;
    }

    public double distancecm() {
        return m_distance;
    }

}
 