package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public class NoteToken implements IMusicToken {
    private final String note;

    public NoteToken(String note){
        this.note = note;
    }

    public String toMusicSheet(MusicStatusController currentMusicStatus){
        return (note + currentMusicStatus.getCurrentOctave());
    }
}
