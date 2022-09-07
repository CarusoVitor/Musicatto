package MusicBLL;


import MusicBLL.MusicConstants.MusicConstraints;
import MusicBLL.MusicTokens.IMusicToken;


public class MusicDecoder {
    private MusicStatusController statusController;

    public MusicDecoder(MusicStatusController statusController){
        this.statusController = statusController;
    }

    public void setStatusController(MusicStatusController statusController){
        this.statusController = statusController;
    }

    private String initMusicSheet(){
        String startingInstrument = String.format("I[%d]", statusController.getCurrentInstrument());
        String startingBPM = String.format("T[%d]", statusController.getCurrentBpm());
        String startingVolume = String.format(":CE(Volume,%d)", statusController.getCurrentVolume());
        return startingBPM + " " + startingVolume + " " + startingInstrument + " ";
    }

    public String decode(String inputString){
        MusicTokenReader tokenReader = new MusicTokenReader(inputString);
        StringBuilder musicSheet = new StringBuilder(initMusicSheet());

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
