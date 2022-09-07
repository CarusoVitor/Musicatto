package MusicBLL;

import MusicBLL.MusicConstants.MusicConstraints;

public class MusicStatusController {
    private int currentOctave;
    private int currentVolume;
    private int currentInstrument;
    private int currentBpm;       // no enunciado, nenhum token muda isso, mas talvez o usuário possa escolher na hora de escrever o texto?

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
            currentOctave += 1;
        else
            currentOctave = MusicConstraints.OctaveDefaultValue;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void DoubleVolume() {
        int doubleVolume = getCurrentVolume() * 2;

        if (isValidVolume(doubleVolume))
            this.currentVolume = doubleVolume;
        else
            this.currentVolume = MusicConstraints.VolumeDefaultValue;
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
