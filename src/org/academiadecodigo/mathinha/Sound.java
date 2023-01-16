package org.academiadecodigo.mathinha;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    private Clip clip;
    private URL[] soundURL = new URL[3];
    public Sound(int chosenSound) {
        init();
        setFile(chosenSound);
    }
    public void init(){
        soundURL[0] = getClass().getResource("hard-rock-intro.wav");
        soundURL[1] = getClass().getResource("guitar-effect2.wav");
        soundURL[2] = getClass().getResource("DeepPurple_SmokeOnTheWater.wav");
    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }
    public void play() {
        try {
            // 0.8 seconds start delay
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
