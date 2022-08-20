package MusicBLL;

public class MusicStatus {
    private int currentOctave;
    private int currentVolume;
    private int currentInstrument;
    private int currentBpm;       // no enunciado, nenhum token muda isso, mas talvez o usuário possa escolher na hora de escrever o texto?

    public MusicStatus(int octave, int volume, int instrument, int bpm){
        currentOctave = octave;
        currentVolume = volume;
        currentInstrument = instrument;
        currentBpm = bpm;
    }

    public int getCurrentOctave(){
        return currentOctave;
    }

    public void setCurrentOctave(short currentOctave) {
        this.currentOctave = currentOctave;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(short currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getCurrentInstrument() {
        return currentInstrument;
    }

    public void setCurrentInstrument(short currentInstrument) {
        this.currentInstrument = currentInstrument;
    }
}
