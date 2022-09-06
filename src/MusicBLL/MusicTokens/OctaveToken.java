package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public class OctaveToken implements IMusicToken{
    public String toMusicSheet(MusicStatusController currentMusicStatus) {
        currentMusicStatus.increaseCurrentOctave();
        return null;
    }
}
