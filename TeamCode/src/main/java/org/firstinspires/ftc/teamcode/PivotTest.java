package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareClasses.Pivot;

@TeleOp(name = "Pivot Test")
public class PivotTest extends LinearOpMode {

    private Pivot pivot;

    @Override
    public void runOpMode() {

        pivot = new Pivot(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            // Check for button presses and set target angles
            if (gamepad1.x) {
                telemetry.addLine("X Pressed");
                pivot.movePivotToAngle(70);  // Move to 0 degrees
            } else if (gamepad1.b) {
                telemetry.addLine("B Pressed");
                pivot.movePivotToAngle(-70);  // Move to 90 degrees
            }

            pivot.update();

            telemetry.addData("Current Angle", pivot.getPivotAngle());
            telemetry.update();
        }
    }
}