/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 16-07-07 00:50
*/

class Element {
    public String name;
    public int time;
    public Element(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
public class AnimalShelter {
    private LinkedList<Element> dog;
    private LinkedList<Element> cat;
    private int time;
    public AnimalShelter() {
        // do initialize if necessary
        dog = new LinkedList<Element>();
        cat = new LinkedList<Element>();
        time = 0;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        time++;
        if (type == 1) {
            dog.add(new Element(name, time));
        } else {
            cat.add(new Element(name, time));
        }
        return;
    }

    public String dequeueAny() {
        // Write your code here
        if (cat.isEmpty()) {
            Element tmp = dog.getFirst();
            dog.removeFirst();
            return tmp.name;
        }
        if (dog.isEmpty()) {
            Element tmp = cat.getFirst();
            cat.removeFirst();
            return tmp.name;
        }
        Element tmp1 = dog.getFirst();
        Element tmp2 = cat.getFirst();
        String who;
        if (tmp1.time > tmp2.time) {
            who = dequeueCat();
        } else {
            who = dequeueDog();
        }
        return who;
    }

    public String dequeueDog() {
        // Write your code here
        if (dog.isEmpty()) {
            return null;
        }
        Element tmp = dog.getFirst();
        dog.removeFirst();
        return tmp.name;
    }

    public String dequeueCat() {
        // Write your code here
        if (cat.isEmpty()) {
            return null;
        }
        Element tmp = cat.getFirst();
        cat.removeFirst();
        return tmp.name;
    }
}
