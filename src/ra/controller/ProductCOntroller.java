package ra.controller;

import ra.model.Product;
import ra.service.IProductServices;
import ra.service.ProductSeviceIpm;

import java.util.List;

public class ProductCOntroller implements IProductController{
    IProductServices productServices = new ProductSeviceIpm();
    @Override
    public Product inputData(List<Product> list) {
        return productServices.inputData(list);
    }

    @Override
    public void save(List<Product> list,Product product) {
        productServices.save(list,product);
    }

    @Override
    public void update(List<Product> list,Product product) {
        productServices.update(list,product);
    }

    @Override
    public Product findById(List<Product> list,int id) {
        return productServices.findById(list,id);
    }

    @Override
    public void delete(List<Product> list,int id) {
        productServices.delete(list,id);
    }

    @Override
    public void displayData(List<Product> list) {
        productServices.displayData(list);
    }

    @Override
    public List<Product> searchByName(List<Product> list,String name) {
        return productServices.searchByName(list,name);
    }
}
