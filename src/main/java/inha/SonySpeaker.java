package inha;

import org.springframework.stereotype.Component;

@Component("sonySpeaker")
public class SonySpeaker implements Speaker {
    public SonySpeaker() {
        System.out.println("    SonySpeaker 객체 생성");
    }

    @Override
    public void volumeUp() {
        System.out.println("    SonySpeaker --- volumeUp");
    }
}
