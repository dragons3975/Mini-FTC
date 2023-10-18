package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.AvanceAutoCommand;
import ev3.robot.commands.TourneAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem) {

        AvanceAutoCommand avancer5cm = new AvanceAutoCommand(driveSubsystem, 1, 5);
        TourneAutoCommand tourne90 = new TourneAutoCommand(driveSubsystem, 0.2, 90);

        addCommands(
            avancer5cm,
            tourne90
        );
    }

}
