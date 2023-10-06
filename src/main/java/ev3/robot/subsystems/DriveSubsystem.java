package ev3.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class DriveSubsystem extends Subsystem {

    private final EV3LargeRegulatedMotor m_frontLeftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor m_frontRightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    private final EV3LargeRegulatedMotor m_rearLeftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
   private final EV3LargeRegulatedMotor m_rearRightMotor = new EV3LargeRegulatedMotor(MotorPort.D);
   
    private final MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_frontRightMotor, m_rearLeftMotor, m_rearRightMotor);

    public double mXSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    public double mYSpeed = 0;
    public double mZRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.

    public DriveSubsystem() {
        m_frontLeftMotor.brake();
        m_frontRightMotor.brake();
        m_rearLeftMotor.brake();
        m_rearRightMotor.brake();
    }
   
   
    public void mecanumDrive(double xSpeed, double ySpeed, double zRotation){
        mXSpeed = xSpeed;
        mYSpeed = ySpeed;
        mZRotation = zRotation;
    
        m_robotDrive.driveCartesian(xSpeed, ySpeed, zRotation);
    }

     @Override
    public void periodic() {


    }
    public void stop () {
        mecanumDrive(0, 0, 0);
    }

  
}
