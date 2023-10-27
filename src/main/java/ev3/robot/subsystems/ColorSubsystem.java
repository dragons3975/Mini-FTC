package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;

public class ColorSubsystem extends Subsystem {

    private final EV3ColorSensor m_colorsensor = new EV3ColorSensor(SensorPort.S3);
    //private final EV3TouchSensor mtouchsensor = new EV3TouchSensor(SensorPort.S1);

    public ColorSubsystem() {

    }

    @Override
    public void periodic() {
       Telemetry.putNumber("color", getcolor());

       if (getcolor()==color.RED)
       


    }

    public int getcolor() {
        return m_colorsensor.getColorID();
    
    }
}
       