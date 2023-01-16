package org.academiadecodigo.mathinha.grid;


import org.academiadecodigo.mathinha.KeyDude;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static java.lang.Thread.sleep;

public class Nozk implements Runnable {

    Picture pinkBtn;
    int prevPosY;

    public Nozk() {
        pinkBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 8), BaseGrid.PADDING, "pink-nozk.png");
    }

    private boolean earlyPress = false;

    @Override
    public synchronized void run() {

        int delay = 1000 + ((int) (Math.random() * 3000));

        try {
            sleep(delay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (int y = 0; y < BaseGrid.maxRows * 8; y++) {
            try {
                pinkBtn.draw();
                sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            /**
             * Check picture/notes position
             */
            //0 É PARA Q
            //1 É PARA W
            //2 É PARA E
            if (pinkBtn.getY() > 500 && pinkBtn.getY() <= 520) {
                if (KeyDude.buttonCheckArray[0]) {
                    // NO POINTS FOR YOU
                    // too early
                    earlyPress = true;
                }
            } else if (pinkBtn.getY() > 520 && pinkBtn.getY() <= 540) {
                if (KeyDude.buttonCheckArray[0] && earlyPress == false) {
                    BaseGrid.countScore += 2;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            } else if (pinkBtn.getY() > 540 && pinkBtn.getY() <= 550) {
                if (KeyDude.buttonCheckArray[0] && earlyPress == false) {
                    BaseGrid.countScore += 5;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            }
            pinkBtn.translate(0, BaseGrid.CELLSIZE / 8.92);
        }
        pinkBtn.delete();

        Nozk duckling = new Nozk();
        Thread thread = new Thread(duckling);
        thread.start();
    }

}
