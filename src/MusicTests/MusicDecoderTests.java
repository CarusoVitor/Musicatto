package MusicTests;

import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicDecoder;
import MusicBLL.MusicStatusController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import MusicBLL.MusicConstants.InstrumentsMidiCode;

public class MusicDecoderTests {
    private static MusicDecoder musicDecoder;

    @BeforeAll
    static void init(){
        musicDecoder = new MusicDecoder(
                new MusicStatusController(
                        MusicConstraints.OctaveDefaultValue,
                        MusicConstraints.VolumeDefaultValue,
                        MusicConstraints.InstrumentDefaultCode,
                        MusicConstraints.BPMDefaultValue
                )
        );
    }

    @Test
    public void testChangeInstrumentToAgogo(){
        String musicSheet = musicDecoder.decode("A!C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Agogo));
    }

    @Test
    public void testChangeInstrumentToHarpsichord(){
        String musicSheet = musicDecoder.decode("AOC");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

        String musicSheet2 = musicDecoder.decode("AoC");
        Assertions.assertEquals(musicSheet2, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

        String musicSheet3 = musicDecoder.decode("AIC");
        Assertions.assertEquals(musicSheet3, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

        String musicSheet4 = musicDecoder.decode("AiC");
        Assertions.assertEquals(musicSheet4, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

        String musicSheet5 = musicDecoder.decode("AUC");
        Assertions.assertEquals(musicSheet5, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

        String musicSheet6 = musicDecoder.decode("AuC");
        Assertions.assertEquals(musicSheet6, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));

    }

    @Test
    public void testDecodeConsonants(){
        String musicSheet = musicDecoder.decode("Aabc");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 A5 R R");
    }

    @Test
    public void testChangeInstrumentDigit(){
        String musicSheet = musicDecoder.decode("A4C");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 I[4] C5");

        String musicSheet2 = musicDecoder.decode("A3C");
        Assertions.assertEquals(musicSheet2, "T[120] :CE(Volume,1000) I[0] A5 I[3] C5");
    }

//    @Test
//    public void testChangeInstrumentDigitOutOfBounds() {
//        String musicSheet = musicDecoder.decode("A99");
//        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 I[9]");
//    }

    @Test
    public void testIncreaseOctave(){
        String musicSheet = musicDecoder.decode("A?B");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 B6");
    }

    @Test
    public void testChangeInstrumentToTubularBells(){
        String musicSheet = musicDecoder.decode("A\nC");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.TubularBells));
    }

    @Test
    public void testChangeInstrumentToPanFlute(){
        String musicSheet = musicDecoder.decode("A;C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.PanFlute));
    }

    @Test
    public void testChangeInstrumentToChurchOrgan(){
        String musicSheet = musicDecoder.decode("A,C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.ChurchOrgan));
    }

    @Test
    public void testDecodeElseCharacters(){
        String musicSheet = musicDecoder.decode("A[]-");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 A5 R R");
    }
}
