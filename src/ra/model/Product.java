package ra.model;

import ra.config.Config;

public class Product implements IProduct,Comparable<Product>{
    private  int productId;
    private String productName;
    private String title;
    private String descriptions;
    private  float importPrice;
    private float exportPrice;
    private float interest;
    private  boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }


    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }


    @Override
    public void inputData() {
        System.out.println("Nhập tên sản phẩm ");
        this.productName = Config.input().nextLine();
        System.out.println("Nhập vào tiêu để");
        this.title = Config.input().nextLine();
        System.out.println("Nhập vao mô tả");
        this.descriptions = Config.input().nextLine();
        System.out.println("Giá nhập");
        this.importPrice = Config.input().nextFloat();
        System.out.println("Giá xuất");
        this.exportPrice = Config.input().nextFloat();
        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("===========================================================================");
        System.out.printf("[Product] \n" +
                        "ID : %-10d - Name : %-20s \n" +
                "Title : %-20s - Description : %-30s + \n" +
                "ImportPrice : %.1f - ExportPrice : %.1f \n" +
                "Interest : %.1f - Status : %s \n",this.productId,this.productName,
                this.title,this.descriptions,this.importPrice, this.exportPrice,
                this.interest, this.productStatus?"còn hàng ":"hết hàng");
        System.out.println("================================================================");
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.interest-o.getInterest());
    }
}
