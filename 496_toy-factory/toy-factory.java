/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/toy-factory
@Language: Java
@Datetime: 16-07-28 08:09
*/

/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = new ToyFactory();
 * Toy toy = tf.getToy(type);
 * toy.talk();
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
    // Write your code here
    public Dog() {
        
    }
    public void talk() {
        System.out.println("Wow");
    }
}

class Cat implements Toy {
    // Write your code here
    public Cat() {
        
    }
    public void talk() {
        System.out.println("Meow");
    }
}

public class ToyFactory {
    Toy ty;
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        // Write your code here
        if (type == null) {
            return null;
        }		
        if (type.equals("Dog")) {
            ty = new Dog();
        } else {
            ty = new Cat();
        }
        return ty;
    }
}