package Chapter12;

import javax.sound.midi.*;

public class MiniMusicPlayer1 {
    public static void main(String []args) {
        try {
            // 通过midisystem获取一个dvd播放机
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // 实例化一个专辑
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            // 在这个专辑中创建一首空的歌曲
            Track track = seq.createTrack();
            // 通过循环的方式导入旋律和音符 使其成为一首完整的歌
            for (int i = 80; i < 120; i+=4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }
            // 将专辑导入dvd播放机中
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(200);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 产生音符旋律的函数
    private static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent instrument = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(comd, chan, one, two);
            instrument =  new MidiEvent(message, tick);
        } catch (Exception e) {
            e.getMessage();
        }
        return instrument;
    }
}
