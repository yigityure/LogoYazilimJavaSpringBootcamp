package homework.maven.eclipse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Company {
	private String name;
	private String department;
	
	static Map<String, String> companyList = new HashMap<>();
	
	
	
	public Company() {
		
	}
	
	public Company(String name, String department) {
		this.setName(name);
		this.setDepartment(department);
		companyList.put(name, department);
	}
	
	
	
	public void GetDepartmentByLowerAvgPrice(Stream<Receipt> receiptList, int avgPrice) {
		
		Map<String, List<Receipt>> receiptsByCompanyName = receiptList.collect(Collectors.groupingBy(Receipt::getCompanyName));
		
		Map<String, Integer> companies = new HashMap<String, Integer>();
		
		Set<String> keys = receiptsByCompanyName.keySet();
		
		Iterator<String> iterator = keys.iterator();

		
		receiptsByCompanyName.values().stream().forEach(list -> { companies.put(iterator.next(),
											(int) (list.stream().map(rec->rec.getPrice())
												.reduce(0, (total, cur) -> total + cur) 
												/ list.stream().count()));
											});
				
		companies.entrySet().stream().filter(map -> map.getValue() < avgPrice)
			.forEach(map -> System.out.println(companyList.get(map.getKey())));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

}
