package ev3.robot.commandGroups;

import edu.wpi.first.hal.DriverStationJNI.Telemetry;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import ev3.robot.commands.BrasCommand;
import ev3.robot.commands.DriveAutoCommand;
import ev3.robot.subsystems.BrasSubsystem;
import ev3.robot.subsystems.DriveSubsystem;
import ev3.robot.commands.GyroCommand;
import ev3.robot.commandGroups.AutonomousCommandGroup2;
import ev3.robot.commandGroups.AtrapePixel;

public class AutonomousCommandGroup extends SequentialCommandGroup {

    public AutonomousCommandGroup(DriveSubsystem driveSubsystem, BrasSubsystem brasSubsystem) {

        //ParallelRaceGroup avancer5sec = new DriveAutoCommand(driveSubsystem, 1, 0).withTimeout(5);
        //ParallelRaceGroup tourner1sec = new DriveAutoCommand(driveSubsystem, 0, 1).withTimeout(1);
        //ParallelRaceGroup reculer5sec = new DriveAutoCommand(driveSubsystem, -1, 0).withTimeout(5);
        DriveAutoCommand avancerNbr = new DriveAutoCommand(driveSubsystem, 1, 0, 70);
        //DriveAutoCommand avancerNbr2 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        //DriveAutoCommand avancerNbr3 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        //DriveAutoCommand avancerNbr4 = new DriveAutoCommand(driveSubsystem, 1, 0, 10);
        //GyroCommand tourner90Degre = new GyroCommand(driveSubsystem, 90);
        //GyroCommand tourner90Degre2 = new GyroCommand(driveSubsystem, 90);
        //GyroCommand tourner90Degre3 = new GyroCommand(driveSubsystem, 90);
        //GyroCommand tourner90Degre4 = new GyroCommand(driveSubsystem, 90);
        //GyroCommand tournerMoins360Degre = new GyroCommand(driveSubsystem, -90);
        //AutonomousCommandGroup2 auto = new AutonomousCommandGroup2(driveSubsystem);
        //AtrapePixel atrape = new AtrapePixel(driveSubsystem, brasSubsystem);

        addCommands(
            avancerNbr
            //avancerNbr,
            //avancer5sec,
            //tourner1sec,
            //reculer5sec
        );
    }

}
