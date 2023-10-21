package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.RotateAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutoCommandg1 extends SequentialCommandGroup {

    public AutoCommandg1(DriveSubsystem driveSubsystem) {
       
        RotateAutoCommand tourne90degree = new RotateAutoCommand(driveSubsystem, -1, 90);

        addCommands(
            tourne90degree
        );
    }

}
