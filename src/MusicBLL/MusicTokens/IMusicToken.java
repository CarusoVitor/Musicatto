package MusicBLL.MusicTokens;

import MusicBLL.MusicStatus;

public interface IMusicToken {
    public String toMusicSheet(MusicStatus currentMusicStatus);
}
