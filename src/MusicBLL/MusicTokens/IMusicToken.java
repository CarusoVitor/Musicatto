package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;
import org.jetbrains.annotations.Nullable;

public interface IMusicToken {
    @Nullable String toMusicSheet(MusicStatusController currentMusicStatus);
}
