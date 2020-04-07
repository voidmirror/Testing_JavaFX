package sample;

public class Cell {
    private boolean status;

    Cell(int s) {
        if (s == 1) {
            status = true;
        } else {
            status = false;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (status) {
            return "O";
        } else {
            return " ";
        }
    }
}
