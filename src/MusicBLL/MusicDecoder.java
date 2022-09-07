package MusicBLL;


import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicTokens.IMusicToken;


public class MusicDecoder {
    private static MusicStatusController getDefaultMusicStatusController(){
        return new MusicStatusController(
                MusicConstraints.OctaveDefaultValue,
                MusicConstraints.VolumeDefaultValue,
                MusicConstraints.InstrumentDefaultCode,
                MusicConstraints.BPMDefaultValue
        );
    }

    private static String initMusicSheet(MusicStatusController statusController){
        String startingInstrument = String.format("I[%d]", statusController.getCurrentInstrument());
        String startingBPM = String.format("T[%d]", statusController.getCurrentBpm());
        String startingVolume = String.format(":CE(Volume,%d)", statusController.getCurrentVolume());
        return startingBPM + " " + startingVolume + " " + startingInstrument + " ";
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
