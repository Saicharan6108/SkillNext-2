
import java.util.*;


class Product
{
    private String name;
    private double price;

    Product(String name,double price){
        this.name=name;
        this.price=price;
    }

    public String getName()
    {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
}

class Onlineshoppingcart {

    private ArrayList<Product> cart=new ArrayList<>();

    public void add(Product p)
    {
        for(Product b:cart)
        {
            if(b.getName().equals(p.getName()))
            {
                System.out.println("Duplicate product found");
                b.setPrice(b.getPrice()+p.getPrice());
                System.out.println("Product price updated");
                return;
            }
        }
        cart.add(p);
        System.out.println("Product added to the cart.");
    }

    public void remove(String p)
    {
        for(Product b:cart)
        {
            if(b.getName().equals(p))
            {
                cart.remove(b);
                System.out.println("product "+b.getName()+" removed from cart");
                return;
            }
        }
        System.out.println("product "+p+" not found in cart");
    }

    public void displayCart()
    {
        System.out.printf("Product Name \t Price");
        for(Product p:cart)
        {
            System.out.printf("\n%-20s%.2f",p.getName(),p.getPrice());
        }
    }

    public void checkout()
    {
        double total=0;
        for(Product p:cart)
        {
            total+=p.getPrice();
        }

        if(total>=100000.0)
        {
            total-=total*0.1;
            System.out.println("10% discount added");
        }

        System.out.println("total price to be paid: "+total);
        
    }
}

public class Ecom
{
    static int menu()
    {
        System.out.print("\n1.add\n2.remove\n3.display\n4.checkout\n5.exit\nEnter choice:");
        Scanner sc= new Scanner(System.in);
        return sc.nextInt();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Onlineshoppingcart cart=new Onlineshoppingcart();
        while (true) { 
            switch(menu())
            {
                case 1:
                        System.out.print("\nenter product name: ");
                        String name=sc.next();
                        System.out.print("enter product price: ");
                        int price=sc.nextInt();
                        Product p=new Product(name,price);
                        cart.add(p);
                        break;
                case 2:
                        System.out.print("\nEnter product name: ");
                        name=sc.next();
                        cart.remove(name);
                        break;
                case 3:
                        cart.displayCart();
                        break;
                case 4:
                        cart.checkout();
                        break;
                case 5: 
                    System.exit(0);
            }
        }
    }
}
