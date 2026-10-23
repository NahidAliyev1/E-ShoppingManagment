public class Customer {
    public String name;
    public  boolean isVip;

    public Customer(String name,boolean isVip){
        this.name=name;
        this.isVip=isVip;
    }

    public void  buyVipMembership(){
        this.isVip=true;
        System.out.println("Tebrikler VIP statusu aktif oldu");

    }
}
