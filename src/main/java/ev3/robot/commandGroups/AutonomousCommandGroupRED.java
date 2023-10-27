package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.AvanceAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroupRED extends SequentialCommandGroup {

    public AutonomousCommandGroupRED(DriveSubsystem driveSubsystem) {

        AvanceAutoCommand avancer4cm = new AvanceAutoCommand(driveSubsystem, 1, 100.0);
      

        addCommands(
            avancer4cm
        );
    }

}
