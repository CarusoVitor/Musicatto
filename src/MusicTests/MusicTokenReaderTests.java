package MusicTests;

import MusicBLL.MusicConstants;
import MusicBLL.MusicStatusController;
import MusicBLL.MusicTokenReader;
import MusicBLL.MusicTokens.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MusicTokenReaderTests {
    private static MusicStatusController musicStatus;

    @BeforeEach
    public void init() {
        musicStatus = new MusicStatusController(
                MusicConstants.OctaveDefaultValue,
                MusicConstants.VolumeDefaultValue,
                MusicConstants.InstrumentDefaultCode);
    }

    @Test
    public void testNoteToken() {
        MusicTokenReader tokenReader = new MusicTokenReader("D");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof NoteToken);
    }

    @Test
    public void testRepeatNoteToken() {
        MusicTokenReader tokenReader = new MusicTokenReader("D-");
        tokenReader.getNextToken(musicStatus);
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof NoteToken);
    }

    @Test
    public void testOctaveToken() {
        MusicTokenReader tokenReader = new MusicTokenReader("?");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof OctaveToken);
    }

    @Test
    public void testRestToken() {
        MusicTokenReader tokenReader = new MusicTokenReader("?/");
        tokenReader.getNextToken(musicStatus);
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof RestToken);
    }

    @Test
    public void testVolumeToken() {
        MusicTokenReader tokenReader = new MusicTokenReader(" ");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof VolumeToken);
    }

    @Test
    public void testInstrumentToken() {
        MusicTokenReader tokenReader = new MusicTokenReader("8");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testInstrumentTokenAgogo() {
        MusicTokenReader tokenReader = new MusicTokenReader("!");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testInstrumentTokenHarpsichord() {
        MusicTokenReader tokenReader = new MusicTokenReader("u");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testInstrumentTokenTubularBells() {
        MusicTokenReader tokenReader = new MusicTokenReader("\n");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testInstrumentTokenPanFlute() {
        MusicTokenReader tokenReader = new MusicTokenReader(";");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testInstrumentTokenChurchOrgan() {
        MusicTokenReader tokenReader = new MusicTokenReader(",");
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof InstrumentToken);
    }

    @Test
    public void testStringWithMoreThanOneChar() {
        MusicTokenReader tokenReader = new MusicTokenReader("D?");
        tokenReader.getNextToken(musicStatus);
        IMusicToken token = tokenReader.getNextToken(musicStatus);
        Assertions.assertTrue(token instanceof OctaveToken);
    }
}
