package cn.javacode.demo;

public class BeanTest {
    private String name;
    private int age;

    public void setHehe(int age) {
        this.age = age;
    }

    public BeanTest() {
    }

    public BeanTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


}
