package MusicBLL;

public class MusicStatusController {
    private int currentOctave;
    private int currentVolume;
    private int currentInstrument;

    public MusicStatusController(int octave, int volume, int instrument){
        currentOctave = octave;
        currentVolume = volume;
        currentInstrument = instrument;
    }

    public int getCurrentOctave(){
        return currentOctave;
    }

    private void setCurrentOctave(int octave) {
        this.currentOctave = octave;
    }

    public void increaseCurrentOctave() {
        if (currentOctave + 1 <= MusicConstants.OctaveMaxValue)
            setCurrentOctave(currentOctave + 1);
        else
            setCurrentOctave(MusicConstants.OctaveDefaultValue);
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
            setCurrentVolume(MusicConstants.VolumeDefaultValue);
    }

    public int getCurrentInstrument() {
        return currentInstrument;
    }

    public void setCurrentInstrument(int instrument) {
        if (isValidInstrument(instrument))
            this.currentInstrument = instrument;
    }

    private boolean isValidVolume(int volume){
        return volume <= MusicConstants.VolumeMaxValue && volume >= MusicConstants.VolumeMinValue;
    }

    private boolean isValidInstrument(int instrument){
        return instrument <= MusicConstants.InstrumentMaxCode && instrument >= MusicConstants.InstrumentMinCode;
    }
}
