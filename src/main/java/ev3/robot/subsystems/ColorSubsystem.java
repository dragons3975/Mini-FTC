package ev3.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;

public class ColorSubsystem extends Subsystem {

    //private final EV3ColorSensor mColor = new EV3ColorSensor(SensorPort.S2);
   
    public ColorSubsystem() {
    }

    @Override
    public void periodic() {
    }

    //public int getColor() {
      //  return mColor.getColorID();
  //  }

}
