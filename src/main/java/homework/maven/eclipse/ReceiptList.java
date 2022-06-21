package homework.maven.eclipse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReceiptList {
	
	static List<Receipt> receiptList = new ArrayList<Receipt>();
	
	public ReceiptList(Receipt receipt) {
		receiptList.add(receipt);
	}
	
	public ReceiptList() {
		
	}
	
	public void ShowReceipts() {
		receiptList.stream().forEach(receipt -> System.out.println(receipt.toString()));
	}

	public void ShowReceiptsByHigherPrice(int price) {
		receiptList.stream().filter(receipt -> (receipt.getPrice() > price))
			.forEach(receipt -> System.out.println(receipt.toString()));
	}
	
	
	public void CalculateAvgByPrice(int price) {
		long sum = receiptList.stream().filter(receipt -> (receipt.getPrice() > price))
			.map(receipt -> receipt.getPrice())
			.reduce(0, (total, receipt) -> total + receipt);
		long count = receiptList.stream().filter(receipt -> (receipt.getPrice() > price)).count();
		System.out.println(count == 0 ? "Girilen fiyattan yüksek bir fatura bulunamadı." : sum / count);
	}
	
	public void GetCustomersByLowerPrice(int price) {
		receiptList.stream().filter(receipt -> (receipt.getPrice() < price))
			.map(receipt -> receipt.getCustomerName())
			.distinct()
			.forEach(System.out::println);
	}
	
	public void GetDepartmentByLowerAvgReceipt(int month, int avgPrice) {
		Stream<Receipt> listByMonth = receiptList.stream().filter(receipt -> (receipt.getDate().getMonthValue() == month));
		Company company = new Company();
		company.GetDepartmentByLowerAvgPrice(listByMonth, avgPrice);
	}

	public Integer GetReceipt(String name) {
		return receiptList.stream().filter(receipt -> (receipt.getCustomerName() == name))
			.map(receipt -> receipt.getPrice())
			.reduce(0, (total, cur) -> total + cur);
	}
}
