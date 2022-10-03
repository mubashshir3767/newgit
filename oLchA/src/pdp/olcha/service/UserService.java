package pdp.olcha.service;

import pdp.olcha.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Base{

    static List<User> users = new ArrayList<>();

    public boolean getUser(User user){
        for (User user1 : users) {
              if(user1 != null){
                  if(user1.getId()==user.getId()){
                      return true;
                  }
              }
        }
        return false;
    }

    @Override
    public boolean getById(int id) {
        for (User user : users) {
              if(user != null){
                  if(user.getId()== id) {
                      return true;
                  }
              }
        }
        return false;
    }

    public User login(String password,String number){
        for (User user : users) {
            if(user != null) {
                if (user.getPassword().equals(password) && user.getNumber().equals(number)) {
                    return user;
                }
            }
        }
        return null;
    }

    public User loginForBuy(String password,String cardNumber){
        for (User user : users) {
            if(user != null) {
                if (user.getPassword().equals(password) && user.getMasterCard().equals(cardNumber)) {
                    return user;
                }
            }
        }
        return null;
    }
    @Override
    public boolean add(Object object) {
            if (!getUser((User)object)){
               if (object!=null){
                  users.add((User) object);
                  return true;
              }
          }
        return false;
    }


    @Override
    public void delete(int id) {
        for (User user : users) {
            if (user.getId()==id){
                users.remove(user.getId());
                System.out.println("succesfully delete");
                return;
            }
        }
    }

    @Override
    public boolean show() {
        int count=0;
        for (User user : users) {
              if(user != null){
                  System.out.println(user);
                  count++;
                  return true;
              }
        }
        if(count==0) System.out.println(" There is no information !!! ");
        return false;
    }


    @Override
    public void edit(int id, Object objService) {
        for (User user : users) {
            if (user.getId()==id){
            users.set(user.getId(), (User) objService);
            System.out.println("succesfully edit");
            return;
        }
        }
    }
}
