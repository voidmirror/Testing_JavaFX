package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class QueueFormer implements Runnable {
    private ImageView imgView;
    private QueueObject queueObject;

    QueueFormer(QueueObject queueObject, ImageView imgView) {
        this.imgView = imgView;
        this.queueObject = queueObject;
    }
    @Override
    public void run() {
        while (true) {
            if (!queueObject.isQueEmpty()) {
                while (!queueObject.isQueEmpty()) {
                    MovingImg movingImg = new MovingImg(imgView, queueObject.getQue().get(0));
                    Thread t = new Thread(movingImg);
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("removing: " + queueObject.getQue().get(0));
                    queueObject.getQue().remove(0);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
