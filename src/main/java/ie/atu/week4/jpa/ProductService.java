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

    public String delete(Long id){

       if (productRepository.existsById(id)){
           productRepository.deleteById(id);
           return "deleted product";
        }else{
           return "not found";
       }
    }


}
