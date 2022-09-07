package MusicTests;

import MusicBLL.MusicDecoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import MusicBLL.MusicConstants.InstrumentsMidiCode;

public class MusicDecoderTests {
    @Test
    public void testChangeInstrumentToAgogo(){
        String musicSheet = MusicDecoder.decode("A!C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Agogo));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalO(){
        String musicSheet = MusicDecoder.decode("AOC");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalo() {
        String musicSheet2 = MusicDecoder.decode("AoC");
        Assertions.assertEquals(musicSheet2, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalI() {
        String musicSheet3 = MusicDecoder.decode("AIC");
        Assertions.assertEquals(musicSheet3, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocali() {
        String musicSheet4 = MusicDecoder.decode("AiC");
        Assertions.assertEquals(musicSheet4, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalU() {
        String musicSheet5 = MusicDecoder.decode("AUC");
        Assertions.assertEquals(musicSheet5, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalu() {
        String musicSheet6 = MusicDecoder.decode("AuC");
        Assertions.assertEquals(musicSheet6, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.Harpsichord));
    }

    @Test
    public void testDecodeConsonants(){
        String musicSheet = MusicDecoder.decode("Aabc");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 A5 R R");
    }

    @Test
    public void testChangeInstrumentDigit_Instrument4(){
        String musicSheet = MusicDecoder.decode("A4C");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 I[4] C5");
    }

    @Test
    public void testChangeInstrumentDigit_Instrument3(){
        String musicSheet2 = MusicDecoder.decode("A3C");
        Assertions.assertEquals(musicSheet2, "T[120] :CE(Volume,1000) I[0] A5 I[3] C5");
    }

    @Test
    public void testChangeInstrumentDigitOutOfBounds() {
        String musicSheet = MusicDecoder.decode("A!99");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 I[114] I[123] I[123]");
    }

    @Test
    public void testIncreaseOctave(){
        String musicSheet = MusicDecoder.decode("A?B");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 B6");
    }

    @Test
    public void testChangeInstrumentToTubularBells(){
        String musicSheet = MusicDecoder.decode("A\nC");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.TubularBells));
    }

    @Test
    public void testChangeInstrumentToPanFlute(){
        String musicSheet = MusicDecoder.decode("A;C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.PanFlute));
    }

    @Test
    public void testChangeInstrumentToChurchOrgan(){
        String musicSheet = MusicDecoder.decode("A,C");
        Assertions.assertEquals(musicSheet, String.format("T[120] :CE(Volume,1000) I[0] A5 I[%d] C5", InstrumentsMidiCode.ChurchOrgan));
    }

    @Test
    public void testDecodeElseCharacters(){
        String musicSheet = MusicDecoder.decode("A[]-");
        Assertions.assertEquals(musicSheet, "T[120] :CE(Volume,1000) I[0] A5 A5 R R");
    }
}
