package beans;

public class Employee {

	private int eid;
	private String firstName;
	private String LastName;
	private int empType;
	private int department;
	private int reportsTo;
	
	public Employee(int eid, String firstName, String lastName, int empType, int department, int reportsTo) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		LastName = lastName;
		this.empType = empType;
		this.department = department;
		this.reportsTo = reportsTo;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", LastName=" + LastName + ", empType=" + empType
				+ ", department=" + department + ", reportsTo=" + reportsTo + "]";
	}
	
	
	
	
	
}
