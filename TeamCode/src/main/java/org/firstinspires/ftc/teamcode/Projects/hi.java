package org.firstinspires.ftc.teamcode.Projects;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class hi extends Project{
    public DcMotor fLeftWheel = null;
    public DcMotor fRightWheel = null;
    public DcMotor bLeftWheel = null;
    public DcMotor bRightWheel = null;



    public DcMotor baseLift = null;
    public DcMotor firstJointLift = null;
    public Servo firstJointRight = null;
    public Servo firstJointLeft = null;
    public Servo wrist = null;
    public Servo clawLeft = null;
    public Servo clawRight = null;




    @Override
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        fLeftWheel = hwMap.dcMotor.get("fLeftWheel");
        fRightWheel = hwMap.dcMotor.get("fRightWheel");
        bLeftWheel = hwMap.dcMotor.get("bLeftWheel");
        bRightWheel = hwMap.dcMotor.get("bRightWheel");
        baseLift = hwMap.dcMotor.get("elbow");
        firstJointLift = hwMap.dcMotor.get("shoulder");

        wrist = hwMap.servo.get("wrist");
        clawLeft = hwMap.servo.get("leftclaw");
        clawRight = hwMap.servo.get("rightclaw");



        // Motors and facing in to each other
        fRightWheel.setDirection(DcMotor.Direction.FORWARD);
        fLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        bRightWheel.setDirection(DcMotor.Direction.REVERSE);
        bLeftWheel.setDirection(DcMotor.Direction.FORWARD);
        //lift.setDirection(DcMotor.Direction.FORWARD);
        baseLift.setDirection(DcMotor.Direction.FORWARD);
        firstJointLift.setDirection(DcMotor.Direction.FORWARD);
        // intake.setDirection(DcMotor.Direction.FORWARD);
        //lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //liftDos.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        baseLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        firstJointLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        fRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        baseLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        firstJointLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();
    }

    public void Stop(){
        fRightWheel.setPower(0);
        fLeftWheel.setPower(0);
        bRightWheel.setPower(0);
        bLeftWheel.setPower(0);
        clawRight.setPosition(0);
        clawLeft.setPosition(0);
        wrist.setPosition(0);

    }
}
