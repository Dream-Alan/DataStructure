package DataStructure.DynamicArray;

public class Main {
    public static void main(String[] args) {
        ArrayList<person> li=new ArrayList<>();
        li.add(new person("张三",18));
        li.add(new person("李四",19));
        li.add(new person("王五",20));
        System.out.println(li);
        ArrayList<Integer>li2=new ArrayList<>();
        li2.add(1);
        li2.add(2);
        li2.add(3);
        li2.add(4);
        li2.add(5);
        li2.add(6);
        li2.add(5,85);
        Assert.test(li2.get(5)!=85);
        System.out.println(li2);
    }
}
