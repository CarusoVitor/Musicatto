package MusicBLL;


import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicTokens.IMusicToken;
import MusicBLL.MusicTokens.VolumeToken;
import org.staccato.InstructionPreprocessor;


public class MusicDecoder {
    private MusicStatusController statusController = new MusicStatusController(
            MusicConstraints.OctaveDefaultValue,
            MusicConstraints.VolumeDefaultValue,
            MusicConstraints.InstrumentDefaultCode,
            MusicConstraints.BPMDefaultCode);


    private String initMusicSheet(){
        String startingInstrument = String.format("I[%d]", MusicConstraints.InstrumentDefaultCode);
        String startingBPM = String.format("T[%d]", MusicConstraints.BPMDefaultCode);
        String startingVolume = String.format("CE:(Volume,%d)", MusicConstraints.VolumeDefaultValue);

        return startingBPM + " " + startingVolume + " " + startingInstrument;
    }

    public String decode(String inputString){
        MusicTokenReader tokenReader = new MusicTokenReader(inputString);
        IMusicToken token;
        StringBuilder musicSheet = new StringBuilder(initMusicSheet());

        while (tokenReader.hasRemainingTokens()){
            String convertedToken;
            token = tokenReader.getNextToken(statusController);
            convertedToken = token.toMusicSheet(statusController);

            musicSheet.append(" ");

            if (convertedToken != null)
                musicSheet.append(convertedToken);
        }
        return musicSheet.toString();
    }
}
