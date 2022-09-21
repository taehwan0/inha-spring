package inha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV {

    @Autowired
    @Qualifier("appleSpeaker")
    private Speaker speaker;

    public SamsungTV() {
        System.out.println("SamsungTV 객체 생성");
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("SamsungTV --- powerOn");
    }

    @Override
    public void volumeUp() {
//        System.out.println("SamsungTV --- volumeUp");
        speaker.volumeUp();
    }
}
