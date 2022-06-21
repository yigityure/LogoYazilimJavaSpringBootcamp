### 1. Soru

Frameworklerin temel amacı; geliştiricinin kod yazarken detaylara inmeden, framework içinde tanımlanan metotları kullanarak projenin iş planına odaklanamasını sağlayan yardımcı araçlardır. Örneğin, test ile ilgili bir framework kullanırken, kullanıcı framework ile birlikte tanımlanan metotları kullanrak daha hızlı ve kesin sonuçlara ulaşabilir.

Java için oluşturulan frameworklerden bazıları şunlardır;

- Spring

  Spring frameworkü geliştiricilere, projeyi oluştururken bağımlılıklara takılmadan kod yazma imkanı sunar. Spring kendi içerisinde bağımlılıkları birbirlerine entegre eden kod parçaları sunar. Bu sayede geliştirici bağımlılıklarla uğraşmaz.

  Spring bu bağımlılıklarla uğraşmak için "Bean" adı verilen nesneler kullanır. Bean aracılığıyla katmanlar arası iletişim ve bağımlılık kolayca halledilir.

  Kişi isminde bir sınıf oluşturalım.

  ```Java
    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // getters and setters
    }
  ```

  Öğrenci isminde, Kişi sınıfını kullanan bir sınıf oluşturalım.

  ```Java
    public class Student {
        private Person person;

        public Student(Person person) {
            this.person = person;
        }

        // getters and setters
    }
  ```

  Bu sınıfların yapıcı metotlarını çağırırsak;

  ```Java
    Person person = new Person("Koray", 18);
    Student student = new Student(person);
  ```

  Eğer projede çok fazla sınıf olursa, bu işlemi herbir sınıf için her seferinde tekrar etmemiz gerekir. Bazen tek bir instance oluşturmak bile işimizi görebilir. Sürekli bu instanceları oluşturmamak için Spring bize bağımlılıkları kendi halleden "Bean" objesini sunuyor.

  Bean'i uygulamak için Öğrenci sınıfımıza @Component annotaition'ını uygulayalım.

  ```Java
    @Component
    public class Student {
        private Person person;

        public Student(Person person) {
            this.person = person;
        }

        // getters and setters
    }
  ```

  Bean verisini tutan bir Config sınıfı oluşturalım.

  ```Java
    @Configuration
    @ComponentScan(basePackageClasses = Student.class)
    public class Config {
        @Bean
        public Person getPerson() {
            return new Person("Koray", 18);
        }
    }
  ```

  Config sınıfı Kişi tipinde bir bean oluşturur. Öğrenci sınıfını bulması için @ComponentScan isimli bir annotation kullanır. Böylece Spring, Öğrenci sınıfı için oluşturduğu bu beani sürekli kullanabilir.

  Beani kullanabilmek için Spring'in sunduğu bir instance tanımını kullanalım.

  ```Java
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
  ```

  Böylece her Öğrenci sınıfı çağrımında, instance oluşturmak yerine oluşturduğumuz beani kullanabiliriz.

  ```Java
    Student student = context.getBean("student", Student.class);
  ```

### 2. Soru

Katmanlı mimarinin özelliği her işin başka katmanda yapılmasına dayanır. Bir web sitesini ele alacak olursak; son kullanıcının veritabanı ile ilgili bir bilgiye ulaşmasını istemeyiz. Bu yüzden son kullanıcının veritabanına ulaşımını kesebilmek için katmanlı mimari kullanırız. En üst katmanda son kullanıcının girdilerini ve çıktılarını içeren bir katman bulunur. En altta ise veritabanındaki bilgiler ile ilgili bir katman bulunur. Bu iki katman arasında da iletişimi sağlamak için başka katmanlar ekleriz. Bu katmanların herbiri kendi işini yapar ve diğer katmanlar hakkında bir bilgiye sahip olmaz. Böylece bağımlılık azalır ve daha mantıksal bir mimari oluşturulmuş olur.

### 3. Soru

Garbage collector bir temizleme aracıdır. JVM içinde bulunur ve zamanla, bellekte gereksiz yere işgal edilen verileri temizler. Bu veriler genellikle heapte oluşturulan nesne tanımlamalarıdır. Nesneler kullanıldıktan sonra temizlenmesi gerekir ki bellekte yer kaplamasınlar.

Garbage collector nesneleri temizlemeye başlarken JVM'in yerleştirmesine göre temizlik yapar. JVM'in yerleştirmesi demek nesneleri belli bir bölgeye yerleştirmesidir. Bu bölgeler 3'e ayrılır.

1. Young Generation

   JVM, tüm oluşturulan nesneleri bu bölümde tutar. Her nesne için bir yaşama süresi tanımlanır. Eğer bu süre içerisinde nesne bir daha kullanılmazsa garbage collector tarafından toplanır. Toplanmayanlar ise bir sonraki bölüme, yani old generation'a akratılır.

2. Old Generation

   Uzun süre young generation'da kullanılan nesneler burada tutulur. Dolduğunda garbage collactor toplamaya başlar.

3. Permanent Generation

   JVM tarafından gerekli görülen sınıflar ve metotlar burada tutulur.

JVM'deki garbage collector ile C++'daki garbage collector arasında basit ama önemli bir fark vardır. Bu fark geliştiricinin garbage collector'ı kontrol edebilmesidir. JVM'de garbage collector otomatik çalışırken, C++'da komutlarla yönetilir. Garbage collector'ı komutlarla yönetmek, donanıma daha hakim olmamızı sağlar. İstediğimiz verileri istediğimiz zaman belekten temizleyip, programın daha hızlı çaşılması için optimize edebiliriz.

### 4. Soru

1. Factory Pattern

   Nesneleri oluştururken bir interface üzerinden oluştururuz. Ata sınıf oluşturup, kalıtım uygulamaktansa; bir interface oluşturup, alt sınıflarımızı bu interface üzerinden tanımlarız.

   Örneğin kedi interface'i oluşturalım.

   ```Java
    public interface Cat {
        void speed();
    }
   ```

   Kedi interface'ini bir ata sınıf olarak kabul edelim. Bu interface üzerinden aslan ve çita adında iki alt sınıf oluşturalım.

   ```Java
    public class Lion implements Cat {

        @Override
        public void speed() {
            System.out.println("Lion's speed: 50");
        }
    }
   ```

   ```Java
    public class Cheetah implements Cat {

        @Override
        public void speed() {
            System.out.println("Cheetah's speed: 100");
        }
    }
   ```

   Factory desing'ı oluşturan factory sınıfını oluşturalım. Bu sınıf interface'i ve alt sınıfları içinde barındıran bir sınıf olacak.

   ```Java
    public class CatFactory {

        public Cat getSpeed(String cat){
            if(cat == null){
                return null;
            }

            if(cat.equalsIgnoreCase("LION")){
                return new Lion();

            } else if(cat.equalsIgnoreCase("CHEETAH")){
                return new Cheetah();

            }

        return null;
        }
    }
   ```

   Artık istediğimiz sınıftan nesne oluşturabiliriz.

   ```Java
    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();

        Cat cat1 = catFactory.getSpeed("LION");
        cat1.speed();

        Cat cat2 = catFactory.getSpeed("CHEETAH");
        cat2.speed();
    }
   ```

   Çıktısına bakacak olursak;

   ```
    Lion's speed: 50
    Cheetah's speed: 100
   ```

2. Abstract Factory

   Abstract factory, factory design pattern'in bir üst halidir. Artık interface bir sınıf üretmek yerine factory üretir.

   Önceki örnekten devam edelim. Aynı örneğe birkaç ekleme yapalım. Artık CatFactory sınıfımızın yanında bir de SouthAfricanCatFactory sınıfı olsun. Yeni sınıflarımızı aynı CatFactory sınıfında olduğu gibi Cat interface'i üzerinden oluşturacağız.

   Interface'imizi, Lion, Cheetah, SouthAfricanLion ve SouthAfricanCheetah sınıflarını oluşturalım.

   ```Java
    public interface Cat {
        void speed();
    }
   ```

   ```Java
    public class Lion implements Cat {

        @Override
        public void speed() {
            System.out.println("Lion's speed: 50");
        }
    }
   ```

   ```Java
    public class Cheetah implements Cat {

        @Override
        public void speed() {
            System.out.println("Cheetah's speed: 100");
        }
    }
   ```

   ```Java
    public class SouthAfricanLion implements Cat {

        @Override
        public void speed() {
            System.out.println("South African Lion's speed: 60");
        }
    }
   ```

   ```Java
    public class SouthAfricanCheetah implements Cat {

        @Override
        public void speed() {
            System.out.println("South African Cheetah's speed: 120");
        }
    }
   ```

   CatFactory ve SouthAfricanCatFactory sınıflarımızı kapsayan bir soyut sınıf oluşuralım. Main'de bu sınıfı çağıracağız.

   ```Java
    public abstract class AbstractFactory {
        abstract Cat getSpeed(String cat);
    }
   ```

   Bu soyut sınıf üzerinden CatFactory ve SouthAfricanCatFactory sınıflarımızı oluşturalım.

   ```Java
    public class CatFactory extends AbstractFactory {

        public Cat getSpeed(String cat){
            if(cat == null){
                return null;
            }

            if(cat.equalsIgnoreCase("LION")){
                return new Lion();

            } else if(cat.equalsIgnoreCase("CHEETAH")){
                return new Cheetah();

            }

        return null;
        }
    }
   ```

   ```Java
    public class SouthAfricanCatFactory extends AbstractFactory {

        public Cat getSpeed(String cat){
            if(cat == null){
                return null;
            }

            if(cat.equalsIgnoreCase("LION")){
                return new SouthAfricanLion();

            } else if(cat.equalsIgnoreCase("CHEETAH")){
                return new SouthAfricanCheetah();

            }

        return null;
        }
    }
   ```

   CatFactory ve SouthAfricanCatFactory sınıflarımızı kullanabilmek için bir factory producer sınıfı tanımlayalım. Bu sınıf sayesinde main'de hangi factory sınıfından nesne oluşturmak istediğimizi belirleyeceğiz.

   ```Java
    public class FactoryProducer {
        public static AbstractFactory getFactory(boolean southAfrican){
            if(southAfrican){
                return new southAfricanCatFactory();
            }else{
                return new CatFactory();
            }
        }
    }
   ```

   Main'de factory sınıflarını kullanarak istediğimiz tipte kedi oluşturalım.

   ```Java
    public static void main(String[] args) {
        AbstractFactory catFactory = FactoryProducer.getFactory(false);

        Cat cat1 = catFactory.getSpeed("LION");
        cat1.speed();

        Cat cat2 = catFactory.getSpeed("CHEETAH");
        cat2.speed();

        AbstractFactory catFactory1 = FactoryProducer.getFactory(true);

        Cat cat3 = catFactory1.getSpeed("LION");
        cat3.speed();

        Cat cat4 = catFactory1.getSpeed("CHEETAH");
        cat4.speed();
    }
   ```

   Çıktıya bakacak olursak;

   ```
    Lion's speed: 50
    Cheetah's speed: 100
    South African Lion's speed: 60
    South African Cheetah's speed: 120
   ```

3. Builder Pattern

   Builder Pattern, abstract factory pattern'inden daha kapsamlı bir tasarımdır. Burada nesneler adım adım yaratılır.

   Genellikle en üstte bir dizi tutan sınıf oluşturulur. Bu sınıfın kullandığı bir interface olur. Diziye ekleyeceğimiz nesneler bu interface'den türetilen sınıflardan oluşur.

4. Prototype Pattern

   Prototype pattern'de interface artık bir nesnenin prototipi olacak. İstediğimiz objenin kopyalarını oluşturacak. Bu desing patern'in amacı maliyeti azaltmaktır. Sürekli kullanacağımız bir nesne varsa sürekli veritabanından çağırmak yerine, bir defa çağırdıktan sonra, çağırdığımız nesne üzerinden yeni nesneler kopyalarız. Bu sayede veritabanı ile iletişimi azaltmış oluruz, yani maliyet ve hızdan tasarruf ederiz.

   Kedi örneğimizden devam edelim. Prototype pattern için Clonable interface'ini ata sınıfımıza tanımlayarak başlayalım.

   ```Java
    public abstract class Cat implements Cloneable {

        protected String color;
        private String name;

        abstract void speed();

        public String getColor() {
            return color;
        }

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object clone() {
            Object clone = null;

            clone = super.clone();

            return clone;
        }
    }
   ```

   Bu sınıf üzerinden kedi sınıflarımızı oluşturalım.

   ```Java
    public class Lion extends Cat {

        public Lion(){
            color = "Brown";
        }

        @Override
        public void speed() {
            System.out.println("Lion's speed: 50");
        }
    }
   ```

   ```Java
    public class Cheetah extends Cat {

        public Cheetah(){
            color = "Yellow";
        }

        @Override
        public void speed() {
            System.out.println("Cheetah's speed: 100");
        }
    }
   ```

   Veritabanından oluşturacağımız nesneleri hash tablosunda tutacak sınıfı yazalım.

   ```Java
    import java.util.Hashtable;

    public class CatCache {

        private static Hashtable<String, Cat> catMap  = new Hashtable<String, Cat>();

        public static Cat getCat(String catName) {
            Cat cachedCat = catMap.get(catName);
            return (Cat) cachedCat.clone();
        }

        public static void loadCache() {
            Lion lion = new Lion();
            lion.setName("Lion");
            catMap.put(lion.getName(), lion);

            Cheetah cheetah = new Cheetah();
            cheetah.setName("Cheetah");
            catMap.put(cheetah.getName(), cheetah);
        }
    }
   ```

   Main'de bu sınıfı çağıracak olursak;

   ```Java
    public static void main(String[] args) {
        CatCache.loadCache();

        Cat clonedCat = (Cat) CatCache.getCat("Lion");
        System.out.println("Cat: " + clonedCat.getType());

        Cat clonedCat2 = (Cat) CatCache.getCat("Cheetah");
        System.out.println("Cat: " + clonedCat2.getType());
    }
   ```

   Çıktı:

   ```
    Cat: Lion
    Cat: Cheetah
   ```

5. Singleton

   Singleton pattern, sadece tek bir nesneye ihtiyaç duyduğumuz durumda kullanılır. Veritabanından sürekli veri çekmemizin gerekmediği, yeni nesneye ihtiyaç duymadığımız durumda kullanılır.

   ```Java
    public class SingleObject {

        private static SingleObject instance = new SingleObject();

        private SingleObject(){}

        public static SingleObject getInstance(){
            return instance;
        }

        public void showMessage(){
            System.out.println("Hello World!");
        }
    }
   ```

   Tanımladığımız sınıf sadece instance oluşturmak içindir. Kendisinden bir instance oluşturup, mainde bu instance ile metotları kullanabiliriz.

   ```Java
    public static void main(String[] args) {

        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
   ```

   Çıktı:

   ```
    Hello World!
   ```
