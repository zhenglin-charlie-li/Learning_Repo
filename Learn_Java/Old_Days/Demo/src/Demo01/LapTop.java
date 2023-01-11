package Demo01;

public class LapTop {
	
	public void poweron() {
		System.out.println("LapTop power on");
	}
	
	public void poweroff() {
		System.out.println("LapTop power off");
	}
	
	public void useDevice(USB inUsb) {
		
		if(inUsb instanceof Mouse) {
			Mouse m = (Mouse) inUsb;
			m.open();
			m.click();
			m.close();
		}else if(inUsb instanceof KeyBoard) {
			KeyBoard kb = (KeyBoard) inUsb;
			kb.open();
			kb.type();
			kb.close();
		}
	}

}
