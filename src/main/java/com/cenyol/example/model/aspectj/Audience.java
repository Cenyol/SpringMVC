package com.cenyol.example.model.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 07/08/2017 11:26
 */
@Aspect
@Component
public class Audience {

    @Before("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phone");
    }

    @Before("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP !!!");
    }

    @AfterThrowing("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
