public class Fee {

    int[] hour1 ={10,30,50};
    int[] further={5,20,40};
    int[] sur={0,15,25};
    int Calcfee(Vehicles vehicle){
        if(vehicle.slot=="BIKE"){
        int fee=hour1[0]+further[0]*(vehicle.time-1)+sur[0];
    }
}
}
