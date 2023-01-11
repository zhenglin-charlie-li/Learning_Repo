package USB;

public class LapTop {
    public void powerOn(){
        System.out.println("LapTop power On");
    }

    public void powerOff(){
        System.out.println("LapTop power off");
    }

    public void useDevice(USB device){
        device.open();
        if (device instanceof Mouse){
            Mouse m = (Mouse) device;
            m.click();
        }else if (device instanceof KeyBoard){
            KeyBoard kb = (KeyBoard) device;
            kb.type();
        }
        device.close();
    }

}
