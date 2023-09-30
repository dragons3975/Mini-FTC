package ev3.robot.subsystems;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.Subsystem;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;

public class CouleurSubsystem extends Subsystem {

    private final EV3ColorSensor mColorSensor = new EV3ColorSensor(SensorPort.S2);

    public CouleurSubsystem() {
    }

    @Override
    public void periodic() {
        if (getcolor() == Color.BLACK) {
            Telemetry.putData("couleur", "Noir");
        }
        if (getcolor() == Color.BLUE) {
            Telemetry.putData("couleur", "Bleu");
        } 
        if (getcolor()== Color.BROWN) {
            Telemetry.putData("couleur", "Brun");
        }
        if (getcolor()== Color.GREEN) {
            Telemetry.putData("couleur","Vert");
        }
        if (getcolor()== Color.MAGENTA) {
            Telemetry.putData("couleur", "Rose");
        }
        if (getcolor()== Color.NONE) {
            Telemetry.putData("couleur", "Aucun");
        }
        if (getcolor()== Color.ORANGE) {
            Telemetry.putData("couleur", "Orange");
        }
        if (getcolor()== Color.RED) {
            Telemetry.putData("couleur", "Rouge");
        }
        if (getcolor()== Color.WHITE) {
            Telemetry.putData("couleur", "Blanch");
        }
        if (getcolor()== Color.YELLOW) {
            Telemetry.putData("couleur", "Jaune");
        }
    }

    public int getcolor() {
        return mColorSensor.getColorID();
    }

}
