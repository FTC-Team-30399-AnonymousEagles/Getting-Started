package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.DriveTeleopCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeTeleopCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commands.CommandScheduler;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

@TeleOp(name="Command-Based Teleop")
public class teleopCommandBase extends LinearOpMode {
    private CommandScheduler m_scheduler;

    @Override
    public void runOpMode() {

        DriveSubsystem m_drive = new DriveSubsystem(hardwareMap);
        IntakeSubsystem m_intake = new IntakeSubsystem(hardwareMap);

        m_scheduler = new CommandScheduler();
        waitForStart();

        while (opModeIsActive()) {
            m_scheduler.schedule(new DriveTeleopCommand(m_drive, gamepad1));
            m_scheduler.schedule(new IntakeTeleopCommand(m_intake, gamepad1));
            m_scheduler.run();
        }
    }
}
