package account;

public class FactoryProducer {

    public Factory produceFactory(int type){
        if (type == 0 || type == 1){
            return new CustomerFactory();
        }
        else if (type == 2 || type == 3){
            return new EmployeeFactory();
        }
        else
            return null;
    }
}
