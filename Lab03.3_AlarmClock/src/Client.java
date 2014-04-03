public class Client {
	
	
	 public static void main(String[] args) {
		//create an instance of AlarmClock, referenced as AC1
		 AlarmClock ac1 = new AlarmClock();
		 AlarmClock ac2 = new AlarmClock();
		 ac1.setSnooze(6500);
		 ac1.setAlarmName("Alarm 1");
		 
		 ac1.alarm();
		 ac1.snooze();
		 
		 ac2.setSnooze(6000);
		 ac2.setAlarmName("Alarm 2");
		 
		 ac2.alarm();
		 ac2.snooze();
	
		 Triangle.main(args);
		
	 }
	 
	 
}