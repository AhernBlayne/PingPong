package pong;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class playmusic  {

    private String audio;

    public playmusic(){

    }

    /*Code added here by JB to fix compilation errors relating to old API being used for sound. The idea came from
     *https://stackoverflow.com/questions/27343711/audioplayer-is-internal-proprietary-api-and-may-be-removed-in-a-future-release
     **/
    public playmusic(String audio){
        //setting attributes values directly)
        try{
            InputStream music = new FileInputStream(new File(audio));

            InputStream bufferedIn = new BufferedInputStream(music);

            AudioInputStream stream = AudioSystem.getAudioInputStream(bufferedIn);

            AudioFormat format = stream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip clip = (Clip) AudioSystem.getLine(info);

            clip.open(stream);

            clip.loop(0);

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }


    public void setaudio(String audio) {
        this.audio = audio;
    }
    public String getaudio() {
        return audio;
    }

};
