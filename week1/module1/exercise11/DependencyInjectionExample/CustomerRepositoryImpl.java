package week1.module1.exercise11.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        return "Customer with ID: " + id;
    }
}
