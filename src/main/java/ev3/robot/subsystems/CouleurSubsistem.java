package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import lejos.hardware.port.SensorPort;
import ev3dev.sensors.ev3.EV3ColorSensor;

public class CouleurSubsistem extends Subsystem {
    
    private final EV3ColorSensor mColorSensor = new EV3ColorSensor(SensorPort.S2);

    public CouleurSubsistem() {
    }

    @Override
    public void periodic() {
        Telemetry.putNumber("Couleur detecte", getColorID());
    }

    public int getColorID() {
        return mColorSensor.getColorID();
	}

    public void stop () {
    }

}

