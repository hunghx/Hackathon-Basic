package ra.controller;

import ra.model.Product;

import java.util.List;

public interface IProductController {
    Product inputData(List<Product> list);
    void save(List<Product> list,Product product);
    void update(List<Product> list,Product product);
    Product findById(List<Product> list,int id);
    void delete(List<Product> list,int id);
    void displayData(List<Product> list);
    List<Product> searchByName(List<Product> list,String name);
}
