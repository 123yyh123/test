package com.example.project;

import java.util.Random;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class EquationFactory {
    public static IEqualtion getEquation(String type){
        if("Add".equals(type)){
            return AddEquation.AddEquationBuilder.build(createRandomNumber(),createRandomNumber());
        }else if("Sub".equals(type)){
            return SubEquation.SubEquationBuilder.build(createRandomNumber(),createRandomNumber());
        }else{
            throw new RuntimeException("不支持的类型");
        }
    }
    public IEqualtion getEquationRandom(){
        Random random = new Random();
        int i = random.nextInt(2);
        if(i==0){
            return AddEquation.AddEquationBuilder.build(createRandomNumber(),createRandomNumber());
        }else{
            return SubEquation.SubEquationBuilder.build(createRandomNumber(),createRandomNumber());
        }
    }
    private static short createRandomNumber() {
        Random random = new Random();
        return (short) random.nextInt(101);
    }
}
