package MusicBLL;

import MusicBLL.MusicConstants.MusicConstraints;

public class MusicStatusController {
    private int currentOctave;
    private int currentVolume;
    private int currentInstrument;
    private final int currentBpm;       // no enunciado, nenhum token muda isso, mas talvez o usuário possa escolher na hora de escrever o texto?

    public MusicStatusController(int octave, int volume, int instrument, int bpm){
        currentOctave = octave;
        currentVolume = volume;
        currentInstrument = instrument;
        currentBpm = bpm;
    }

    public int getCurrentBpm() { return currentBpm; }

    public int getCurrentOctave(){
        return currentOctave;
    }

    public void setCurrentOctave(int octave) {
        this.currentOctave = octave;
    }

    public void increaseCurrentOctave() {
        if (currentOctave + 1 <= MusicConstraints.OctaveMaxValue)
            setCurrentOctave(currentOctave + 1);
        else
            setCurrentOctave(MusicConstraints.OctaveDefaultValue);
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    private void setCurrentVolume(int volume) {
        this.currentVolume = volume;
    }

    public void DoubleVolume() {
        int doubleVolume = getCurrentVolume() * 2;

        if (isValidVolume(doubleVolume))
            setCurrentVolume(doubleVolume);
        else
            setCurrentVolume(MusicConstraints.VolumeDefaultValue);
    }

    public int getCurrentInstrument() {
        return currentInstrument;
    }

    public void setCurrentInstrument(int instrument) {
        if (isValidInstrument(instrument))
            this.currentInstrument = instrument;
    }

    private boolean isValidVolume(int volume){
        return volume <= MusicConstraints.VolumeMaxValue && volume >= MusicConstraints.VolumeMinValue;
    }

    private boolean isValidInstrument(int instrument){
        return instrument <= MusicConstraints.InstrumentMaxCode && instrument >= MusicConstraints.InstrumentMinCode;
    }
}
