package account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryProducerTest {

    private FactoryProducer producer = new FactoryProducer();

    @Test
    void correctCustomerFactoryTest(){
        Factory customerFactory = new CustomerFactory();
        assertEquals(customerFactory.getClass(), producer.produceFactory(0).getClass());
    }

    @Test
    void correctEmployeeFactoryTest(){
        Factory employeeFactory = new EmployeeFactory();
        assertEquals(employeeFactory.getClass(), producer.produceFactory(2).getClass());
    }

    @Test
    void nullFactoryTest(){
        assertEquals(null, producer.produceFactory(5));
    }


}
