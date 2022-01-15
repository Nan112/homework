package code;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<student> array=new ArrayList<student>();//创建集合对象

        //菜单
        while(true) {
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1、添加学生");
            System.out.println("2、删除学生");
            System.out.println("3、修改学生");
            System.out.println("4、查看所有学生");
            System.out.println("5、退出");
            System.out.println("请输入你的选择：");

            //用Scanner实现键盘录入数据
            Scanner sc=new Scanner(System.in);
            String line=sc.nextLine();

            switch(line) {
                case"1":
                    add(array);
                    break;
                case"2":
                    del(array);
                    break;
                case"3":
                    re(array);
                    break;
                case"4":
                    find(array);
                    break;
                case"5":
                    System.out.println("谢谢使用！");
                    return;
            }
        }
    }

    //添加
    public static void add(ArrayList<student> array) {//array为集合
        Scanner sc=new Scanner(System.in);


        System.out.println("请输入学生学号：");
        String sid=sc.nextLine();
        for(int i=0;i<array.size();i++)	{
            student student=array.get(i);
            if(student.getSid().equals(sid)) {
                System.out.println("学号已存在，请重新输入！");
            }
            return;
        }



        System.out.println("请输入学生姓名：");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age=sc.nextLine();
        System.out.println("请输入学生班级：");
        String banji=sc.nextLine();

        student s=new student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setBanji(banji);

        array.add(s);//将学生对象添加到集合中
        System.out.println("添加成功！");
    }

    //查看
    public static void find(ArrayList<student> array) {
        if(array.size()==0) {
            System.out.println("当前无学生信息！");
        }else {
            System.out.println("学号\t姓名\t年龄\t班级");
            for(int i=0;i<array.size();i++) {
                student s=array.get(i);
                System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getBanji());
            }
        }


    }

    //删除
    public static void del(ArrayList<student> array) {
        if(array.size()==0) {
            System.out.println("当前无学生信息！");
        }else {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入删除的学生学号：");
            String sid=sc.nextLine();

            for(int i=0;i<array.size();i++) {
                student s=array.get(i);
                if(s.getSid().equals(sid)) {
                    array.remove(i);
                    System.out.println("已删除！");
                }else {
                    System.out.println("未找到该学号！");
                }
            }
        }
    }

    //修改
    public static void re(ArrayList<student> array) {
        if(array.size()==0) {
            System.out.println("当前无学生信息！");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入修改的学生学号：");
        String sid=sc.nextLine();



        for(int i=0;i<array.size();i++)	{
            student student=array.get(i);
            if(student.getSid().equals(sid)) {

                System.out.println("请输入新姓名：");
                String name=sc.nextLine();
                System.out.println("请输入新年龄：");
                String age=sc.nextLine();
                System.out.println("请输入新班级：");
                String banji=sc.nextLine();

                student s=new student();
                s.getSid();
                s.getAge();
                s.getName();
                s.getBanji();

                array.set(i, s);
                System.out.println("修改成功！");
                break;
            }else {
                System.out.println("未找到该学号！");
            }
        }

    }
}
