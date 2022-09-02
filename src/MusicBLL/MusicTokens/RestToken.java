package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public class RestToken implements IMusicToken {
    public String toMusicSheet(MusicStatusController currentMusicStatus){
        return "R";
    }
}
