package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import MusicBLL.MusicPlayer;
import MusicBLL.MusicDecoder;
import javafx.stage.FileChooser;

import java.io.File;

public class InterfaceController {
    @FXML TextArea textArea;

    @FXML
    public void onPlayButtonClicked() {
        String inputString = textArea.getText();

        String musicSheet = MusicDecoder.decode(inputString);

        MusicPlayer.play(musicSheet);
    }

    @FXML
    public void onDownloadButtonClicked() {
        String inputString = textArea.getText();

        String musicSheet = MusicDecoder.decode(inputString);

        MusicPlayer.download(musicSheet, "test.mid");

    }

    @FXML
    public void onUploadButtonClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files", "*.txt"));
        File f = fileChooser.showOpenDialog(null);
    }

}
