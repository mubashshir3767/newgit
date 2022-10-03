package pdp.olcha.service;

import pdp.olcha.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements Base{

  public static List < Category > categories = new ArrayList<>(1000);
    @Override
    public boolean getById(int id) {
        for (Category category : categories) {
              if(category != null){
                  if(category.getId() == id)
                    return true;
              }
        }
        return false;
    }


    public Category getByIdd(int id) {
        for (Category category : categories) {
            if(category != null){
                if(category.getId() == id)
                    return category;
            }
        }
        return null;
    }
    @Override
    public boolean add(Object object) {
        for (Category category : categories) {
                  if(category.getName().equals(((Category)object).getName()) ){
                      return false;
              }
        }
        categories.add((Category) object);
        return true;
    }

    @Override
    public void delete(int id) {
        for (Category category : categories) {
            if(category!=null) {
                if (category.getId() == id) {
            categories.remove(category);
            System.out.println("succesfully delete");
            return;
                }
             }
          }
        }



    @Override
    public boolean show() {
        int count=0;
        for (Category category : categories) {
              if(category != null){
                  System.out.println(category);
                  count++;
                  return true;
              }
        }
        if(count==0) System.out.println("There is no information !!!");
        return false;
    }

    public boolean showParentCategory(){
        int count=0;
        for (Category category : categories) {
            if(category!=null){
              if(category.getParentId()==0){
                  System.out.println(category);
                  count++;
                  return true;
              }
            }
        }
        if(count==0) System.out.println(" There is no parentCategory !!! ");
        return false;
    }

    public void showSubCategory(int Id){
        int count=0;
        for (Category category : categories) {
            if(category.getParentId() == Id){
                System.out.println(category);
                count++;
            }
        }
        if(count==0) System.out.println(" There is no subCategory !!! ");
    }


    @Override
    public void edit(int id, Object objService) {
        Category category = getByIdd(id);
             categories.set(category.getId(), (Category) objService);
             System.out.println("succesfully edit");
         }
    }

