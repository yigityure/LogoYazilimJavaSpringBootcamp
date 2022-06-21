package homework.maven.eclipse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Receipt {
	
	private int price;
	private String customerName;
	private String companyName;
	private LocalDate date;
	
	public Receipt(int price, String customerName, String companyName) {
		this.setPrice(price);
		this.setCustomerName(customerName);
		this.setCompanyName(companyName);
		
		this.setDate(LocalDate.now());
		
		new ReceiptList(this);
	}


	public Receipt(int price, String customerName, String companyName, String date) {
		this.setPrice(price);
		this.setCustomerName(customerName);
		this.setCompanyName(companyName);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.setDate(LocalDate.parse(date, formatter));
		
		new ReceiptList(this);
	}
	

	public void Show() {
		System.out.println(this.price + this.customerName + this.companyName);
	}

	@Override
	public String toString() {
		return "Receipt [price=" + price + ", customerName=" + customerName + ", companyName=" + companyName + ", date="
				+ date + "]";
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
}
