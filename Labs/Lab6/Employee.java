class Employee extends Person{

	double salary = 0;
	Date startDate;//check how to

	public Employee(String lName,String fName, Date bDate, double sal, Date sDate){
		super(lName, fName, bDate);
		salary = sal;
		startDate = sDate;
	} 

	public double getSalary(){
		return salary;
	}

	public Date getStartDate(){
		return startDate;
	}

	public void setSalary(double sal){
		salary = sal;
	}

	public void setStartDate(Date sDate){
		startDate = sDate;
	}

	public String toString(){
		String personInfo = "name = " +  super.getLastName()+", "+super.getFirstName()+"\n";
		personInfo += "salary = "+salary+"\n";
		personInfo += "birth = "+super.getBirthDate()+"\n";
		personInfo += "hired = "+startDate+"\n";
		return personInfo;
	}


}
