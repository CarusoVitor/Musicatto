package MusicTests;

import MusicBLL.MusicDecoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import MusicBLL.MusicConstants;

public class MusicDecoderTests {
    @Test
    public void testChangeInstrumentToAgogo(){
        String musicSheet = MusicDecoder.decode("A!C");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Agogo] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalO(){
        String musicSheet = MusicDecoder.decode("AOC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalo() {
        String musicSheet = MusicDecoder.decode("AoC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalI() {
        String musicSheet = MusicDecoder.decode("AIC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocali() {
        String musicSheet = MusicDecoder.decode("AiC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_VocalU() {
        String musicSheet = MusicDecoder.decode("AUC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToHarpsichord_Vocalu() {
        String musicSheet = MusicDecoder.decode("AuC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Harpsichord] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testDecodeConsonants(){
        String musicSheet = MusicDecoder.decode("Aabc");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 A5 R R", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentDigit_Instrument4(){
        String musicSheet = MusicDecoder.decode("A4C");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Electric_Piano] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentDigit_Instrument3(){
        String musicSheet = MusicDecoder.decode("A3C");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Honkey_Tonk] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentDigitOutOfBounds() {
        String musicSheet = MusicDecoder.decode("A!99");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Agogo] I[Seashore] I[Seashore]", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testIncreaseOctave(){
        String musicSheet = MusicDecoder.decode("A?B");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 B6", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToTubularBells(){
        String musicSheet = MusicDecoder.decode("A\nC");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Tubular_Bells] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToPanFlute(){
        String musicSheet = MusicDecoder.decode("A;C");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Pan_Flute] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testChangeInstrumentToChurchOrgan(){
        String musicSheet = MusicDecoder.decode("A,C");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 I[Church_Organ] C5", MusicConstants.VolumeDefaultValue));
    }

    @Test
    public void testDecodeElseCharacters(){
        String musicSheet = MusicDecoder.decode("A[]-");
        Assertions.assertEquals(musicSheet, String.format(":CE(935,%d) A5 A5 R R", MusicConstants.VolumeDefaultValue));
    }
}
