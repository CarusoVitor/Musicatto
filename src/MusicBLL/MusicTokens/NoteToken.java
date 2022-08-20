package MusicBLL.MusicTokens;

import MusicBLL.MusicStatus;

public class NoteToken implements IMusicToken {
    private String note;

    public NoteToken(String note){
        this.note = note;
    }

    public String toMusicSheet(MusicStatus currentMusicStatus){
        return (note + String.valueOf(currentMusicStatus.getCurrentOctave()));
    }
}
