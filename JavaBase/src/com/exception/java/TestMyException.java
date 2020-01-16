package com.exception.java;

/**
 * @author sunjiacheng
 * @create 2019-10-18-11:02
 */
public class TestMyException
{
    public static void main(String[] args)
    {
        Student s = new Student();
        s.regist(-12);

        System.out.println(s.toString());
    }
}

class Student
{
    int id;

    public void regist(int id)
    {
        if(id > 0)
            this.id = id;
        else{
            try {
                throw new MyException("学号有误");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

