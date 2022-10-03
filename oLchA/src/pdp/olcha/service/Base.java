package pdp.olcha.service;

public interface Base {

    boolean getById(int id);
    boolean add(Object object);
    void delete(int id);
    boolean show();
    void edit(int id,Object objService);
}
