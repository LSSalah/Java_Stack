package com.axsos.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.CategoryProduct;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repositories.CategoryProductRepository;
import com.axsos.productsandcategories.repositories.CategoryRepository;
import com.axsos.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository pR;
	private final CategoryRepository cR;
	private final CategoryProductRepository cPR;
	
	public ProductService(ProductRepository pR, CategoryRepository cR, CategoryProductRepository cPR) {
		
		this.pR = pR;
		this.cR = cR;
		this.cPR = cPR;
	}
	
	public Product addProduct(Product product) {
		return pR.save(product);
	}
	
	public Category addCategory(Category category) {
		return cR.save(category);
	}
	
	public CategoryProduct joinCategoryToProduct(CategoryProduct categoryProduct) {
		return cPR.save(categoryProduct);
	}
	
	public Product findProductById(Long id) {
		Optional<Product> check =  pR.findById(id);
		if (check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	public List<Category> allCatergories(){
		return cR.findAll();
	}
	
	public List<Category> allExcludeCategories(Product product){
		return cR.findByProductsNotContains(product);
	}
	
	public List<Product> allExcludeProducts(Category category){
		return pR.findByCategoriesNotContains(category);
	}
	
	public Category findCategoryById(Long Id) {
		Optional<Category> check = cR.findById(Id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}

}
