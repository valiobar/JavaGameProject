package FX;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;


/**
 * Created by vb on 15.4.2016 г..
 */
public class AudioLoader {
    public static Clip loadAudio(String path) {
        Clip clip=null;
        try
        {
            clip = AudioSystem.getClip();
            URL soundUrl=AudioLoader.class.getResource(path);

            clip.open(AudioSystem.getAudioInputStream(soundUrl));

        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
        return clip;
    }
    }

