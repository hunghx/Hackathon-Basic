package ra.service;

import ra.config.Config;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSeviceIpm implements IProductServices{
    @Override
    public Product inputData(List<Product> list) {
        Product newProduct = new Product();
        if(list.size()==0){
            newProduct.setProductId(1);
        }else {
            int newIdProduct = list.get(list.size() - 1).getProductId()+1;
            newProduct.setProductId(newIdProduct);
        }
        newProduct.setProductStatus(true);
        newProduct.inputData();
        return newProduct;
    }

    @Override
    public void save(List<Product> list,Product product) {
        list.add(product);
    }

    @Override
    public void update(List<Product> list,Product product) {
        System.out.println("Nhập tên sản phẩm mơi ");
        product.setProductName(Config.input().nextLine());
        System.out.println("Nhập vào tiêu để mới");
        product.setTitle(Config.input().nextLine());
        System.out.println("Nhập vao mô tả mới");
        product.setDescriptions(Config.input().nextLine());
        System.out.println("Giá nhập mới");
        product.setImportPrice(Config.input().nextFloat());
        System.out.println("Giá xuất mới");
        product.setExportPrice( Config.input().nextFloat());
        System.out.println("Nhập trạng thái câần cập nhật");
        product.setProductStatus(Config.input().nextBoolean());

        for (Product pro: list
             ) {
            if(pro.getProductId()== product.getProductId()){
                pro = product;
            }

        }
    }

    @Override
    public Product findById(List<Product> list,int id) {
        for (Product pro:list
             ) {
            if(pro.getProductId()==id){
                return pro;
            }
        }
        return null;
    }

    @Override
    public void delete(List<Product> list,int id) {
        for (Product pro: list
             ) {
            if(pro.getProductId() == id){
                list.remove(pro);
            }
        }

    }

    @Override
    public void displayData(List<Product> list) {
        for (Product pro : list) {
            pro.displayData();
        }
    }

    @Override
    public List<Product> searchByName(List<Product> list,String name) {
        List<Product> listSearch = new ArrayList<>();
        for (Product product : list) {
            if(product.getProductName().contains(name)){
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
