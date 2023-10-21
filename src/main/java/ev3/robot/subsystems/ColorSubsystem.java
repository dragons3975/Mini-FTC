package ev3.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3.robot.Constants;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;



public class ColorSubsystem extends Subsystem {

    private final EV3ColorSensor ColorSensor = new EV3ColorSensor(SensorPort.S2);



    public ColorSubsystem() {
     
    }

    @Override
    public void periodic() {
     

    }

    public int GetColorID() {
        return ColorSensor.getColorID();

    }


}
