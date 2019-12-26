public class Simulator {
    public static void main(String[] args) throws InterruptedException, NullPointerException {

        Boolean end = false; //boolean to end the simulator or not
        //Declaring car variable
        Car car;
        car = new Car("Car", 0, null);

        //Declaring traffic variable
        TrafficLight t1 = new TrafficLight("Red", 7.0);

        //Declaring Road variable
        Road road;
        Road r4 = new Road("r4",12, car,null,t1);
        Road r3 = new Road("r3", 10, car, r4, t1);
        Road r2 = new Road("r2", 8, car, r3, t1);
        Road r1 = new Road("r1", 6, car, r2, t1);

        //Put Vehicle on the Road
        car.currentRoad = r1;
        road = car.currentRoad;

        while (end == false) { //the simulator will keep running until user choose to end
            t1.operate();
            System.out.println("Vehicle:" + car.name + " Road:" + car.currentRoad.name + " Position:" + car.position + " Traffic Light: " + t1.color);
            car.move();
            road.update(car);
            if (road.reached == true)
            {
                if (road.connectedRoad == null)
                {
                    end=true;
                }
                road = car.currentRoad;
                Thread.sleep(2000);
            }
        }
    }
}
