package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller {
    @FXML
    private Label labelbl;
    @FXML
    private ImageView imgView;

    Image image;

//    Controller()
    {
        try {
            image = new Image(new FileInputStream("src\\sample\\7.jpg"));
//            imgView.setImage(new Image(new FileInputStream("src\\sample\\7.jpg")));
//            setImgView();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    QueueObject queueObject = new QueueObject();

    public void setImgView() throws FileNotFoundException {
        imgView.setImage(new Image(new FileInputStream("src\\sample\\7.jpg")));
    }

    public Label getLab() {
        return labelbl;
    }

    public ImageView getImgView() {
        return imgView;
    }

    Field field = new Field();

    public void updateLabel() {
        String s = "";
        for (int i = 1; i < field.getMatSize() - 1; i++) {
            for (int j = 1; j < field.getMatSize() - 1; j++) {
                s += field.getMatrix().get(i).get(j) + "    ";
            }
            s += "\n";
        }
//        lab.setText("");
        labelbl.setText(s);
    }

    public void init() {
        field = new Field();
//        System.out.println();
//        mainCycle(); //TODO: change to mainCycle() - WARNING!!
    }

    public void updateField() {
        field.updateMatrix();
    }

    private void mainCycle() {
//        for (int i = 0; i < 10; i++) {
//            updateLabel();
//        }
//        Field field = new Field();
        updateLabel();
        int counter = 1;
        while (counter != 0) {
            counter = 0;
            // exit from mainCycle
            for (int i = 0; i < field.getMatSize(); i++) {
                for (int j = 0; j < field.getMatSize(); j++) {
                    if (field.getMatrix().get(i).get(j).isStatus()) {
                        counter++;
                    }
                }
            }
            updateField();
            updateLabel();
            System.out.println(counter);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//            for (int i = 0; i < field.getMatSize(); i++) {
//                System.out.println(field.getMatrix().get(i));
//            }
//            System.out.println();
        }
    }

    public void move(int cycles) {
        Random random = new Random();

    }

    public void addRandomQueElement() {
        Random random = new Random();
        Integer e = random.nextInt() % 4;
        if (e != 0) {
            queueObject.addQueElement(e);
        }
        labelbl.setText(e.toString());
        if (queueObject.sizeOfQue() % 3 == 0) {
            queueObject.printQue();
        }
    }

    public void go() throws FileNotFoundException {
        setImgView();
        System.out.println("new thread --->");
        QueueFormer queueFormer = new QueueFormer(queueObject, imgView);
        Thread t = new Thread(queueFormer);
        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("hey?");

    }


}
