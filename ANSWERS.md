### 1. Soru

Java içerisinde JVM(sanal makina) barındırdığı için platform bağımlı değildir.
Bu sayede Java platforma ihtiyaç duymadan kendi sanal makinası üzerinde gerekli dönüşümleri yapabilir.

### 2. Soru

Çoklu kalıtımda, bir sınıf kendisine ait başka sınıflar türetebilir. Ancak Java bunu desteklemez. Java'da bir sınıf sadece bir sınıf türetebilir.
Bir A sınıfı olsun. A sınıfı eğer B ve C sınıflarını türetirsin. D sınıfı da B ve C sınıflarından türetilsin.
Eğer A sınıfındaki bir metot, B ve C sınıflarında override edilirse; D sınıfı hangi sınıfın (B veya C) metodununu kullanacağını bilemez ve belirsizlik oluşur.
Bu durumun önüne geçmek için Java Interface'leri kullanır.

C++ çoklu kalıtım kullanan bir dildir. C++ belirsizliği önlemek için, türetilen sınıfın ebeveny sınıflarının yapıcı metodlarını kendisine verilen sırayla çağırır.

### 3. Soru

Build tool, kaynak kodlarının çalıştırılabilir bir dosya haline dönüştürülmesini sağlayan araçtır (örneğin .exe).
Dönüşüm yapılırken gerekli kütüphaneler yüklenir, kaynak kod makina diline derlenir, ardından paketlenir.

Java için kullanılan build toollardan en bilinenleri; Ant, Maven ve Gradle'dır.

### 4. Soru

Collections frameworklerinin en önemli özelliği arraylarin aksine eleman sınırlaması olmamasıdır. Bir array tanımlarken aynı anda eleman sayısı da belirtilmelidir.
Collections frameworkleri bu durumun önüne geçer ve dinamik bir array sunar.

Collections framework -> List, Queue, Set
Hepsi birer interface'dir.

List

    List; istenilen herhangi bir tipte dinamik bir liste oluşturulmasını sağlar. Tekrar eden elemanlar olabilir.

    List<Integer> list1 = new ArrayList<Integer>();
    List<String> list2 = new LinkedList<String>();
    List<List<String>> list3 = new Vector<List<String>>();
    List<List<Integer>> list4 = new Stack<List<Integer>>();

    Implement edilebilecek sınıflar => List -> ArrayList, LinkedList, Vector, Stack

      ArrayList
        ArrayList; dinamik bir array oluşturmak için kullanılır. Elemanlar eklenen sırayla tutulur.

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        arratList.add("Four");

        Iterator itr = arrayList.iterator();
        while(itr.hasNext()) {
           System.out.println(itr.next());
        }

        Çıktı:
            One
            Two
            Three
            Four


      LinkedList
        LinkedList; ArrayList'in özelliklerine sahiptir. Elemanları listeye eklerken container oluşturur ve elemanı container'a ekler. Containerlar birbirine bağlanır.

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        linkedList.add("Four");

        Iterator itr = linkedList.iterator();
        while(itr.hasNext()) {
           System.out.println(itr.next());
        }

         Çıktı:
            One
            Two
            Three
            Four


      Vector
        Vector; ArrayList'e benzer. Fazladan kendine ait metodları vardır.

        Vector<String> vector = new Vector<String>();
        vector.add("One");
        vector.add("Two");
        vector.add("Three");
        vector.add("Dour");

        Iterator itr = vector.iterator();
        while(itr.hasNext()) {
           System.out.println(itr.next());
        }

         Çıktı:
            One
            Two
            Three
            Four

      Stack
        Stack; Vector sınıfının alt sınıfıdır. Last-in-first-out yapısındadır.

        Stack<String> stack = new Stack<String>();
        stack.add("One");
        stack.add("Two");
        stack.add("Three");
        stack.add("Four");
        stack.pop();

        Iterator itr = stack.iterator();
        while(itr.hasNext()) {
           System.out.println(itr.next());
        }

         Çıktı:
            One
            Two
            Three
            Four

Queue

    Queue; first-in-first-out yapısında bir interface'dir.

    Queue<String> queue1 = new PriorityQueue();
    Queue<String> queue2 = new ArrayDeque();

    Implement edilebilecek sınıflar => Queue -> PriorityQueue, ArrayDeque

      PriorityQueue
        PriorityQueue; önceliğe göre elemanlarını sıralayan bir sınıftır. null değer barındırmaz.

        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("One");
        priorityQueue.add("Two");
        priorityQueue.add("Three");
        priorityQueue.add("Four");
        System.out.println(priorityQueue.element());
        System.out.println(priorityQueue.peek());

        Iterator itr = priorityQueue.iterator();
        while(itr.hasNext()){
           System.out.println(itr.next());
        }
        priorityQueue.remove();
        priorityQueue.poll();

        Iterator<String> itr2 = priorityQueue.iterator();
        while(itr2.hasNext()){
           System.out.println(itr2.next());
        }

        Çıktı:
            Four
            Four
            Four
            One
            Three
            Two
            Three
            Two


      Deque
        Deque; Queue interface'inden türeyen bir interface'dir. Listenin hem başından hem de sonundan işlem yapabilme olanağı sağlar.

        Deque deque = new ArrayDeque();

      ArrayDeque
        ArrayDeque; Deque interface'ini kullanabilmeyi sağlayan sınıftır.

        Deque<String> arrayDeque = new ArrayDeque<String>();
        arrayDeque.add("One");
        arrayDeque.add("Two");
        arrayDeque.add("Three");
        arrayDeque.add("Four");

        for (String str : arrayDeque) {
           System.out.println(str);
        }

         Çıktı:
            One
            Two
            Three
            Four

Set

    Set; tekrarlanamayan elemanları içeren listedir. Interface'dir.

    Set<String> s1 = new HashSet<String>();
    Set<String> s2 = new LinkedHashSet<String>();
    Set<String> s3 = new TreeSet<String>();

    Implement edilebilecek sınıflar => Set -> HashSet, LinkedHashSet, TreeSet

        HashSet
          HashSet; depolamak için hash tablosunu kullanır.

          HashSet<String> hashSet = new HashSet<String>();
          hashSet.add("One");
          hashSet.add("Two");
          hashSet.add("Three");
          hashSet.add("One");
          hashSet.add("Four");

          for (String str : hashSet) {
            System.out.println(str);
          }

          Çıktı:
             One
             Four
             Two
             Three


        LinkedHashSet
          LinkedHashSet; LinkedList sınıfının Set interface'i ile kullanılmasıdır. Tekrarlayan eleman barındırmaz, null değer almaz.

          LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
          linkedHashSet.add("One");
          linkedHashSet.add("Two");
          linkedHashSet.add("Three");
          linkedHashSet.add("One");
          linkedHashSet.add("Four");

          for (String str : linkedHashSet) {
            System.out.println(str);
          }

          Çıktı:
             One
             Two
             Three
             Four


        SortedSet
          SortedSet; Set interface'inden türetilmiştir. Elemanların büyükten küçüğe ya da küçükten büyüğe sıralanması için kullanılır.

          SortedSet<String> set = new TreeSet();

        TreeSet
          TreeSet; depolamak için ağaç yapısını kullanır. Bu sayede çok daha hızlı arama sonucu sağlar. Elemanlar küçükten büyüğe doğru sıralanır.

          TreeSet<String> treeSet = new TreeSet<String>();
          treeSet.add("One");
          treeSet.add("Two");
          treeSet.add("Three");
          treeSet.add("One");
          treeSet.add("Four");

          for (String str : treeSet) {
            System.out.println(str);
          }

          Çıktı:
             Four
             One
             Three
             Two

### 5. Soru

Main

```Java
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
     System.out.println("-------Şirketlerin ilk parametre olarak girilen aydaki faturalarının ortalamasının, ikinci parametre olarak girilen değerden düşük olan şirketlerin sektörü---------\n");
     receiptList.GetDepartmentByLowerAvgReceipt(6, 750);
 }
```

Çıktı

```
-------Tüm müşteriler---------

Ahmet Çelik
Soner Sağlam
Sezen Kaya
Merve Yılmaz
Okan Kara
Cansu Aydın


-------İçerisinde parametre olarak girilen harf olan müşterilerin listesi---------

Cansu Aydın


-------Parametre olarak girilen ayda kayıt olanlar ve toplam harcamaları---------

Soner Sağlam 2300
Sezen Kaya 1550
Okan Kara 1480
Cansu Aydın 1250


-------Tüm faturalar---------

Receipt [price=580, customerName=Okan Kara, companyName=Eti, date=2022-05-17]
Receipt [price=1400, customerName=Büşra Eren, companyName=Beko, date=2022-03-16]
Receipt [price=1700, customerName=Büşra Eren, companyName=Logo, date=2022-06-15]
Receipt [price=1950, customerName=Soner Sağlam, companyName=Arçelik, date=2022-06-15]
Receipt [price=1650, customerName=Ahmet Çelik, companyName=Arçelik, date=2022-06-15]
Receipt [price=150, customerName=Ahmet Çelik, companyName=Eti, date=2022-06-15]
Receipt [price=450, customerName=Ahmet Çelik, companyName=Eti, date=2022-05-10]
Receipt [price=350, customerName=Soner Sağlam, companyName=Logo, date=2022-04-30]
Receipt [price=1550, customerName=Sezen Kaya, companyName=Beko, date=2022-06-15]
Receipt [price=1050, customerName=Merve Yılmaz, companyName=Eti, date=2022-06-15]
Receipt [price=900, customerName=Okan Kara, companyName=Arçelik, date=2022-05-03]
Receipt [price=1250, customerName=Cansu Aydın, companyName=Logo, date=2022-06-15]


-------Parametre olarak girilen değerden yüksek tüm faturalar---------

Receipt [price=1700, customerName=Büşra Eren, companyName=Logo, date=2022-06-15]
Receipt [price=1950, customerName=Soner Sağlam, companyName=Arçelik, date=2022-06-15]
Receipt [price=1650, customerName=Ahmet Çelik, companyName=Arçelik, date=2022-06-15]
Receipt [price=1550, customerName=Sezen Kaya, companyName=Beko, date=2022-06-15]


-------Parametre olarak girilen değerden yüksek tüm faturaların ortalaması---------

1712


-------Parametre olarak girilen değerden düşükk bir faturaya sahip olan müşteriler---------

Ahmet Çelik
Soner Sağlam


-------Şirketlerin ilk parametre olarak girilen aydaki faturalarının ortalamasının, ikinci parametre olarak girilen değerden düşük olan şirketlerin sektörü---------

Gıda
```
