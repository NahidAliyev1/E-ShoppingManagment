import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;

public abstract class Product  {
    public   int _id;
    private  static int _idCounter=1;
    public String name;
    public double price;
    public Category category;
    public LocalDateTime createAt;


    public Product(String name,double price,Category category){
        _id=++_idCounter;
        this.name=name;
        this.price=price;
        this.category=category;
        createAt=LocalDateTime.now();
    }
    public abstract void showInfo();
    public  abstract  double calculateDiscountedPrice(double percentage,Customer customer);



}
