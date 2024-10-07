package ie.atu.week4.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> add(Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }

    public List<Product> get(){
        return productRepository.findAll();
    }

    public  String update(Product updatedProduct){

        productRepository.save(updatedProduct);
        return "updated product";
    }

    public String delete(Product updatedProduct){

        productRepository.delete(updatedProduct);
        return "deleted";
    }


}
