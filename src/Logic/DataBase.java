package Logic;

public class DataBase {
    public Vehicle[] vehiclesArray = new Vehicle[20];
    public int nextVehicle=14;

    public Driver[] driversArray = new Driver[20];
    public int nextDriver=5;

    {
        vehiclesArray[0]=new Bus("NA-3434","Bus",3500,60);
        vehiclesArray[1]=new Van("KA-4563","Van",1000,7);
        vehiclesArray[2]=new Van("58-3567","Van",1500,4);
        vehiclesArray[3]=new Van("GF-4358","Van",800,4);
        vehiclesArray[4]=new Van("CCB-3568","Van",1800,8);
        vehiclesArray[5]=new Van("LM-6679","Van",1500,4);
        vehiclesArray[6]=new Van("QA-3369","Van",1800,6);


        vehiclesArray[7]=new CargoLorry("KB-3668","Cargo Lorry",2500,2);
        vehiclesArray[8]=new CargoLorry("JJ-9878","Cargo Lorry",3000,2);
        vehiclesArray[9]=new CargoLorry("GH-5772","Cargo Lorry",4000,3);
        vehiclesArray[10]=new CargoLorry("XY-4456","Cargo Lorry",3500,2);
        vehiclesArray[11]=new CargoLorry("YQ-3536","Cargo Lorry",2000,2);
        vehiclesArray[12]=new CargoLorry("CBB-3566","Cargo Lorry",2500,2);
        vehiclesArray[13]=new CargoLorry("QH-3444","Cargo Lorry",5000,4);



        driversArray[0]=new Driver("Sumith Kumara","7835348345V","B6474845","Panadura",725637456);
        driversArray[1]=new Driver("Amila Pathirana","8826253734V","B3354674","Galle",717573583);
        driversArray[2]=new Driver("Jithmal Perera","9283289272V","B3674589","Horana",772452457);
        driversArray[3]=new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara",782686390);
        driversArray[4]=new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala",772534436);




    }

    public void addVehicle(Vehicle vehicle){

        vehiclesArray[nextVehicle++]=vehicle;
        System.out.println(vehiclesArray[nextVehicle-1].getNumber());

    }

    public void addDriver(Driver driver){
        driversArray[nextDriver++]=driver;
        System.out.println(driversArray[nextDriver-1].getDriverName());
    }

}
