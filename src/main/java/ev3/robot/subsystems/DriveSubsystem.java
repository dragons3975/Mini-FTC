package ev3.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3.robot.Constants;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;


public class DriveSubsystem extends Subsystem {


    //private final ArduinoMotor m_leftMotor = new ArduinoMotor(0);
    //private final ArduinoMotor m_rightMotor = new ArduinoMotor(0);

    private final EV3LargeRegulatedMotor m_leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor m_rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    private final EV3GyroSensor mGyro = new EV3GyroSensor(SensorPort.S1);

    private double EncoderDistanceRaw;
    private int GyroAngleRaw;
    private double m_xSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    private double m_zRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.

    public DriveSubsystem() {
        m_leftMotor.brake();
        m_rightMotor.brake();
    }

    @Override
    public void periodic() {
        m_robotDrive.arcadeDrive(m_xSpeed, m_zRotation);

    }

    public void arcadeDrive(double xSpeed, double zRotation){
        m_xSpeed = xSpeed;
        m_zRotation = zRotation;
    }

    public double getDistance() {
    EncoderDistanceRaw = m_rightMotor.getTachoCount();  
        return EncoderDistanceRaw / 360 * Constants.RobotConstants.kCirconference;
    }

    public void resetEncoders() {
        m_rightMotor.resetTachoCount();
        m_leftMotor.resetTachoCount();
    }

    public int getAngleGyro()  { 
        GyroAngleRaw = mGyro.getAngle();
        return GyroAngleRaw;
    }


    
    public void stop () {
        m_xSpeed = 0;
        m_zRotation = 0;
    }

}
