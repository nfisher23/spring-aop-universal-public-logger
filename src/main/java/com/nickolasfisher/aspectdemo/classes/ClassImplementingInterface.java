package com.nickolasfisher.aspectdemo.classes;

import com.nickolasfisher.aspectdemo.interfaces.InterfaceToAspectOn;
import org.springframework.stereotype.Component;

@Component
public class ClassImplementingInterface implements InterfaceToAspectOn {
    @Override
    public void emptyMethod1() {
        System.out.println("inside emptyMethod1");
    }

    @Override
    public void emptyMethod2() {
        System.out.println("inside emptyMethod2");
    }

    @Override
    public String methodThatReturns(String input) {
        System.out.println("method that returns with input value: " + input);
        return "some returned string";
    }
}
