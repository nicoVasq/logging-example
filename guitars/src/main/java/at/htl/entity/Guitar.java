package at.htl.entity;

public class Guitar {

    private String brand;
    private String style;

    public String getBrand() {
        return brand;
    }

    public Guitar() {
    }

    public Guitar(String brand, String style) {
        this.brand = brand;
        this.style = style;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
