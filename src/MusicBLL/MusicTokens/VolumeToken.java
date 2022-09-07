package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public class VolumeToken implements IMusicToken{
    public String toMusicSheet(MusicStatusController currentMusicStatus) {
        currentMusicStatus.DoubleVolume();
        return String.format(":CE(935,%d)", currentMusicStatus.getCurrentVolume());
    }
}
