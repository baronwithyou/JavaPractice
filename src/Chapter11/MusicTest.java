package Chapter11;

import javax.sound.midi.*;
import static java.lang.System.out;

public class MusicTest {
    public static void main(String []args) {
        MusicTest mt = new MusicTest();
        mt.play();
    }

    private void play() {
        try {
            // 创建一个DVD机
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            // 创建一张唱片碟
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // 写入track(歌曲)中音符旋律(message)
            ShortMessage a = new ShortMessage();
            // 第一个参数有两个值（144代表打开 128代表关闭）
            // 第二个参数是频道 如吉他还是bass还是。。。
            // 第三个参数是音高 0-127代表不同的音高
            // 第四个参数是音道 0-100
            a.setMessage(144, 1, 102, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch(Exception ex) {
            out.println("Bummer");
            ex.printStackTrace();
        }
    }
}
