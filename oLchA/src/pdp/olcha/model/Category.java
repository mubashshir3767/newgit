package pdp.olcha.model;

public class Category extends Base{
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        parentId = parentId;
    }

    public Category(int parentId) {
        parentId = parentId;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "parentId=" + parentId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
