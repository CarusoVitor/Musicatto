package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;

public class InstrumentToken implements IMusicToken{
    private int instrument;
    public InstrumentToken(int instrument) {
        this.instrument = instrument;
    }
    public String toMusicSheet(MusicStatusController currentMusicStatus) {
        currentMusicStatus.setCurrentInstrument(instrument);
        return String.format("I[%d]", currentMusicStatus.getCurrentInstrument());
    }

}
