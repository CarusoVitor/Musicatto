package MusicBLL;

import MusicBLL.MusicTokens.IMusicToken;
import MusicBLL.MusicTokens.NoteToken;
import MusicBLL.MusicTokens.RestToken;

public class MusicTokenReader {
    private String input;
    private int currentIndex;

    private IMusicToken lastToken;

    public MusicTokenReader(String input){
        this.input = input;
        currentIndex = 0;
    }

    public IMusicToken getNextToken(){
        String token = input.substring(currentIndex, currentIndex + 1);
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
