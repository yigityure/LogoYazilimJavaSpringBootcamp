package homework.maven.eclipse;

public class App 
{
    public static void main( String[] args )
    {
        ReceiptList receiptList = new ReceiptList();
        CustomerList customerList = new CustomerList();


        // Şirket oluşturma
        new Company("Logo", "Yazılım");
        new Company("Eti", "Gıda");
        new Company("Beko", "Teknoloji");
        new Company("Arçelik","Teknoloji");
        
        // Müşteri oluşturma
        Customer customer = new Customer("Ahmet Çelik", 1, "05/03/2022");
        Customer customer1 = new Customer("Soner Sağlam", 2);
        Customer customer2 = new Customer("Sezen Kaya", 3);
        Customer customer3 = new Customer("Merve Yılmaz", 4, "27/02/2022");
        Customer customer4 = new Customer("Okan Kara", 5);
        Customer customer5 = new Customer("Cansu Aydın", 6);
        
        // Müşteriden bağımsız fatura oluşturabilme
        new Receipt(580, "Okan Kara", "Eti", "17/05/2022");
        new Receipt(1400, "Büşra Eren", "Beko", "16/03/2022");
        new Receipt(1700, "Büşra Eren", "Logo");
        new Receipt(1950, "Soner Sağlam", "Arçelik");
        
        // Müşterilerin fatura oluşturması
        customer.Payment(1650, "Arçelik");
        customer.Payment(150, "Eti");
        customer.Payment(450, "Eti", "10/05/2022");
        customer1.Payment(350, "Logo", "30/04/2022");
        customer2.Payment(1550, "Beko");
        customer3.Payment(1050, "Eti");
        customer4.Payment(900, "Arçelik", "03/05/2022");
        customer5.Payment(1250, "Logo");
        
        
        System.out.println("-------Tüm müşteriler---------\n");
        customerList.ShowCustomers();
        
        System.out.println("\n");
        System.out.println("-------İçerisinde parametre olarak girilen harf olan müşterilerin listesi---------\n");
        customerList.getCustomersByLetter("c");
        
        System.out.println("\n");
        System.out.println("-------Parametre olarak girilen ayda kayıt olanlar ve toplam harcamaları---------\n");
        customerList.CalculateTotalReceipts(6);
        
        System.out.println("\n");
        System.out.println("-------Tüm faturalar---------\n");
        receiptList.ShowReceipts();
        
        System.out.println("\n");
        System.out.println("-------Parametre olarak girilen değerden yüksek tüm faturalar---------\n");
        receiptList.ShowReceiptsByHigherPrice(1500);
        
        System.out.println("\n");
        System.out.println("-------Parametre olarak girilen değerden yüksek tüm faturaların ortalaması---------\n");
        receiptList.CalculateAvgByPrice(1500);
        
        System.out.println("\n");
        System.out.println("-------Parametre olarak girilen değerden düşük bir faturaya sahip olan müşteriler---------\n");
        receiptList.GetCustomersByLowerPrice(500);
        
        System.out.println("\n");
        System.out.println("-------Şirketlerin ilk parametre olarak girilen aydaki faturalarının ortalamasının,"
        		+ " ikinci parametre olarak girilen değerden düşük olan şirketlerin sektörü---------\n");
        receiptList.GetDepartmentByLowerAvgReceipt(6, 750);   
        
    
    }
}
