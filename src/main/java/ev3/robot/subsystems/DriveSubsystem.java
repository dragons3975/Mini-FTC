package ev3.robot.subsystems;

import dragons.ev3.Ev3Motor;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveSubsystem extends Subsystem {

    private final Ev3Motor m_frontLeftMotor = new Ev3Motor(0);
    private final Ev3Motor m_rearLeftMotor = new Ev3Motor(1);
    private final Ev3Motor m_frontRightMotor = new Ev3Motor(2);
    private final Ev3Motor m_rearRightMotor = new Ev3Motor(3);
    
    private final MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_frontRightMotor, m_rearLeftMotor, m_rearRightMotor);

    private double m_xSpeed = 0; // The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
    private double m_zRotation = 0; // The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.
    private double m_ySpeed = 0;

    public DriveSubsystem() {
        m_rearRightMotor.setInverted(true);
        m_frontRightMotor.setInverted(true);
    }

    @Override
    public void periodic() {
        // On inverse volontairement x et y pour avoir le x vers l'avant
        m_robotDrive.driveCartesian(m_ySpeed, m_xSpeed, m_zRotation);
    }

    public void mecanumDrive(double xSpeed, double ySpeed, double zRotation){
        m_xSpeed = xSpeed;
        m_ySpeed = ySpeed;
        m_zRotation = zRotation;
    }

    public void stop () {
        m_xSpeed = 0;
        m_ySpeed = 0;
        m_zRotation = 0;
    }

}
