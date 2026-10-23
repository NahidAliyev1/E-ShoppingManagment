public class Dress extends Product{
    public  String size;
    public Dress(String name, double price, Category category,String size) {
        super(name, price, category);
        this.size=size;
    }

    @Override
    public void showInfo() {
        System.out.println("ID:"+_id+"\nName:" + name+"\nSize:" + size +"\ncategory:" + category+"\nPrice:"+price);
    }

    @Override
    public double calculateDiscountedPrice(double percentage,Customer customer) {
        if (customer.isVip==true){
            this.price=this.price-((this.price *percentage)/100);
            System.out.println("VIP statusunuz olduguna gore size endirim tetbiq olundu.Paltarin qiymeti:"+ this.price);
            return this.price;
        }
        System.out.println("VIP statusunuz olmadigina gore endirim tetbiq olunmur.Paltarin qiymeti:"+this.price);
        return this.price;
    }
}
