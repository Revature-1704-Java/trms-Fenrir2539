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
	private int gradeApprovalSupervis;
	private int gradeApprovalBenco;
	private String workJust;
	private String denyJust;
	private String exceedJust;
	private String dateCreated;
	private String timeCreated;
	private String lastUpdate;
	private int approvalSuper;
	private int approvalDeptHead;
	private int approvalBenco;
	
	public Reimbursement(int reimId, int empId, String eventDate, int eventId, int gradeId, String passingGrade,
			double empCost, double reimAmount, String location, String description, double workHoursMissed,
			String status, int gradeApprovalSupervis, int gradeApprovalBenco, String workJust, String denyJust,
			String exceedJust, String dateCreated, String timeCreated, String lastUpdate, int approvalSuper,
			int approvalDeptHead, int approvalBenco) {
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
		this.gradeApprovalSupervis = gradeApprovalSupervis;
		this.gradeApprovalBenco = gradeApprovalBenco;
		this.workJust = workJust;
		this.denyJust = denyJust;
		this.exceedJust = exceedJust;
		this.dateCreated = dateCreated;
		this.timeCreated = timeCreated;
		this.lastUpdate = lastUpdate;
		this.approvalSuper = approvalSuper;
		this.approvalDeptHead = approvalDeptHead;
		this.approvalBenco = approvalBenco;
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

	public int getGradeApprovalSupervis() {
		return gradeApprovalSupervis;
	}

	public void setGradeApprovalSupervis(int gradeApprovalSupervis) {
		this.gradeApprovalSupervis = gradeApprovalSupervis;
	}

	public int getGradeApprovalBenco() {
		return gradeApprovalBenco;
	}

	public void setGradeApprovalBenco(int gradeApprovalBenco) {
		this.gradeApprovalBenco = gradeApprovalBenco;
	}

	public String getWorkJust() {
		return workJust;
	}

	public void setWorkJust(String workJust) {
		this.workJust = workJust;
	}

	public String getDenyJust() {
		return denyJust;
	}

	public void setDenyJust(String denyJust) {
		this.denyJust = denyJust;
	}

	public String getExceedJust() {
		return exceedJust;
	}

	public void setExceedJust(String exceedJust) {
		this.exceedJust = exceedJust;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getApprovalSuper() {
		return approvalSuper;
	}

	public void setApprovalSuper(int approvalSuper) {
		this.approvalSuper = approvalSuper;
	}

	public int getApprovalDeptHead() {
		return approvalDeptHead;
	}

	public void setApprovalDeptHead(int approvalDeptHead) {
		this.approvalDeptHead = approvalDeptHead;
	}

	public int getApprovalBenco() {
		return approvalBenco;
	}

	public void setApprovalBenco(int approvalBenco) {
		this.approvalBenco = approvalBenco;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", empId=" + empId + ", eventDate=" + eventDate + ", eventId="
				+ eventId + ", gradeId=" + gradeId + ", passingGrade=" + passingGrade + ", empCost=" + empCost
				+ ", reimAmount=" + reimAmount + ", location=" + location + ", description=" + description
				+ ", workHoursMissed=" + workHoursMissed + ", Status=" + status + ", gradeApprovalSupervis="
				+ gradeApprovalSupervis + ", gradeApprovalBenco=" + gradeApprovalBenco + ", workJust=" + workJust
				+ ", denyJust=" + denyJust + ", exceedJust=" + exceedJust + ", dateCreated=" + dateCreated
				+ ", timeCreated=" + timeCreated + ", lastUpdate=" + lastUpdate + ", approvalSuper=" + approvalSuper
				+ ", approvalDeptHead=" + approvalDeptHead + ", approvalBenco=" + approvalBenco + "]";
	}
	
	
}
