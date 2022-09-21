package inha;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        TV tv = container.getBean("tv", TV.class);
        tv.powerOn();
        tv.volumeUp();
    }
}
