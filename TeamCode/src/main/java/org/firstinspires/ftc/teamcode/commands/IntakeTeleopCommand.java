package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class IntakeTeleopCommand extends CommandBase {
    IntakeSubsystem m_intake;
    Gamepad gamepad1;

    public IntakeTeleopCommand(IntakeSubsystem m_intake, Gamepad gamepad1) {
        this.m_intake = m_intake;
        this.gamepad1 = gamepad1;
    }

    @Override
    public void initialize() {
        m_intake.runIntake(gamepad1.right_trigger, gamepad1.left_trigger);
    }
}
