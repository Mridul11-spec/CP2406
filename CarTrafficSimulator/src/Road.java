public class Road {
    Object[] segment;
    String name;
    int length;
    Car car =new Car();
    TrafficLight trafficLight=new TrafficLight();
    Road connectedRoad;
    boolean reached=false;

    public Road(String name, int length, Car car, Road connectedRoad, TrafficLight trafficLight) {
        this.segment =new Object[length];
        this.name=name;
        this.length=length;
        this.car = car;
        this.trafficLight=trafficLight;
        this.connectedRoad = connectedRoad;
        segment[0]= car;
        segment[this.length-1]=trafficLight;
    }
    public void update(Car car)
    {
        if(car.position<this.length) {
            this.segment[car.position] = this.car;
        }
        else if(car.position==this.length){
            if(trafficLight.color.equalsIgnoreCase("Green")) {
                car.position = 0;
                car.currentRoad = connectedRoad;
                reached = true;
            }
            else{
                car.position-=1;
            }
        }
    }
}
