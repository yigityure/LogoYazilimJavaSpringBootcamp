package homework.maven.eclipse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {

	private String name;
	private int id;
	private LocalDate registrationDate;
	
	public Customer(String name, int id) {
		this.setName(name);
		this.setId(id);
		this.setRegistrationDate(LocalDate.now());
		
		new CustomerList(this);
	}
	
	public Customer(String name, int id, String date) {
		this.setName(name);
		this.setId(id);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.setRegistrationDate(LocalDate.parse(date, formatter));

        new CustomerList(this);
	}
	
	public void ShowAll() {
		System.out.println(name);
	}
	
	public Integer GetReceipts(String name) {
		ReceiptList receiptList = new ReceiptList();
		return receiptList.GetReceipt(name);
	}


	public Receipt Payment(int price, String companyName) {
		Receipt receipt = new Receipt(price, this.name, companyName);
		return receipt;
	}
	
	public Receipt Payment(int price, String companyName, String date) {
		Receipt receipt = new Receipt(price, this.name, companyName, date);
		return receipt;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
