package sample;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private ArrayList<ArrayList<Cell>> matrix;
    private int matSize = 22;

    Field() {
        matrix = new ArrayList<>();
        for (int i = 0; i < matSize; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < matSize; i++) {
            for (int j = 0; j < matSize; j++) {
                Random r = new Random();
                matrix.get(i).add(new Cell(r.nextInt() % 2));
            }
        }



        for (int i = 0; i < matSize; i++) {
            System.out.println(matrix.get(i));
        }
    }

    public ArrayList<ArrayList<Cell>> getMatrix() {
        return matrix;
    }

    public int getMatSize() {
        return matSize;
    }

    public void updateCell(int iMat, int jMat) {
        int counter = 0;
        for (int i = iMat - 1; i <= iMat + 1; i++) {
            for (int j = jMat - 1; j <= jMat + 1; j++) {
                if (matrix.get(i).get(j).isStatus()) {
                    counter++;
                }
            }
        }
        if (matrix.get(iMat).get(jMat).isStatus()) {
            if (counter < 2 || counter > 3) {
                matrix.get(iMat).get(jMat).setStatus(false);
            }
        } else {
            if (counter == 3) {
                matrix.get(iMat).get(jMat).setStatus(true);
            }
        }
    }

    public void updateMatrix() {
        for (int i = 1; i < getMatSize() - 2; i++) {
            for (int j = 1; j < getMatSize() - 2; j++) {
                //TODO: updating cell by coordinates, edges
                updateCell(i, j);
            }
        }
        updateEdge();
    }

    public void updateEdge() {
        //TODO: updating of edges
        for (int i = 1; i < matSize - 2; i++) {
            matrix.get(0).get(i).setStatus(matrix.get(matSize - 2).get(i).isStatus());
        }
        for (int i = 1; i < matSize - 2; i++) {
            matrix.get(matSize - 1).get(i).setStatus(matrix.get(1).get(i).isStatus());
        }
        for (int i = 1; i < matSize - 2; i++) {
            matrix.get(i).get(0).setStatus(matrix.get(i).get(matSize - 2).isStatus());
        }
        for (int i = 1; i < matSize - 2; i++) {
            matrix.get(i).get(matSize - 1).setStatus(matrix.get(i).get(1).isStatus());
        }

        matrix.get(0).get(0).setStatus(matrix.get(matSize - 2).get(matSize - 2).isStatus());
        matrix.get(0).get(matSize - 1).setStatus(matrix.get(matSize - 2).get(1).isStatus());
        matrix.get(matSize - 1).get(0).setStatus(matrix.get(1).get(matSize - 2).isStatus());
        matrix.get(matSize - 1).get(matSize - 1).setStatus(matrix.get(1).get(1).isStatus());
    }
}
