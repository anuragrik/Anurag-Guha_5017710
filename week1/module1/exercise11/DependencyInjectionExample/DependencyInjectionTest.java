package week1.module1.exercise11.DependencyInjectionExample;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        CustomerService service = new CustomerService(repository);
        
        String customerDetails = service.getCustomerDetails(1);
        System.out.println(customerDetails);
    }
}
