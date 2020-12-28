package cn.hbzd.springbootquickly.bean;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/23 9:10
 */
public class Dog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
