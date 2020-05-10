package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class MovingImg implements Runnable  {

    private int shift;
    private ImageView imgView;

    public MovingImg(ImageView imgView, int shift) {
        this.imgView = imgView;
        this.shift = shift;
    }

//
//    public ImageView getImgView() {
//        return imgView;
//    }

    @Override
    public void run() {
//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(4000), imgView);
//        translateTransition.setNode();
            translateTransition.setFromY(imgView.getScaleY() + imgView.getTranslateY());
            System.out.println(imgView.getScaleY() + imgView.getTranslateY());
            translateTransition.setToY(imgView.getScaleY() + imgView.getTranslateY() + shift * 50);
            translateTransition.play();



//            System.out.println("It runs " + i + "?");
        System.out.println("yes?");

//        }
    }
}
