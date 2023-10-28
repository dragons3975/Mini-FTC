package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
public class DriveSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_frontLeftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor m_frontRightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    private final EV3LargeRegulatedMotor m_rearLeftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
    private final EV3LargeRegulatedMotor m_rearRightMotor = new EV3LargeRegulatedMotor(MotorPort.D);
    private final MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_frontRightMotor, m_rearLeftMotor, m_rearRightMotor);
    
    private final EV3GyroSensor mGyro = new EV3GyroSensor(SensorPort.S1);
    private int mAngle = 0;

    private double mXSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    private double mYSpeed = 0;
    private double mZRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.

    public DriveSubsystem() {
        m_frontLeftMotor.brake();
        m_frontRightMotor.brake();
        m_rearLeftMotor.brake();
        m_rearRightMotor.brake();
        m_frontLeftMotor.setInverted(true);
        m_rearLeftMotor.setInverted(true);
    }
   

    public void mecanumDrive(double xSpeed, double ySpeed, double zRotation){
        mXSpeed = xSpeed;
        mYSpeed = ySpeed;
        mZRotation = zRotation;
    
        
    }

     @Override
    public void periodic() {
        mAngle = mGyro.getAngle();
        Telemetry.putNumber("angle", mAngle);
       
        m_robotDrive.driveCartesian(mXSpeed, mYSpeed, mZRotation);
    }
    public void stop () {
        mecanumDrive(0, 0, 0);
    }

  
}
