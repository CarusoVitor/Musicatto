package MusicTests;

import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicStatusController;
import MusicBLL.MusicTokens.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MusicTokensTests {
    private static MusicStatusController musicStatus;

    @BeforeAll
    static void init(){
        musicStatus = new MusicStatusController(MusicConstraints.OctaveDefaultValue, MusicConstraints.VolumeDefaultValue, 18, 90);
    }

    @Test
    public void testConvertNoteToMusicSheet(){
        IMusicToken note = new NoteToken("A");
        Assertions.assertEquals("A5", note.toMusicSheet(musicStatus));
    }
    @Test
    public void testConvertRestToMusicSheet(){
        IMusicToken rest = new RestToken();
        Assertions.assertEquals("R", rest.toMusicSheet(musicStatus));
    }
    @Test
    public void testChangeInstrument(){
        IMusicToken instrument = new InstrumentToken(16);
        Assertions.assertEquals("I[16]", instrument.toMusicSheet(musicStatus));
        Assertions.assertEquals(16, musicStatus.getCurrentInstrument());
    }
    @Test
    public void testInstrumentOutOfRange_1(){
        IMusicToken instrument = new InstrumentToken(150);
        Assertions.assertEquals("I[18]", instrument.toMusicSheet(musicStatus));
        Assertions.assertEquals(18, musicStatus.getCurrentInstrument());
    }

    @Test
    public void testInstrumentOutOfRange_2(){
        IMusicToken instrument = new InstrumentToken(-5);
        Assertions.assertEquals("I[18]", instrument.toMusicSheet(musicStatus));
        Assertions.assertEquals(18, musicStatus.getCurrentInstrument());
    }

    @Test
    public void testConvertVolumeToken(){
        IMusicToken volume = new VolumeToken();
        Assertions.assertEquals(":CE(Volume,2000)", volume.toMusicSheet(musicStatus));
        Assertions.assertEquals(2000, musicStatus.getCurrentVolume());
        Assertions.assertEquals(":CE(Volume,4000)", volume.toMusicSheet(musicStatus));
        Assertions.assertEquals(4000, musicStatus.getCurrentVolume());
        Assertions.assertEquals(":CE(Volume,8000)", volume.toMusicSheet(musicStatus));
        Assertions.assertEquals(8000, musicStatus.getCurrentVolume());
        Assertions.assertEquals(":CE(Volume,16000)", volume.toMusicSheet(musicStatus));
        Assertions.assertEquals(16000, musicStatus.getCurrentVolume());
        Assertions.assertEquals(":CE(Volume,1000)", volume.toMusicSheet(musicStatus));
        Assertions.assertEquals(1000, musicStatus.getCurrentVolume());
    }
}
