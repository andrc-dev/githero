package org.academiadecodigo.mathinha.grid;

import org.academiadecodigo.mathinha.KeyDude;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static java.lang.Thread.sleep;

public class Rolo implements Runnable {

    Picture yellowBtn;

    BaseGrid baseGrid;

    public Rolo() {
        yellowBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 10), BaseGrid.PADDING, "yellow-rolo.png");
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
                yellowBtn.draw();
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
            if (yellowBtn.getY() > 500 && yellowBtn.getY() <= 520) {
                if (KeyDude.buttonCheckArray[2]) {
                    // NO POINTS FOR YOU
                    // too early
                    earlyPress = true;
                }
            } else if (yellowBtn.getY() > 520 && yellowBtn.getY() <= 540) {
                if (KeyDude.buttonCheckArray[2] && earlyPress == false) {
                    BaseGrid.countScore += 2;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            } else if (yellowBtn.getY() > 540 && yellowBtn.getY() <= 550) {
                if (KeyDude.buttonCheckArray[2] && earlyPress == false) {
                    BaseGrid.countScore += 5;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            }
            yellowBtn.translate(0, BaseGrid.CELLSIZE / 8.92);
        }
        yellowBtn.delete();

        Rolo duckling = new Rolo();
        Thread thread = new Thread(duckling);
        thread.start();

    }
}
