package com.axsos.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
	List<Product> findByCategoriesNotContains(Category category);
}
