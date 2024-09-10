package ev3.robot.subsystems;

import dragons.ev3.ArduinoMotor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class BrasSubsystem extends Subsystem {

    private final ArduinoMotor m_motorBras1 = new ArduinoMotor(0);
    private final ArduinoMotor m_motorBras2 = new ArduinoMotor(1);
    private final XboxController mXboxController;

    public BrasSubsystem(XboxController xboxController) {
        mXboxController = xboxController;
    }

    @Override
    public void periodic() {
        m_motorBras1.set(mXboxController.getLeftX());
        m_motorBras2.set(mXboxController.getLeftY());
        System.out.println(m_motorBras1.getTachoCount());
        System.out.println(m_motorBras1.getTachoCount());
    }

}
