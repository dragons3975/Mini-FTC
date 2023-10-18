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
        
        int couleur = getcolor();

        if (couleur == Color.BLACK) {
            Telemetry.putData("couleur", "Noir");
        }
        if (couleur == Color.BLUE) {
            Telemetry.putData("couleur", "Bleu");
        } 
        if (couleur == Color.BROWN) {
            Telemetry.putData("couleur", "Brun");
        }
        if (couleur == Color.GREEN) {
            Telemetry.putData("couleur","Vert");
        }
        if (couleur == Color.MAGENTA) {
            Telemetry.putData("couleur", "Rose");
        }
        if (couleur == Color.NONE) {
            Telemetry.putData("couleur", "Aucun");
        }
        if (couleur == Color.ORANGE) {
            Telemetry.putData("couleur", "Orange");
        }
        if (couleur == Color.RED) {
            Telemetry.putData("couleur", "Rouge");
        }
        if (couleur == Color.WHITE) {
            Telemetry.putData("couleur", "Blanch");
        }
        if (couleur == Color.YELLOW) {
            Telemetry.putData("couleur", "Jaune");
        }
    }

    public int getcolor() {
        return mColorSensor.getColorID();
    }

}
