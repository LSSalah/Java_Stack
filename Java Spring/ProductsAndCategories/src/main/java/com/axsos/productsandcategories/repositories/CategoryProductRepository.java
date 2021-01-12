package com.axsos.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct,Long>{

}
