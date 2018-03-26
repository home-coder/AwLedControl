package com.xiaolj.awledcontrol;

/**
 * Created by jiangxj on 18-3-26.
 */

public class AwLedController {
    public static byte    LEDS_EFFECT_NONE = 0;
    public static byte    LEDS_EFFECT_STARTUP = 1;                   /*board power on*/
    public static byte    LEDS_EFFECT_COMPLETE = 2;                  /*board startup over*/
    public static byte    LEDS_EFFECT_AIRKISS_MODE = 3;              /*in airkiss mode*/
    public static byte    LEDS_EFFECT_AIRKISS_CONFIG = 4;            /*config airkiss*/
    public static byte    LEDS_EFFECT_AIRKISS_CONNECT = 5;           /*airkiss connected*/
    public static byte    LEDS_EFFECT_WAKE_UP = 6;                   /*voice wake up*/
    public static byte    LEDS_EFFECT_COMMAND_FAIL = 7;              /*voice command failed*/
    public static byte    LEDS_EFFECT_COMMAND_SUCCESS = 8;           /*voice command success*/
    public static byte    LEDS_EFFECT_KEYMUTE = 9;                   /*key mute record*/
    public static byte    LEDS_EFFECT_KEYUNMUTE = 10;                /*key cancel mute record*/
    public static byte    LEDS_EFFECT_BRIGHT_CHANGE = 11;
    public static byte    LEDS_EFFECT_COLOR_CHANGE = 12;
    public static byte    LEDS_EFFECT_IMAX_CHANGE = 13;
    public static byte    LEDS_EFFECT_TOTAL = 14;

    private AwLedController(){}
    private static AwLedController awLedController;
    public static AwLedController getInstance(){
        if(awLedController == null){
            awLedController = new AwLedController();
        }
        return awLedController;
    }

    static {
        System.loadLibrary("awledcontrol");
        System.loadLibrary("jni_awled");
    }

    public native void AwledcontrollerInit();
    public native void AwledcontrollerSetState(byte state);
}