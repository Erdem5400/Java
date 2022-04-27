
public class Data {
	private String id;
	private String temparature;
	private String date;
	private String timeBetweenFrames;
	
	Data(String id,String temparature, String date, String timeBetweenFrames) {
		this.id=id;
		this.temparature = temparature;
		this.date = date;
		this.timeBetweenFrames = timeBetweenFrames;
	}
	public String getDatas() {
		return "ID: "+id+" Temparature: " +temparature+ " Date: " +date+ " TimeBetweenFrames: "+timeBetweenFrames;
	}
	
	

}
