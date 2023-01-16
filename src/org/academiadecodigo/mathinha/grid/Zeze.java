package org.academiadecodigo.mathinha.grid;

import org.academiadecodigo.mathinha.KeyDude;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static java.lang.Thread.sleep;

public class Zeze implements Runnable {

    Picture greenBtn;

    BaseGrid baseGrid;

    public Zeze() {
        greenBtn = new Picture(BaseGrid.PADDING + (BaseGrid.CELLSIZE * 9), BaseGrid.PADDING, "green-zeze.png");
    }

    // property limit points per key press (NO MORE CHEAT CODES)
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
                greenBtn.draw();
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
            if (greenBtn.getY() > 500 && greenBtn.getY() <= 520) {
                if (KeyDude.buttonCheckArray[1]) {
                    // NO POINTS FOR YOU
                    // too early
                    earlyPress = true;
                }
            } else if (greenBtn.getY() > 520 && greenBtn.getY() <= 540) {
                if (KeyDude.buttonCheckArray[1] && earlyPress == false) {
                    BaseGrid.countScore += 2;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            } else if (greenBtn.getY() > 540 && greenBtn.getY() <= 550) {
                if (KeyDude.buttonCheckArray[1] && earlyPress == false) {
                    BaseGrid.countScore += 5;
                    BaseGrid.score.setText("" + BaseGrid.countScore);
                    earlyPress = true;
                }

            }
            greenBtn.translate(0, BaseGrid.CELLSIZE / 8.92);
        }
        greenBtn.delete();

        Zeze duckling = new Zeze();
        Thread thread = new Thread(duckling);
        thread.start();
    }


}
