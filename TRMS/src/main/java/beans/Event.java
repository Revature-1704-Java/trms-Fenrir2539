package beans;

public class Event {
	
	private int eventId;
	private String eventType;
	private int percentReim;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int eventId, String eventType, int percentReim) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.percentReim = percentReim;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getPercentReim() {
		return percentReim;
	}

	public void setPercentReim(int percentReim) {
		this.percentReim = percentReim;
	}
	
	

}
