package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.AvanceAutoCommand;
import ev3.robot.commands.RotateAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem) {

        //AvanceAutoCommand avancer30cm = new AvanceAutoCommand(driveSubsystem, 1, 30);
        RotateAutoCommand tourne90degree = new RotateAutoCommand(driveSubsystem, 1, 90);

        addCommands(
            //avancer30cm
            tourne90degree
        );
    }

}
