package org.academiadecodigo.mathinha.grid;


//import apple.laf.JRSUIUtils;

public class Buttons extends Thread {


    int amountOfButtons;

    int rad;

    public Buttons(int amountOfButtons) {
        this.amountOfButtons = amountOfButtons;
    }

    public void syncButtons() throws InterruptedException {
        switch (rad) {
            case 0:
                Nozk nozk = new Nozk();
                Thread thread = new Thread(nozk);
                thread.start();
                // thread.join();

                break;
            case 1:
                Zeze zeze = new Zeze();
                Thread thread1 = new Thread(zeze);
                thread1.start();
                //thread1.join();
                break;
            case 2:
                Rolo rolo = new Rolo();
                Thread thread2 = new Thread(rolo);
                thread2.start();
                //thread2.join();
                break;
        }

        rad++;
    }
}
