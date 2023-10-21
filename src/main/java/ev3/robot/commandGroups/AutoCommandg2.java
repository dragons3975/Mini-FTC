package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.AvanceAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutoCommandg2 extends SequentialCommandGroup {

    public AutoCommandg2(DriveSubsystem driveSubsystem) {

        AvanceAutoCommand avancer30cm = new AvanceAutoCommand(driveSubsystem, 1, 30);

        addCommands(
            avancer30cm
        );
    }

}
