package homework.maven.eclipse;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private int departmentNo;
	
	static List<Department> departmentList = new ArrayList<Department>();
	
	public Department(String name, int no) {
		this.name = name;
		this.departmentNo = no;
		departmentList.add(this);
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

}
