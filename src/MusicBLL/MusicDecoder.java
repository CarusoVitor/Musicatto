package MusicBLL;

import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicTokens.IMusicToken;
import org.jfugue.midi.MidiDictionary;


public class MusicDecoder {
    private static MusicStatusController getDefaultMusicStatusController(){
        return new MusicStatusController(
                MusicConstraints.OctaveDefaultValue,
                MusicConstraints.VolumeDefaultValue,
                MusicConstraints.InstrumentDefaultCode,
                MusicConstraints.BPMDefaultValue
        );
    }
//
//    public void setStatusController(MusicStatusController statusController){
//        this.statusController = statusController;
//    }

    private static String initMusicSheet(MusicStatusController statusController){
        String startingVolume = String.format(":CE(935,%d)", statusController.getCurrentVolume());
        return startingVolume + " ";
    }

    public static String decode(String inputString){
        MusicStatusController statusController = getDefaultMusicStatusController();
        StringBuilder musicSheet = new StringBuilder(initMusicSheet(statusController));

        MusicTokenReader tokenReader = new MusicTokenReader(inputString);

        while (tokenReader.hasRemainingTokens()){
            IMusicToken token = tokenReader.getNextToken(statusController);
            String convertedToken = token.toMusicSheet(statusController);

            if (convertedToken != null) {
                musicSheet.append(convertedToken);
                musicSheet.append(" ");
            }
        }
        return musicSheet.toString().trim();
    }
}
