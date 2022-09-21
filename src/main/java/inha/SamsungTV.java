package inha;

public class SamsungTV implements TV {

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
