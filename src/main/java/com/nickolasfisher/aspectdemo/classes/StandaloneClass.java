package com.nickolasfisher.aspectdemo.classes;

import org.springframework.stereotype.Component;

@Component
public class StandaloneClass {
    public void doSomethingInOtherClass() {
        System.out.println("in a standalone class method");
    }
}
