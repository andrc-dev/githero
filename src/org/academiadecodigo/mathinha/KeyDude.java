package org.academiadecodigo.mathinha;

import org.academiadecodigo.mathinha.grid.BaseGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class KeyDude implements KeyboardHandler {
    Picture pinkBtn;
    Picture greenBtn;
    Picture yellowBtn;
    Picture pinkPressed;
    Picture greenPressed;
    Picture yellowPressed;

    public static boolean[] buttonCheckArray = {false, false, false};

    public void keyInit() {
        drawKeySet();
        keySetConfiguration();
    }

    public void drawKeySet() {
        // BUTTONS
        pinkBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 8.02), BaseGrid.CELLSIZE * 9.18, "pink-btn.png");
        greenBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 9.02), BaseGrid.CELLSIZE * 9.18, "green-btn.png");
        yellowBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 10.02), BaseGrid.CELLSIZE * 9.18, "yellow-btn.png");

        pinkBtn.draw();
        greenBtn.draw();
        yellowBtn.draw();
    }

    public void keySetConfiguration() {
        Keyboard keySetRelease = new Keyboard(this);

        //DUCK RELEASED
        KeyboardEvent duckReleased = new KeyboardEvent();
        duckReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        duckReleased.setKey(KeyboardEvent.KEY_Q);
        keySetRelease.addEventListener(duckReleased);

        //DUCK PRESSED
        KeyboardEvent duckPressed = new KeyboardEvent();
        duckPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        duckPressed.setKey(KeyboardEvent.KEY_Q);
        keySetRelease.addEventListener(duckPressed);

        //LOBSTER RELEASED
        KeyboardEvent lobsterReleased = new KeyboardEvent();
        lobsterReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        lobsterReleased.setKey(KeyboardEvent.KEY_W);
        keySetRelease.addEventListener(lobsterReleased);

        //LOBSTER PRESSED
        KeyboardEvent lobsterPressed = new KeyboardEvent();
        lobsterPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        lobsterPressed.setKey(KeyboardEvent.KEY_W);
        keySetRelease.addEventListener(lobsterPressed);

        //PIG RELEASED
        KeyboardEvent pigReleased = new KeyboardEvent();
        pigReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pigReleased.setKey(KeyboardEvent.KEY_E);
        keySetRelease.addEventListener(pigReleased);

        //PIG PRESSED
        KeyboardEvent pigPressed = new KeyboardEvent();
        pigPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pigPressed.setKey(KeyboardEvent.KEY_E);
        keySetRelease.addEventListener(pigPressed);

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                buttonCheckArray[0] = true;
                pinkBtn.load("pressed-btn.png");
                break;

            case KeyboardEvent.KEY_W:
                buttonCheckArray[1] = true;
                greenBtn.load("pressed-btn.png");
                break;

            case KeyboardEvent.KEY_E:
                buttonCheckArray[2] = true;
                yellowBtn.load("pressed-btn.png");
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                buttonCheckArray[0] = false;
                pinkBtn.load("pink-btn.png");
                break;

            case KeyboardEvent.KEY_W:
                buttonCheckArray[1] = false;
                greenBtn.load("green-btn.png");

            case KeyboardEvent.KEY_E:
                buttonCheckArray[2] = false;
                yellowBtn.load("yellow-btn.png");

        }
    }
}


