import java.util.Scanner;

void main() {
  EShoppingManagement eShoppingManagement=new EShoppingManagement();
  Customer customer=new Customer("Nahid",false);
Scanner input=new Scanner(System.in);
while (true)
{
    System.out.println("--------MENU--------");
    System.out.println("1.Məhsul əlavə et");
    System.out.println("2.Bütün məhsulları göstər");
    System.out.println("3.Kateqoriyaya görə filterlə");
    System.out.println("4.Qiymət yenilə");
    System.out.println("5.Məhsul sil");
    System.out.println("6.Cixis");
    System.out.println("7. VIP Üzvlük Al");
    System.out.println("8. Məhsula VIP Endirimi Tətbiq Et");

    byte op=input.nextByte();
    input.nextLine();
    if (op==6)
    {
        return;
    } else if (op==1)
    {
        System.out.println("Mehsul adi daxil edin:");
        String name=input.nextLine();
        System.out.println("Brand daxil edin");
        String brand=input.nextLine();
        System.out.println("Kategoriya daxil edin");
        String inputCategory = input.nextLine().toUpperCase();
        Category category = Category.valueOf(inputCategory);
        System.out.println("Qiymet daxil edin");
        double price=input.nextDouble();
        if (category==Category.PHONES)
        {
            Phone phone=new Phone(name,price,category,brand);
            eShoppingManagement.addProduct(phone);
        }else if (category==Category.CLOTHING)
        {
            Dress dress=new Dress(name,price,category,"medium");
            eShoppingManagement.addProduct(dress);
        }else
        {
            System.out.println("Bele bir kategoriya movcud deyildir");
        }

    }
    else if (op==2) {
        for (Product p : eShoppingManagement.getAllProducts()) {
            p.showInfo();
            System.out.println("----------------------");
        }

    }
    else if(op==3)
    {
        System.out.println("Kategoriya daxil edin (PHONES / CLOTHING):");
        String inputCategory = input.nextLine().toUpperCase().trim();
        Category category = Category.valueOf(inputCategory);

        // Filterlənmiş siyahını alırıq:
        List<Product> filteredProducts = eShoppingManagement.getProductsByCategory(category);

        // Ekrana çap edirik:
        if (filteredProducts.isEmpty()) {
            System.out.println("Bu kateqoriyada məhsul tapılmadı.");
        } else {
            for (Product p : filteredProducts) {
                p.showInfo();
                System.out.println("-------------------");
            }
        }
    }
    else if (op==5)
    {
        System.out.println("Silmek istediyiniz mehsulun id daxil edin");
        int id= input.nextInt();
        eShoppingManagement.deleteProductById(id);

    }
    else if (op==4) {
        System.out.println(" id daxil edin");
        int id= input.nextInt();
        System.out.println("Yeni qiymeti daxil edin");
        double newprice= input.nextDouble();
        eShoppingManagement.updatePrice(id,newprice);
    }

    else if (op == 7) {
        customer.buyVipMembership(); // Status true olur
    }
    else if (op == 8) {
        System.out.println("Endirim tətbiq etmək istədiyiniz məhsulun ID-sini daxil edin:");
        int id = input.nextInt();
        Product product = eShoppingManagement.getProductById(id);

        if (product != null) {
            System.out.println("Endirim faizini daxil edin (məs: 15):");
            double percentage = input.nextDouble();
            product.calculateDiscountedPrice(percentage, customer);
        } else {
            System.out.println("Məhsul tapılmadı.");
        }
    }

}
}
