package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProdcutRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProdcutRepository {

    List<Product> products;

    public InMemoryProductRepository(){
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 11", 10, 49999.99, "Apple"));
        products.add(new Product(2, "Iphone 12", 20, 59999.99, "Apple"));
        products.add(new Product(3, "Iphone 13", 30, 69999.99, "Apple"));
        products.add(new Product(4, "Iphone 14", 40, 79999.99, "Apple"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        products.get(id - 1);
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id - 1, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id - 1);
    }
}
