package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddEquationTests {

    @BeforeEach
    void setUp() {
        System.out.println("setUp annotatted with @BeforeEach");
    }

    @Test
    @DisplayName("A basic assert")
    void useCodedValue() {
        assertEquals(2,
                AddEquation.AddEquationBuilder.build((short) 1, (short) 1).calculate(), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3"
    })
    void useCsvSource(int first, int second, int expectedResult) {
        assertEquals(expectedResult,
                AddEquation.AddEquationBuilder.build((short) first, (short) second).calculate(),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    @ParameterizedTest(name = "using ValueSource")
    @ValueSource(ints = { 1, 2, 3})
    void useValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void useRepeatedTest() {
        assertEquals(2,
                AddEquation.AddEquationBuilder.build((short) 1, (short) 1).calculate(), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "using MethodSource")
    @MethodSource("equationProvider")
    void useMethodSource(SimpleTriplet triplet) {
        assertEquals(triplet.result,
                AddEquation.AddEquationBuilder.build((short) triplet.op1, (short) triplet.op2).calculate(),
                "should equal");
    }

    public static class SimpleTriplet {
        public int op1;
        public int op2;
        public int result;

        public SimpleTriplet(int op1, int op2, int result) {
            this.op1 = op1;
            this.op2 = op2;
            this.result = result;
        }
    }


    public static Set<AddEquationTests.SimpleTriplet> equationProvider() {
        Set<AddEquationTests.SimpleTriplet> set = new HashSet<>();
        set.add(new AddEquationTests.SimpleTriplet(0, 0, 0));
        set.add(new AddEquationTests.SimpleTriplet(0, 1, 1));
        return set;
    }



    @AfterEach
    void tearDown() {
        System.out.println("tearDown annotatted with @AfterEach");
    }

}
