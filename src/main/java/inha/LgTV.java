package inha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {

    @Autowired
    @Qualifier("sonySpeaker")
    private Speaker speaker;

    public LgTV() {
        System.out.println("LgTV 객체 생성");
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("LgTV --- powerOn");
    }

    @Override
    public void volumeUp() {
//        System.out.println("LgTV --- volumeUp");
        speaker.volumeUp();
    }
}
