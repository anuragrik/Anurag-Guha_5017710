package week1.module1.exercise11.DependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerDetails(int id) {
        return repository.findCustomerById(id);
    }
}
