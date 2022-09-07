package Interface;
import MusicBLL.MusicDecoder;
import MusicBLL.MusicPlayer;

import java.util.Scanner;

public class InterfaceController {
    String inputString;

    public InterfaceController(String inputString){
        this.inputString = inputString;
    }

    public static void main(String[] args) {
        String inputString;
        Scanner sc = new Scanner(System.in);
        inputString = sc.nextLine();

        String musicSheet = MusicDecoder.decode(inputString);
        MusicPlayer.play(musicSheet);
    }
}
