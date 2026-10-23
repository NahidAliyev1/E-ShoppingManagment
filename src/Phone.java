public class Phone extends Product{
    public String brand;


    public Phone(String name, double price, Category category,String brand) {
        super(name, price, category);
        this.brand=brand;
    }

    @Override
    public void showInfo() {
        System.out.println("ID:"+_id+"\nName:" + name+"\nBrand:" + brand +"\ncategory:" + category+"\nPrice:"+price);

    }

    @Override
    public double calculateDiscountedPrice(double percentage,Customer customer) {
        if (customer.isVip==true){
            this.price=this.price-((this.price *percentage)/100);
            System.out.println("VIP statusunuz olduguna gore size endirim tetbiq olundu.Telefonun qiymeti:"+ this.price);
            return this.price;
        }
        System.out.println("VIP statusunuz olmadigina gore endirim tetbiq olunmur.  Telefonun qiymeti:"+this.price);
        return this.price;
    }
}
