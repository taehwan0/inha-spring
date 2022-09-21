package inha;

public class LgTV implements TV {

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
