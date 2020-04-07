package sample;

import java.util.ArrayList;

public class QueueObject {
    private ArrayList<Integer> que = new ArrayList<>();

    public ArrayList<Integer> getQue() {
        return que;
    }

    public void addQueElement(int element) {
        que.add(element);
    }

    public boolean isQueEmpty() {
        return que.isEmpty();
    }

    public void printQue() {
        System.out.println(que);
    }

    public int sizeOfQue() {
        return que.size();
    }
}
