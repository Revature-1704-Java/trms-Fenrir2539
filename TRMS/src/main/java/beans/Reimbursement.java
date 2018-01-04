package beans;

public class Reimbursement {
	private int reimId;
	private int empId;
	private String eventDate;
	private int eventId;
	private int gradeId;
	private String passingGrade;
	private double empCost;
	private double reimAmount;
	private String location;
	private String description;
	private double workHoursMissed;
	private String status;
	
	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", empId=" + empId + ", eventDate=" + eventDate + ", eventId="
				+ eventId + ", gradeId=" + gradeId + ", passingGrade=" + passingGrade + ", empCost=" + empCost
				+ ", reimAmount=" + reimAmount + ", location=" + location + ", description=" + description
				+ ", workHoursMissed=" + workHoursMissed + ", status=" + status + "]";
	}

	public Reimbursement(int reimId, int empId, String eventDate, int eventId, int gradeId, String passingGrade,
			double empCost, double reimAmount, String location, String description, double workHoursMissed,
			String status) {
		super();
		this.reimId = reimId;
		this.empId = empId;
		this.eventDate = eventDate;
		this.eventId = eventId;
		this.gradeId = gradeId;
		this.passingGrade = passingGrade;
		this.empCost = empCost;
		this.reimAmount = reimAmount;
		this.location = location;
		this.description = description;
		this.workHoursMissed = workHoursMissed;
		this.status = status;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public double getEmpCost() {
		return empCost;
	}

	public void setEmpCost(double empCost) {
		this.empCost = empCost;
	}

	public double getReimAmount() {
		return reimAmount;
	}

	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWorkHoursMissed() {
		return workHoursMissed;
	}

	public void setWorkHoursMissed(double workHoursMissed) {
		this.workHoursMissed = workHoursMissed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
