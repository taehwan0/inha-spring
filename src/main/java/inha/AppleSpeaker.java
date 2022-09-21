package inha;

import org.springframework.stereotype.Component;

@Component("appleSpeaker")
public class AppleSpeaker implements Speaker {

    public AppleSpeaker() {
        System.out.println("    AppleSpeaker 객체 생성");
    }

    @Override
    public void volumeUp() {
        System.out.println("    AppleSpeaker --- volumeUp");
    }
}
