package MusicTests;

import MusicBLL.MusicDecoder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MusicDecoderTests {
    private final MusicDecoder musicDecoder = new MusicDecoder();

    @Test
    public void testDecodeElseCharacters(){
        String musicSheet = musicDecoder.decode("A[]-");
        Assertions.assertEquals(musicSheet, "T[120] CE:(Volume,1000) I[0] A5 A5 R R");
    }

    @Test
    public void testChangeInstrumentToAgogo(){
        String musicSheet = musicDecoder.decode("A!C");
        Assertions.assertEquals(musicSheet, "T[120] CE:(Volume,1000) I[0] A5 I[114] C5");
    }
}
