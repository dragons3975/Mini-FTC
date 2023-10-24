package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import ev3.robot.commands.BrasCommand;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.commands.GyroCommand;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem) {

        //ParallelRaceGroup avancer5sec = new DriveAutoCommand(driveSubsystem, 1, 0).withTimeout(5);
        //ParallelRaceGroup tourner1sec = new DriveAutoCommand(driveSubsystem, 0, 1).withTimeout(1);
        //ParallelRaceGroup reculer5sec = new DriveAutoCommand(driveSubsystem, -1, 0).withTimeout(5);
        DriveAutoCommand avancerNbr = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        DriveAutoCommand avancerNbr2 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        DriveAutoCommand avancerNbr3 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        DriveAutoCommand avancerNbr4 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        GyroCommand tourner90Degre = new GyroCommand(driveSubsystem, 90);
        GyroCommand tourner90Degre2 = new GyroCommand(driveSubsystem, 90);
        GyroCommand tourner90Degre3 = new GyroCommand(driveSubsystem, 90);
        GyroCommand tourner90Degre4 = new GyroCommand(driveSubsystem, 90);
        GyroCommand tournerMoins360Degre = new GyroCommand(driveSubsystem, -90);

        addCommands(
            //avancerNbr,
            tourner90Degre,
            new WaitCommand(2),
            avancerNbr,
            new WaitCommand(2),
            tourner90Degre2,
            new WaitCommand(2),
            avancerNbr2,
            new WaitCommand(2),
            tourner90Degre3,
            new WaitCommand(2),
            avancerNbr3,
            new WaitCommand(2),
            tourner90Degre4,
            new WaitCommand(2),
            avancerNbr4
            //avancer5sec,
            //tourner1sec,
            //reculer5sec
        );
    }

}
