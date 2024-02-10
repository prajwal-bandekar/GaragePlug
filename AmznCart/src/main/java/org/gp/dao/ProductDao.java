package org.gp.dao;

import java.util.Optional;

import org.gp.entity.Product;
import org.gp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	
	public Product updateProduct(Product p) {
		return repo.save(p);
	}
	
	public void deleteProduct(int id) {
		repo.deleteById(id);
	}
	
	public Optional<Product> findProduct(int id){
		return repo.findById(id);
	}
}
