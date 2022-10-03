package pdp.olcha.service;

import pdp.olcha.model.Category;
import pdp.olcha.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements Base{

    CategoryService categoryService = new CategoryService();
    List<Product> products = new ArrayList<>();

    public Product getProduct(Product product1){
        boolean flag = false;
        for (Category category : categoryService.categories){
              if(category.getId()==product1.getCategoryId()){
                  flag=true;
              }
        }
        for (Product product : products) {
            if(product != null  ){
                if(!product.getName().equals(product1.getName())){
                    if (flag==true){
                            return product;
                    }
                }
            }
        }
        return null;
    }
    public Product getProductSale(int id){
        for (Product product : products) {
            if(product != null  ){
                if(product.getId()==id){
                    if(product.getCount()==0){
                       product.setSale(true);
                    }
                       product.setCount(product.getCount()-1);
                        return product;
                }
            }
        }
        return null;
    }
    @Override
    public boolean getById(int id) {
        for (Product product : products) {
             if (product != null){
                 if (product.getId()==id){
                     return true;
                 }
             }
        }
        return false;
    }

    @Override
    public boolean add(Object object) {
     if(!getById(((Product)object).getId())){
         products.add((Product) object);
         return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        if(getById(id)){
            products.remove(id);
            System.out.println("succesfully delete");
        }
    }

    @Override
    public boolean show() {
        int count=0;
        for (Product product : products) {
            if(product != null ){
                if(product.isSale() == false && product.getCount() != 0){
                  System.out.println(product);
                  count++;
                  return true;
                }
              }
        }
        if(count==0) System.out.println(" There are no products !!! ");
        return false;
    }

    public void showProductByCategoryId(int id){
        int count=0;
        for (Product product : products) {
            if(product != null){
                if(product.getCategoryId() == id && product.isSale() == false && product.getCount()!=0){
                  System.out.println(product);
                  count++;
                }
            }
        }
        if(count==0) System.out.println(" it does not have a product of category !!! ");
    }

    @Override
    public void edit(int id, Object objService) {
        for (Product product : products) {
            if (product!=null){
                if(product.getId()==id){
            products.set(product.getId(),(Product)objService);
            System.out.println("succesfully edit");
            return;
                } }  } } }
