package MusicTests;

import MusicBLL.MusicStatusController;
import MusicBLL.MusicTokens.IMusicToken;
import MusicBLL.MusicTokens.NoteToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MusicTokensTests {
    private static MusicStatusController musicStatus;

    @BeforeAll
    static void init(){
        musicStatus = new MusicStatusController(4, 16, 18, 90);
    }

    @Test
    public void convertNoteToMusicSheet(){
        IMusicToken note = new NoteToken("A");
        Assertions.assertEquals("A4", note.toMusicSheet(musicStatus));
    }
}
