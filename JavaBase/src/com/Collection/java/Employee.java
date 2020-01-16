package com.Collection.java;

import java.util.Objects;

/**
 * @author sunjiacheng
 * @create 2019-10-21-16:40
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getBirthday(), employee.getBirthday());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge(), getBirthday());
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee) {
            Employee p = (Employee)o;
            int i = this.name.compareTo(p.name);
            if(i == 0) {
                return (this.age- p.age);
            }
            else { return i; }
        }
        return 0;
    }
}
