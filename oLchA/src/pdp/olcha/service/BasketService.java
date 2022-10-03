package pdp.olcha.service;

import pdp.olcha.model.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketService implements Base{

    List<Basket> basketServices = new ArrayList<>();

    @Override
    public boolean getById(int id) {
        for (Basket basket : basketServices) {
              if (basket != null){
                  if (basket.getId()==id){
                      return true;
                  }
              }
        }
        return false;
    }

    @Override
    public boolean add(Object object) {
        if(!getById(((Basket) object).getId())){
            basketServices.add((Basket) object);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        for (Basket basketService : basketServices) {
             if (basketService!=null){
              basketServices.remove(basketService);
              System.out.println("succesfully delete");
        }
        }
    }


    @Override
    public boolean show() {
        int count=0;
        for (Basket basketService : basketServices) {
              if (basketService != null){
                  count++;
                  System.out.println(basketService);
                  return true;
              }
        }
        if (count==0) System.out.println("There are no products !!!");
        return false;
    }

    public boolean showUser(int id) {
        int count=0;
        for (Basket basketService : basketServices) {
            if (basketService != null){
                if(basketService.getId()==id){
                count++;
                System.out.println(basketService);
                return true;
                }
            }
        }
        if (count==0) System.out.println("There are no products !!!");
        return false;
    }

    @Override
    public void edit(int id, Object objService) {
        for (Basket basketService : basketServices) {
            if (basketService!=null){
                basketServices.set(basketService.getId(), (Basket) objService);
                System.out.println("succesfully edit");
            }
        }
    }
}
