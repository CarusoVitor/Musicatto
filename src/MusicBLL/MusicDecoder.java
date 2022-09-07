package MusicBLL;


import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicTokens.IMusicToken;


public class MusicDecoder {

    private String initMusicSheet(){
        String startingInstrument = String.format("I[%d]", MusicConstraints.InstrumentDefaultCode);
        String startingBPM = String.format("T[%d]", MusicConstraints.BPMDefaultCode);
        String startingVolume = String.format(":CE(Volume,%d)", MusicConstraints.VolumeDefaultValue);
        return startingBPM + " " + startingVolume + " " + startingInstrument + " ";
    }

    public String decode(String inputString){
        MusicStatusController statusController = new MusicStatusController(
                MusicConstraints.OctaveDefaultValue,
                MusicConstraints.VolumeDefaultValue,
                MusicConstraints.InstrumentDefaultCode,
                MusicConstraints.BPMDefaultCode);

        MusicTokenReader tokenReader = new MusicTokenReader(inputString);
        IMusicToken token;
        StringBuilder musicSheet = new StringBuilder(initMusicSheet());

        while (tokenReader.hasRemainingTokens()){
            String convertedToken;
            token = tokenReader.getNextToken(statusController);
            convertedToken = token.toMusicSheet(statusController);

            if (convertedToken != null) {
                musicSheet.append(convertedToken);
                musicSheet.append(" ");
            }
        }
        return musicSheet.toString().trim();
    }
}
