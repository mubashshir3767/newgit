import pdp.olcha.model.*;
import pdp.olcha.service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static Scanner scannerInt = new Scanner(System.in);
  static Scanner scannerStr = new Scanner(System.in);
  static User user = new User();
  static Order order = new Order();
  static Basket basket = new Basket();
  static Product product = new Product();
  static Category category = new Category();
  static UserService userService = new UserService();
  static OrderService orderService = new OrderService();
  static BasketService basketService = new BasketService();
  static ProductService productService = new ProductService();
  static CategoryService categoryService = new CategoryService();

    public static void main(String[] args) {
         int var=5;
         while (var!=0){
        System.out.println("1.kirish, 2.Login, 3.register, 0.exit");
             var= scannerInt.nextInt();
             switch (var){
                 case 1->{
                     singIn();
                 }
                 case 2->{
                     login();
                 }
                 case 3->{
                     Register();
                 }
             }
         }
    }

    private static void user() {
        int var=5;
        while(var!=0){
            System.out.println("1.Category, 2.basket, 0.exit");
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    look();
                    System.out.println("enter category id ");
                    productService.showProductByCategoryId(scannerInt.nextInt());
                }
                case 2->{
                    buy();
                }
            }
        }
    }





    private static void admin() {
        int var=5;
        while(var!=0){
            System.out.println("1.Category, 2.Product, 3.Order,  0.exit");
              var = scannerInt.nextInt();
              switch (var){
                      case 1->{
                          adminCategory();
                      }
                      case 2->{
                          adminProduct();
                      }
                      case 3->{
                          adminOrder();
                      }
                  }
              }
        }
    private static void adminOrder() {
        int var=5;
        while (var!=0){
        System.out.println("1.showOrder, 2.deleteOrder, 0.back ");
            var = scannerInt.nextInt();
            switch (var){
                case 1->{
                    orderService.show();
                }
                case 2->{
                    orderService.show();
                    System.out.println("enter id for delete !");
                    orderService.delete(scannerInt.nextInt());
                }
            }
        }
    }
    private static void adminProduct() {
        int var = 4;
        while (var != 0){
            System.out.println("1.AddProduct, 2.ShowProduct, 3.EditProduct, 4.DeleteProduct, 0.Exit");
            var = scannerInt.nextInt();
            switch (var){
               case 1->{
                   addProduct();
               }
               case 2->{
                   productService.show();
               }
               case 3->{
                    productService.show();
                    System.out.println("enter id for edit");
                    int n= scannerInt.nextInt();
                    productService.edit(n,addProduct());
               }
               case 4->{
                   productService.show();
                   System.out.println("enter id for delete");
                   int id = scannerInt.nextInt();
                      productService.delete(id);
               }
            }
        }
    }
    public static void adminCategory(){
            int var=5;
            while(var!=0){
                System.out.println("1.AddCategory, 2.DeleteCategory, 3.EditCategory, 4.ShowCategory,  0.exit");
                var= scannerInt.nextInt();
                switch (var){
                    case 1-> {
                        look();
                        Category category1 = new Category();
                        System.out.println("enter parent id: ");
                        category1.setParentId(scannerInt.nextInt());
                        System.out.println("enter category name: ");
                        category1.setName(new Scanner(System.in).nextLine());
                        System.out.println(categoryService.add(category1));
                    }
                    case 2->{
                        look();
                        System.out.println("enter id for delete: ");
                        int n=scannerInt.nextInt();
                        categoryService.delete(n);

                    }
                    case 3->{
                        look();
                        System.out.println("id for edit");
                        int v=scannerInt.nextInt();
                        System.out.println("enter category name");
                        String name=scannerStr.nextLine();
                        categoryService.edit(v, name);
                    }
                    case 4->{
                        look();
                    }
                }
            }
        }

    private static void login() {
        System.out.println("enter password: ");
        String password=scannerStr.nextLine();
        System.out.println("enter number: ");
        String number=scannerStr.nextLine();
        User user2 = userService.login(password,number);
        if(user2.getRole().equals("ADMIN")){
            admin();
        }else{
            user();
        }
    }

    private static boolean singIn() {
        if(look()==true){
        buy();
        return true;
        }
        return false;
    }

    private static void buy(){
        System.out.println("1.buy, 2.clear, 3.showBasket 0.back");
        int var2=5;
        while (var2!=0){
            var2=scannerInt.nextInt();
            switch (var2){
                case 1->{
                    look();
                    System.out.println("category tanlash uchun id kiriting!!!");
                    productService.showProductByCategoryId(scannerInt.nextInt());
                    Buy();
                    basketService.add(Buy());
                }
                case 2->{
                    System.out.println("category tanlash uchun id kiriting!!!");
                    productService.showProductByCategoryId(scannerInt.nextInt());
                    clear();
                    basketService.delete(Buy());
                }
                case 3->{
                    showBasket();
                }
            }
        }
    }

    private static void showBasket() {
        int c=0;
        for (Product basket1 : baskets) {
             if (basket1 != null){
                 System.out.println(basket1);
                 c++;
             }
        }
        if(c==0) System.out.println("no product");
    }

    private static void clear() {
        System.out.println("1.all, 2.one, 0.back");
        int var=5;
        while (var!=0){
            var= scannerInt.nextInt();
            switch (var){
                case 1->{
                    baskets.clear();
                }
                case 2->{
                    for (Product basket1 : baskets) {
                         if (basket1 != null){
                             System.out.println(basket1);
                         }
                    }
                    System.out.println("select id for delete ");
                    int id = scannerInt.nextInt();
                    for (Product basket1 : baskets) {
                         if (basket1!=null){
                          if (id==basket1.getId()){
                              baskets.remove(id);
                              System.out.println("succesfully delete");
                           }
                        }
                    }
                }
            }
        }
    }

     static  List<Product>baskets=new ArrayList<>();
    private static int Buy() {
        int i=4;
        while (i!=0){
            System.out.println("1.buy, 2.register, 0.exit ");
            i=scannerInt.nextInt();
            switch (i){
               case 1->{
                   System.out.println("enter id for show ");
                   productService.showProductByCategoryId(scannerInt.nextInt());
                   System.out.println("enter id for buy");
                   Product product = productService.getProductSale(scannerInt.nextInt());
                   baskets.add(product);
               }
               case 2->{
                   System.out.println("1.register, 0.Exit");
                   int n = scannerInt.nextInt();
                   if(n==1){
                       Register();
                   } else if (n==0) {
                       return 0;
                   }
               }

               }
            }
        return i;
    }

    private static User userForBuy() {
        System.out.println("Enter your card number to make a purchase !!!");
        String cardNumber = scannerStr.nextLine();
        System.out.println("Enter your password to make a purchase !!!");
        String password = scannerStr.nextLine();
        User user1 = userService.loginForBuy(password,cardNumber);
        if(user1 != null){
            order.setPhoneNumber(user1.getNumber());
            order.setName(user1.getName());
            order.setPaySum(product.getSumPrice());
            order.setCount(product.getCount());
            orderService.add(order);
        }
        return user1;
    }

    private static Object addProduct(){
        System.out.println("enter product name: ");
        product.setName(scannerStr.nextLine());
        System.out.println("enter producter: ");
        product.setProducter(scannerStr.nextLine());
        System.out.println("enter price: ");
        product.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("enter count: ");
        product.setCount(scannerInt.nextInt());
        look();
        System.out.println("enter category id: ");
        int var = scannerInt.nextInt();
        boolean category1 = categoryService.getById(var);
        if(category1==true){
        product.setCategoryId(var);
        System.out.println(productService.add(product));
        }else {
            System.out.println("there is  no category id: ");
        }
        return product;
    }
    private static void Register(){
        User user1 = new User();
        System.out.print("enter name: ");
        user1.setName(scannerStr.nextLine());
        System.out.print("enter password: ");
        user1.setPassword(scannerStr.nextLine());
        System.out.print("enter PhoneNumber: ");
        user1.setNumber(scannerStr.nextLine());
        System.out.print("enter role: ");
        user1.setRole(scannerStr.nextLine());
        if(!user1.getRole().equals("ADMIN")){
            System.out.print("enter Card: ");
            user1.setMasterCard(scannerStr.nextLine());
            System.out.print("enter card amount: ");
            user1.setAmount(new Scanner(System.in).nextBigDecimal());
        }
        userService.add(user1);
    }

    private static boolean look(){
        if (categoryService.showParentCategory() != false){
        int var1=4;
            while(var1!=-1){
                System.out.println("enter category id : (-1.exit)");
                var1 = scannerInt.nextInt();
                if(var1 != -1)
                    categoryService.showSubCategory(var1);
                if(categoryService.getById(var1) == false){
                    System.out.println("come again");
                    return true;
                }
            }
        }
        return false;
    }
}