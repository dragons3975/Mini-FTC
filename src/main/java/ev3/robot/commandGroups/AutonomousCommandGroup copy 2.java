package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem) {

        ParallelRaceGroup avancer5sec = new DriveAutoCommand(driveSubsystem, 1, 0).withTimeout(5);
        ParallelRaceGroup tourner1sec = new DriveAutoCommand(driveSubsystem, 0, 1).withTimeout(1);
        ParallelRaceGroup reculer5sec = new DriveAutoCommand(driveSubsystem, -1, 0).withTimeout(5);

        addCommands(
            avancer5sec,
            tourner1sec,
            reculer5sec
        );
    }

}
