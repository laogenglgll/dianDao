import org.junit.Test;

public abstract class Animal {
    public abstract void say();
}

class Dog extends Animal{
    @Override
    public void say() {
        System.out.println("小狗汪汪汪的叫");
    }
}
class Cat1 extends Animal{
    @Override
    public void say() {
        System.out.println("小猫喵喵喵的叫");
    }
}
class Game{
    public void play(Animal animal) {
        animal.say();
    }
}


