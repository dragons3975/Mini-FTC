package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;

public class ColorSubsystem extends Subsystem {

    private final EV3ColorSensor m_colorsensor = new EV3ColorSensor(SensorPort.S3);

    public ColorSubsystem() {

    }

    @Override
    public void periodic() {
       Telemetry.putNumber("color", getcolor());

       if (getcolor()== Color.BLACK){
        Telemetry.putData("couleur", "noir");
       }
        if (getcolor()== Color.BLUE){
            Telemetry.putData("couleur","bleu");
        }
        if (getcolor()== Color.BROWN){
            Telemetry.putData("couleur","marron");
        }
        if (getcolor()== Color.GREEN){
            Telemetry.putData("couleur", "vert");
        }
        if (getcolor()== Color.MAGENTA){
            Telemetry.putData("couleur", "rose");
        }
        if (getcolor()== Color.ORANGE){
            Telemetry.putData("couleur", "orange");
        }
       }

    public int getcolor() {
        return m_colorsensor.getColorID();
    
    }
}
    