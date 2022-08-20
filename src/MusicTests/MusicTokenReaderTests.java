package MusicTests;

import MusicBLL.MusicStatus;
import MusicBLL.MusicTokens.IMusicToken;
import MusicBLL.MusicTokens.NoteToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MusicTokenReaderTests {
    private static MusicStatus musicStatus;

    @BeforeAll
    static void init(){
        musicStatus = new MusicStatus(4, 16, 18, 90);
    }

    @Test
    public void convertNoteToMusicSheet(){
        IMusicToken note = new NoteToken("A");
        Assertions.assertEquals("A4", note.toMusicSheet(musicStatus));
    }
}
