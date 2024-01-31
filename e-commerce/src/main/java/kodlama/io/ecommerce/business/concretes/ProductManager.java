package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProdcutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProdcutRepository prodcutRepository;

    public ProductManager(ProdcutRepository prodcutRepository) {
        this.prodcutRepository = prodcutRepository;
    }

    @Override
    public List<Product> getAll() {
        return prodcutRepository.getAll();
    }

    @Override
    public Product getById(int id) {
        return prodcutRepository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return prodcutRepository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return prodcutRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        prodcutRepository.delete(id);
    }

    //Business Rules

    private void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

    private void checkIfUnitPriceValid(Product product){
        if(product.getUnitPrice() <= 0) throw  new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    private void checkIfQuantityValid(Product product){
        if(product.getQuantity() < 0) throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    private void checkIfDescriptionLengthValid(Product product){
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }
}
