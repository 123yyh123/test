package com.example.project;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class EquationCollection implements Iterable<IEqualtion>{
    public static Set<IEqualtion> equations=new HashSet<>();
    public void generate(int n, EquationChecker checker){
        EquationFactory equationFactory = new EquationFactory();
        int i = 0;
        while (i < n) {
            IEqualtion equation = equationFactory.getEquationRandom();
            if (checker.check(equation)) {
                if(equations.add(equation)){
                    i++;
                }
            }
        }
    }

    @Override
    public Iterator<IEqualtion> iterator() {
        return equations.iterator();
    }
}
