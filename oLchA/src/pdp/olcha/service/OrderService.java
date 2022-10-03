package pdp.olcha.service;

import pdp.olcha.model.Basket;
import pdp.olcha.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements Base{
    List<Order> orders = new ArrayList<>();
    @Override
    public boolean getById(int id) {
        for (Order userForOrder : orders) {
              if(userForOrder != null){
                  if(userForOrder.getId()==id){
                      return true;
                  }
              }
        }
        return false;
    }

    @Override
    public boolean add(Object object) {
       if (!getById(((Order) object).getId())){
           orders.add((Order) object);
           return true;
       }
        return false;
    }

    @Override
    public void delete(int id) {
        for (Order order : orders) {
            if(order != null){
             if(order.getId()==id){
              orders.remove(order);
              System.out.println("succesfully delete ");
              return;
             }
          }
        }

    }

    @Override
    public boolean show() {
        int count=0;
        for (Order adminForOrder : orders) {
            if (adminForOrder != null){
                System.out.println(adminForOrder);
                count++;
                return true;
            }
        }
        if (count==0) System.out.println("There are no products !!!");
        return false;
    }

    @Override
    public void edit(int id, Object objService) {
        for (Order order : orders) {
             if (order != null){
                 if(order.getId()==id){
                   orders.set(order.getId(), (Order) objService);
                   System.out.println("succesfully edit");
                   return;
                 }
             }
        }
    }
}
