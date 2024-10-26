package org.firstinspires.ftc.teamcode.HardwareClasses;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DepositGripper {
    private final Servo clawServo;
    private final Servo rollServo;
    private final Servo pitchServo;
    private final Servo pitchArmServo;

    public DepositGripper(HardwareMap hardwareMap) {
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        rollServo = hardwareMap.get(Servo.class, "rollServo");
        pitchServo = hardwareMap.get(Servo.class, "pitchServo");
        pitchServo.setDirection(Servo.Direction.FORWARD);
        pitchArmServo = hardwareMap.get(Servo.class, "pitchArmServo");
    }

    public void CloseGripper() {
        clawServo.setPosition(0.5);
    }

    public void OpenGripper() {
        clawServo.setPosition(0.3);
    }

    public void rotateGripperToPos(double pos) {
        rollServo.setPosition(pos);
    }

    public void pitchGripperToPos(double pos) {
        pitchServo.setPosition(pos);
    }

    public void pitchArmToPos(double pos) {
        pitchArmServo.setPosition(pos);
    }

    public void grabSpecimen() {
        rollServo.setPosition(0.0);
        pitchServo.setPosition(0.0);
        pitchArmServo.setPosition(0.0);
    }

    public void placeSample() {
        rollServo.setPosition(0.0); // 0.7 = halfway
        pitchServo.setPosition(0.5);
        pitchArmServo.setPosition(0.5);
    }

    public void placeSpecimen() {
        rollServo.setPosition(0.7); // 0.7 = halfway
        pitchServo.setPosition(0);
        pitchArmServo.setPosition(0.65);
    }
}