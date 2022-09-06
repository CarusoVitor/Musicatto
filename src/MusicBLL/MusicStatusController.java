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

    public int getCurrentOctave(){
        return currentOctave;
    }

    public void setCurrentOctave(int octave) {
        this.currentOctave = octave;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        if (isValidVolume(volume))
            this.currentVolume = volume;
    }

    public int getCurrentInstrument() {
        return currentInstrument;
    }

    public void setCurrentInstrument(int instrument) {
        if (isValidInstrument(instrument))
            this.currentInstrument = instrument;
    }

    private boolean isValidVolume(int volume){
        return volume <= MusicConstraints.InstrumentMaxCode && volume >= MusicConstraints.InstrumentMinCode;
    }

    private boolean isValidInstrument(int instrument){
        return instrument <= MusicConstraints.InstrumentMaxCode && instrument >= MusicConstraints.InstrumentMinCode;
    }
}
