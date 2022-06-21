package homework.maven.eclipse;

import java.util.ArrayList;

public class CustomerList {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public CustomerList(Customer customer) {
		customerList.add(customer);
	}
	
	public CustomerList() {
		
	}
	

	public void ShowCustomers() {
		customerList.stream().forEach(customer -> System.out.println(customer.getName()));
	}
	
	public void getCustomersByLetter(CharSequence c) {
		customerList.stream().filter(customer -> customer.getName().toLowerCase().contains(Character.toLowerCase(c.charAt(0))+""))
			.map(customer -> customer.getName())
			.distinct()
			.forEach(System.out::println);
	}

	public void CalculateTotalReceipts(int month) {
		customerList.stream().filter(customer -> (customer.getRegistrationDate().getMonthValue() == month))
			.forEach(customer -> System.out.println(customer.getName() + " " + customer.GetReceipts(customer.getName())));
	}

	

}
