package Medium;

import java.util.*;

public class ThroneInheritance {
    Person king = null;
    Map<String, Person> getInfo = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.king = new Person(kingName);
        getInfo.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person baby = new Person(childName);
        getInfo.get(parentName).children.add(baby);
        getInfo.put(childName, baby);
    }

    public void death(String name) {
        getInfo.get(name).dead = true;
    }

    public List<String> getInheritanceOrder() {
        Stack<Person> seek = new Stack<>();
        seek.add(king);
        List<String> res = new ArrayList<>();
        while (!seek.isEmpty()) {
            Person p = seek.pop();
            if (!p.dead)
                res.add(p.name);
            for (int i = p.children.size() - 1; i >= 0; i--)
                seek.add(p.children.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        System.out.println(t.getInheritanceOrder());
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        System.out.println(t.getInheritanceOrder());
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        System.out.println(t.getInheritanceOrder());
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        System.out.println(t.getInheritanceOrder());
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        System.out.println(t.getInheritanceOrder());
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());// 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }
}

class Person {
    String name;
    List<Person> children = new ArrayList<>();
    boolean dead = false;

    public Person(String name) {
        this.name = name;
    }
}