import org.junit.Test;

public class Cat {
    private String catName;
    private char sex;
    private String kind;
    private float weight;

    public void getCatName(){
        System.out.println("名字："+catName);
    }
    public  void setCatName(String catName){
        this.catName = catName;
    }
    public void getSex(){
        System.out.println("名字："+sex);
    }
    public  void setSex(char sex){
        this.sex = sex;
    }
    public void getKind(){
        System.out.println("名字："+kind);
    }
    public  void setKind(String kind){
        this.kind = kind;
    }
    public void getWeight(){
        System.out.println("名字："+weight);
    }
    public  void setWeight(float weight){
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                ", sex=" + sex +
                ", kind='" + kind + '\'' +
                ", weight=" + weight +
                '}';
    }
    @Test
    public void test1(){
        Cat cat = new Cat();
        cat.setCatName("小白");
        cat.setKind("狸花猫");
        cat.setSex('女');
        cat.setWeight(16f);
        System.out.println(cat);
    }
}
