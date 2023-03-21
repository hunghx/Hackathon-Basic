package ra.view;

import ra.config.Config;
import ra.controller.IProductController;
import ra.controller.ProductCOntroller;
import ra.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManagement {
    public static void main(String[] args) {
        IProductController productController = new ProductCOntroller();
        List<Product> listProducts = new ArrayList<Product>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm [15 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [15 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần [15 điểm]\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "7. Thoát");
            System.out.println("Nhập vào lựa chọn cảu bạn");
            int choose = Config.input().nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Nhập số sản phẩm cần thêm mới");
                    int number = Config.input().nextInt();
                    for (int i = 1;i<=number;i++ ) {
                        System.out.println("Nhập sản phẩm thứ "+ i);
                         Product newProduct = productController.inputData(listProducts);
                         productController.save(listProducts,newProduct);
                    }
                    break;
                case 2:
                    System.out.println("HIển thị danh saách sản phẩm");
                    productController.displayData(listProducts);
                    break;
                case 3:
                    System.out.println("Sắp xếp danh sah theo lợi nhuân tăng dần");
                    Collections.sort(listProducts);
                    break;
                case 4:
                    System.out.println("Nhập vào id cần xoá");
                    int maSp = Config.input().nextInt();
                    productController.delete(listProducts,maSp);
                    break;
                case 5:
                    System.out.println("Nậ vào tên sp muốn tìm");
                    String name = Config.input().nextLine();
                    List<Product> listSearch = productController.searchByName(listProducts,name);
                    for (Product pro: listSearch
                         ) {
                        pro.displayData();
                    }
                    break;
                case 6:
                    System.out.println("Nhập vào id sp cần thay đổi trạng thái");
                    int idUpdateStatus = Config.input().nextInt();
                    for (Product pro : listProducts) {
                        if(pro.getProductId()==idUpdateStatus){
                            pro.setProductStatus(!pro.isProductStatus());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("lựa chọn không hợp lệ");
            }
        }
    }
}
