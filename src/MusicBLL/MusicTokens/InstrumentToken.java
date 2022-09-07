package MusicBLL.MusicTokens;

import MusicBLL.MusicStatusController;
import org.jfugue.midi.MidiDictionary;

public class InstrumentToken implements IMusicToken{
    private final int instrument;

    public InstrumentToken(int instrument) {
        this.instrument = instrument;
    }

    public String toMusicSheet(MusicStatusController currentMusicStatus) {
        currentMusicStatus.setCurrentInstrument(instrument);
        String instrumentString = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get((byte)currentMusicStatus.getCurrentInstrument());
        return String.format("I[%s]", instrumentString);
    }
}
