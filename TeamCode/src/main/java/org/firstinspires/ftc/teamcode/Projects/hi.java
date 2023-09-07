package org.firstinspires.ftc.teamcode.Projects;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class hi extends Project{
     // public DcMotor fLeftWheel = null;
   public DcMotor fLeftWheel = null;
   public DcMotor bLeftWheel = null;
   public DcMotor fRightWheel = null;
   public DcMotor bRightWheel = null;
   public DcMotor leftLift = null;
   public DcMotor rightLift = null;
   public Servo rClaw = null;
   public Servo lClaw = null;


    @Override
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        // fLeftWheel = hwMap.dcMotor.get("fLeftWheel");
       fLeftWheel = hwMap.dcMotor.get("fLeftWheel");
       fRightWheel = hwMap.dcMotor.get("fRightWheel");
       bLeftWheel = hwMap.dcMotor.get("bLeftWheel");
       bRightWheel = hwMap.dcMotor.get("bRightWheel");
       leftLift = hwMap.dcMotor.get("leftLift");
       rightLift = hwMap.dcMotor.get("rightLift");
       rClaw = hwMap.servo.get("rClaw");
       lClaw = hwMap.servo.get("lClaw");



        // Motors and facing in to each other

        //fLeftWheel.setDirection(DcMotor.Direction.REVERSE);

        fLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        fRightWheel.setDirection(DcMotor.Direction.FORWARD);
        bLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        bRightWheel.setDirection(DcMotor.Direction.FORWARD);
        leftLift.setDirection(DcMotor.Direction.REVERSE);
        rightLift.setDirection(DcMotor.Direction.FORWARD);


        //fLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        fLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //fLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();
    }

    public void Stop(){

        //fLeftWheel.setPower(0);

    }
}
