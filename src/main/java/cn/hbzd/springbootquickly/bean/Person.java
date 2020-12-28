package cn.hbzd.springbootquickly.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties: 告诉SpringBoot将本类中所有属性和配置文件中相关的配置进行绑定
 *  prefix = "person": 配置文件中哪个下面的所有属性进行一一映射
 *  只有这个组件是容器中的组件 才能容器提供的@ConfigurationProperties功能
 * @author: CodeEmp
 * @time: 2020/12/23 9:08
 */

@PropertySource(value = ("classpath:person.properties"))
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
    /**
    * <bean class="Person">
    *   <property name="lastName" value="张三" />
    *
    * </bean>
    **/
//    @Value("${person.last-name}")
    //lastName必须是邮箱格式
//    @Email
    private String lastName;
//    @Value("#{11 * 2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    private List<Object> lists;
    private Dog  dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person() {
    }

    public Person(String lastName, Integer age, Boolean boss, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.lastName = lastName;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }
}
