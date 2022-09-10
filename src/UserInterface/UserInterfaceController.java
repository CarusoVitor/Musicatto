package UserInterface;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import MusicBLL.MusicPlayer;
import MusicBLL.MusicDecoder;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UserInterfaceController {
    @FXML
    TextArea textArea;

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

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        UserInterfaceConstants.SaveFileFilterTitle,
                        UserInterfaceConstants.SaveFileFilterExtension)
        );

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            MusicPlayer.download(musicSheet, file.getAbsolutePath());
        }
    }

    @FXML
    public void onUploadButtonClicked() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        UserInterfaceConstants.OpenFileFilterTitle,
                        UserInterfaceConstants.OpenFileFilterExtension)
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Path filePath = Path.of(file.getAbsolutePath());
            String newInputString = Files.readString(filePath);
            String inputStringTextArea = textArea.getText();
            textArea.setText(inputStringTextArea + newInputString);
        }
    }
}
