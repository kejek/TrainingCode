import java.util.Timer;
import java.util.TimerTask;

class AlarmClock {
	//INSTANCE VARIABLES
	private int snoozeInterval = 1;
	private String alarmName = "Unnamed Alarm";
	
	
	
	
	
	//METHODS
	public void snooze(){
		System.out.println("Snoozing " + this.alarmName + " for " + this.snoozeInterval +"ms...");
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() { public void run() {alarm();} }, snoozeInterval);
	}
	
	public void alarm(){
		System.out.println(this.alarmName + " - RING RING RING!");
		
		
	}
	
	public void setSnooze(int snoozeInterval){
		boolean valid = false;
		valid = validateSnooze(snoozeInterval);
		if (valid){
			this.snoozeInterval = snoozeInterval;
		}
		else{
			System.out.println(snoozeInterval + " is not a positive number.");
		}
	}
	
	public int getSnooze(){
		return this.snoozeInterval;
	}
	
	public void setAlarmName(String alarmName){
		this.alarmName = alarmName;
	}
	
	public String getAalarmName(){
		return this.alarmName;
	}
	
	private boolean validateSnooze(int snoozeInterval){
		if (snoozeInterval > 0 && snoozeInterval < 10000){
			return true;
		}
		else{
			return false;
		}
			
	}
}
