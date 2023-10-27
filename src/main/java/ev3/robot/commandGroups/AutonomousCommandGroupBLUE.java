package ev3.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import ev3.robot.commands.AvanceAutoCommand;
import ev3.robot.commands.TournerDroiteCommand;
import ev3.robot.commands.TournerGaucheCommand;
import ev3.robot.subsystems.DriveSubsystem;

public class AutonomousCommandGroupBLUE extends SequentialCommandGroup {

    public AutonomousCommandGroupBLUE(DriveSubsystem driveSubsystem) {

        AvanceAutoCommand avancer4cm = new AvanceAutoCommand(driveSubsystem, 1, 100.0);
        TournerGaucheCommand tournerGauche = new TournerGaucheCommand(driveSubsystem, 1, 90);

        addCommands(
            avancer4cm,
            tournerGauche,
            avancer4cm
        );
    }

}
