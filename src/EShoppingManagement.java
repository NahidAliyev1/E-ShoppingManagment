import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EShoppingManagement {
    public List<Product> products=new ArrayList<>();

public void addProduct(Product product){

    if (product==null)
    {
        System.out.println("Product null ola bilmez");
        return;
    }
    products.add(product);
    System.out.println("Ugurla elave edildi");
}
public List<Product> getAllProducts()
{
   return products;

}
public  List<Product> getProductsByCategory(Category category){

    List<Product> filteredProducts = new ArrayList<>();
    for (Product item :products){
        if (item.category==category)
        {
            filteredProducts.add(item);

        }
    }
    return  filteredProducts;
}
public Product getProductById(int id){

    for (Product item:products){

        if (item._id==id){

            return item;
        }
    }
    return null;
}
public void deleteProductById(int id){
    boolean founded=false;
    for (Product item :products){
        if (item._id==id){
            founded=true;
            products.remove(item);
            System.out.println("Ugurla silindi");
            return;

        }
    }
    if (!founded){
        System.out.println("Bu Id li product tapilmadi");
    }else {
        System.out.println("Ugurla silindi");
    }

}
public void updatePrice(int id, double newPrice){
    for (Product item:products)
        if (item._id == id) {
            item.price = newPrice;
            return;

        }System.out.println(id + " ID-li məhsul tapılmadı.");

}
}
