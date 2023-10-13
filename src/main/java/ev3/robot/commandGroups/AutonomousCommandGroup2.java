package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.commands.GyroCommand;

public class AutonomousCommandGroup2 extends SequentialCommandGroup {

    public AutonomousCommandGroup2(DriveSubsystem driveSubsystem) {

        //ParallelRaceGroup avancer5sec = new DriveAutoCommand(driveSubsystem, 1, 0).withTimeout(5);
        //ParallelRaceGroup tourner1sec = new DriveAutoCommand(driveSubsystem, 0, 1).withTimeout(1);
        //ParallelRaceGroup reculer5sec = new DriveAutoCommand(driveSubsystem, -1, 0).withTimeout(5);
        DriveAutoCommand avancerNbr = new DriveAutoCommand(driveSubsystem, 1, 0, 200);
        GyroCommand tourner90Degre = new GyroCommand(driveSubsystem, 90);
        GyroCommand tournerMoins360Degre = new GyroCommand(driveSubsystem, -360);

        addCommands(
            avancerNbr,
            tournerMoins360Degre,
            tourner90Degre
            //avancer5sec,
            //tourner1sec,
            //reculer5sec
        );
    }

}
