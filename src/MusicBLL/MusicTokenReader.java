package MusicBLL;

import MusicBLL.MusicConstants.InstrumentsMidiCode;
import MusicBLL.MusicTokens.*;

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
                lastToken = new InstrumentToken(InstrumentsMidiCode.Harpsichord);
                return lastToken;

            case "!":
                lastToken = new InstrumentToken(InstrumentsMidiCode.Agogo);
                return lastToken;

            case "\n":
                lastToken = new InstrumentToken(InstrumentsMidiCode.TubularBells);
                return lastToken;

            case ";":
                lastToken = new InstrumentToken(InstrumentsMidiCode.PanFlute);
                return lastToken;

            case ",":
                lastToken = new InstrumentToken(InstrumentsMidiCode.ChurchOrgan);
                return lastToken;

            case "?":
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
