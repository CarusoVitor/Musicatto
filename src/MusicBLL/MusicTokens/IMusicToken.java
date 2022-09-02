package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public interface IMusicToken {
    public String toMusicSheet(MusicStatusController currentMusicStatus);
}
