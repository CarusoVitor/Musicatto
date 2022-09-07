package MusicTests;

import MusicBLL.MusicDecoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MusicDecoderTests {
    @Test
    public void testChangeInstrumentToAgogo(){
        String musicSheet = MusicDecoder.decode("A!C");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Agogo] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalO(){
        String musicSheet = MusicDecoder.decode("AOC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalo() {
        String musicSheet = MusicDecoder.decode("AoC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalI() {
        String musicSheet = MusicDecoder.decode("AIC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocali() {
        String musicSheet = MusicDecoder.decode("AiC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalU() {
        String musicSheet = MusicDecoder.decode("AUC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalu() {
        String musicSheet = MusicDecoder.decode("AuC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Harpsichord] C5");
    }

    @Test
    public void testDecodeConsonants(){
        String musicSheet = MusicDecoder.decode("Aabc");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 A5 R R");
    }

    @Test
    public void testChangeInstrumentDigit_Instrument4(){
        String musicSheet = MusicDecoder.decode("A4C");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Electric_Piano] C5");
    }

    @Test
    public void testChangeInstrumentDigit_Instrument3(){
        String musicSheet2 = MusicDecoder.decode("A3C");
        Assertions.assertEquals(musicSheet2, "T120 :CE(Volume,1000) I[Piano] A5 I[Honkey_Tonk] C5");
    }

    @Test
    public void testChangeInstrumentDigitOutOfBounds() {
        String musicSheet = MusicDecoder.decode("A!99");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Agogo] I[Seashore] I[Seashore]");
    }

    @Test
    public void testIncreaseOctave(){
        String musicSheet = MusicDecoder.decode("A?B");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 B6");
    }

    @Test
    public void testChangeInstrumentToTubularBells(){
        String musicSheet = MusicDecoder.decode("A\nC");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Tubular_Bells] C5");
    }

    @Test
    public void testChangeInstrumentToPanFlute(){
        String musicSheet = MusicDecoder.decode("A;C");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Pan_Flute] C5");
    }

    @Test
    public void testChangeInstrumentToChurchOrgan(){
        String musicSheet = MusicDecoder.decode("A,C");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 I[Church_Organ] C5");
    }

    @Test
    public void testDecodeElseCharacters(){
        String musicSheet = MusicDecoder.decode("A[]-");
        Assertions.assertEquals(musicSheet, "T120 :CE(Volume,1000) I[Piano] A5 A5 R R");
    }
}
