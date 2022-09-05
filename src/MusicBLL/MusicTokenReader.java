package MusicBLL;

import MusicBLL.MusicTokens.IMusicToken;
import MusicBLL.MusicTokens.NoteToken;
import MusicBLL.MusicTokens.RestToken;

import javax.lang.model.type.ErrorType;

public class MusicTokenReader {
    private String input;
    private int currentIndex;

    private IMusicToken lastToken;

    public MusicTokenReader(String input){
        this.input = input;
        currentIndex = 0;
    }

    public boolean hasRemainingTokens(){
        return currentIndex < input.length();
    }

    public IMusicToken getNextToken(){
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
                lastToken =  new NoteToken(token);
                return lastToken;

            default:
                if(lastToken instanceof NoteToken) {
                    NoteToken lastNote = (NoteToken)lastToken;
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
