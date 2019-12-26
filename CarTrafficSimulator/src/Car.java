public class Car {
    String name;
    int position;
    Road currentRoad;
    public Car() {
    }

    public Car(String name, int position, Road currentRoad) {
        this.name = name;
        this.position = position;
        this.currentRoad = currentRoad;
    }

    public void move(){
        this.position+=1;
    }
}
