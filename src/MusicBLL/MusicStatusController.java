package MusicBLL;

public class MusicStatusController {
    public final int MAX_INSTRUMENT = 127;
    public final int MIN_INSTRUMENT = 0;
    public final int MAX_VOLUME = 127;
    public final int MIN_VOLUME = 0;


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
        return volume <= MAX_VOLUME && volume >= MIN_VOLUME;
    }

    private boolean isValidInstrument(int instrument){
        return instrument <= MAX_INSTRUMENT && instrument >= MIN_INSTRUMENT;
    }
}
