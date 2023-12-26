package com.example.project;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class Experiment4 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入要生成的算式数量：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        EquationCollection equationCollection = new EquationCollection();
        // 生成n个算式
        equationCollection.generate(n, new EquationCheckerOfRange(0, 100));
        // 遍历equations
        equationCollection.iterator().forEachRemaining(iEqualtion -> {
            System.out.println(iEqualtion.getOperand1() + "" +
                            iEqualtion.getOperator() + iEqualtion.getOperand2() + "=" + iEqualtion.calculate());
        });
    }
}
class Test{
    public static void main(String[] args) throws ClassNotFoundException {
        // 根据类名字符串“AddEquation”获取类对象
        Class<?> aClass = Class.forName("com.yyh.ex4.AddEquation");
        System.out.println(aClass);
        // 获取类的属性
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 获取类的方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 获取构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        // 产生实例
        try {
            Object o = constructors[0].newInstance();
            System.out.println(o);
        } catch (Exception e) {
            System.out.println("没有无参构造方法或者无参构造方法私有化了");
        }
    }
}
