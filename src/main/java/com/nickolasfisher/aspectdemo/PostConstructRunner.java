package com.nickolasfisher.aspectdemo;

import com.nickolasfisher.aspectdemo.classes.StandaloneClass;
import com.nickolasfisher.aspectdemo.interfaces.InterfaceToAspectOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructRunner {

    private final InterfaceToAspectOn interfaceToAspectOn;

    private final StandaloneClass standaloneClass;

    public PostConstructRunner(InterfaceToAspectOn interfaceToAspectOn, StandaloneClass standaloneClass) {
        this.interfaceToAspectOn = interfaceToAspectOn;
        this.standaloneClass = standaloneClass;
    }

    @PostConstruct
    public void runOnce() {
        System.out.println("running method after context loaded");

        interfaceToAspectOn.emptyMethod1();
        interfaceToAspectOn.emptyMethod2();

        String val = interfaceToAspectOn.methodThatReturns("some string input value");
        System.out.println("returned value inside post construct: " + val);

        standaloneClass.doSomethingInOtherClass();

        System.out.println("post construct method concluded");
    }
}
