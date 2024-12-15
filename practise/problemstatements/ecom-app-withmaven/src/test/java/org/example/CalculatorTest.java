package org.example;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class CalculatorTest {

    private static final Logger log = LoggerFactory.getLogger(CalculatorTest.class);
    Calculator calci;

    @BeforeAll
    static void init(){
        log.info("Test Started...");
    }

    @BeforeEach
    void setup(){
        calci=new Calculator();
        log.info("Calculater object created..");
    }

    @AfterEach
    void teardown(){
        calci=null;
        log.info("Calculater object destroyed..");
    }
    @AfterAll
    static void complete(){
        log.info("Test Ends...");
    }

@Test
//@EnabledOnJre(JRE.JAVA_21)
//@EnabledOnOs(OS.MAC)
    void addTest(){

        int result=calci.add(20,30);

        Assertions.assertEquals(50,result);
        Assertions.assertEquals(100,calci.add(40,60));

    }
@Test
    void divideTest(){
        int result=calci.divide(20,10);

        Assertions.assertEquals(2,result);
        Assertions.assertEquals(-10,calci.divide(-100,10));
        Assertions.assertThrowsExactly(ArithmeticException.class, ()->calci.divide(10,0));

    }
}
