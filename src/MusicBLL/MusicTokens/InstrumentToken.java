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

        byte instrumentByteCode = (byte)currentMusicStatus.getCurrentInstrument();
        String instrumentString = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(instrumentByteCode);
        return String.format("I[%s]", instrumentString);
    }
}
