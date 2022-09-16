package MusicBLL;

import MusicBLL.MusicTokens.*;
import org.jfugue.midi.MidiDictionary;

public class MusicTokenReader {
    private final String input;
    private int currentIndex;

    private IMusicToken lastToken;

    public MusicTokenReader(String input){
        this.input = input;
        currentIndex = 0;
    }

    public boolean hasRemainingTokens(){
        return currentIndex < input.length();
    }

    public IMusicToken getNextToken(MusicStatusController musicStatus){
        String token;
        if(hasRemainingTokens()){
            token = input.substring(currentIndex, currentIndex + 1);
            currentIndex++;
        }
        else{
            throw new StringIndexOutOfBoundsException();
        }

        switch(token){
            case "A", "B", "C", "D", "E", "F", "G":
                lastToken = new NoteToken(token);
                return lastToken;

            case " ":
                lastToken = new VolumeToken();
                return lastToken;

            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":
                lastToken = new InstrumentToken(musicStatus.getCurrentInstrument() + Integer.parseInt(token));
                return lastToken;

            case "i", "I", "o", "O", "u", "U":
                lastToken = new InstrumentToken((int) MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get("HARPSICHORD"));
                return lastToken;

            case "!":
                lastToken = new InstrumentToken((int) MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get("AGOGO"));
                return lastToken;

            case "\n":
                lastToken = new InstrumentToken((int) MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get("TUBULAR_BELLS"));
                return lastToken;

            case ";":
                lastToken = new InstrumentToken((int) MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get("PAN_FLUTE"));
                return lastToken;

            case ",":
                lastToken = new InstrumentToken((int) MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get("CHURCH_ORGAN"));
                return lastToken;

            case "?", ".":
                lastToken = new OctaveToken();
                return lastToken;

            default:
                if(lastToken instanceof NoteToken lastNote) {
                    lastToken = new RestToken();
                    return lastNote;
                }
                else{
                    lastToken = new RestToken();
                    return lastToken;
                }
        }
    }
}
