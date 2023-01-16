package org.academiadecodigo.mathinha.grid;

import org.academiadecodigo.mathinha.KeyDude;
import org.academiadecodigo.mathinha.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class BaseGrid implements Grid, KeyboardHandler {

    public static final int PADDING = 10;
    public static final int CELLSIZE = 60;
    public static int maxCols;
    public static int maxRows;
    Picture background;
    Sound soundIntro;
    Sound soundFX;
    Sound soundDeepPurple;

    KeyboardEvent spacePressed;
    KeyboardEvent enterPressed;
    KeyDude Andre = new KeyDude();
    Keyboard kb;

    public static int countScore = 0;
    public static Text score;

    Buttons bt = new Buttons(20);
    Picture menu = new Picture(PADDING, PADDING, "game-init.png");
    Picture instructions = new Picture(PADDING, PADDING, "game-instructions.png");


    public BaseGrid(int maxCols, int maxRows) {
        this.maxCols = maxCols;
        this.maxRows = maxRows;

        menu.draw();

        /**
         * Sounds
         */
        soundIntro = new Sound(0);
        soundIntro.init();
        soundIntro.loop();

        soundFX = new Sound(1);
        soundFX.init();

        soundDeepPurple = new Sound(2);

        score = new Text(PADDING + (CELLSIZE * 3.5), PADDING + (CELLSIZE * 6.3), "" + countScore);
        score.setColor(Color.DARK_GRAY);
        score.grow(15, 23);

        kb = new Keyboard(this);
        createControls();
    }

    @Override
    public void init() throws InterruptedException {

        background = new Picture(PADDING, PADDING, "game-background.png");
        background.draw();

        // SCORE/BYTES TEXT
        score.draw();

        Andre.keyInit();

        startButtons();
    }


    @Override
    public int getCols() {
        return maxCols;
    }

    @Override
    public int getRows() {
        return maxRows;
    }

    private void createControls() {
        // SPACE
        spacePressed = new KeyboardEvent();
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(spacePressed);

        // ENTER
        enterPressed = new KeyboardEvent();
        enterPressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        enterPressed.setKey(KeyboardEvent.KEY_ENTER);
        kb.addEventListener(enterPressed);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                soundFX.play();
                kb.removeEventListener(spacePressed);

                try {
                    Thread.sleep(600);
                    menu.delete();
                    Thread.sleep(600);
                    soundFX.stop();
                    instructions.draw();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_ENTER:
                kb.removeEventListener(enterPressed);

                soundDeepPurple.init();
                soundFX.init();


                try {
                    instructions.delete();
                    soundFX.play();
                    Thread.sleep(2000);
                    soundIntro.stop();
                    Thread.sleep(1000);
                    init();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                soundDeepPurple.play();

                break;
        }
    }

    private void startButtons() throws InterruptedException {
        for (int i = 0; i < 300; i++) {
            bt.syncButtons();
        }
    }
}
