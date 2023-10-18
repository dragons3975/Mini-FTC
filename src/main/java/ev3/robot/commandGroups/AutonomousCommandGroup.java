package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem) {

        DriveAutoCommand avancer5cm = new DriveAutoCommand(driveSubsystem, 1, 0, 5);

        addCommands(
            avancer5cm
        );
    }

}
