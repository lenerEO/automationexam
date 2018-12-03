package pageobjects;

import java.util.Comparator;

public class Product {
    private int Indice;
    private String Nombre;
    private Double Price;

    public int getIndice() {
        return Indice;
    }

    public void setIndice(int indice) {
        Indice = indice;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public static Comparator<Product> PrdNameComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String ProductName1 = p1.getNombre().toUpperCase();
            String ProductName2 = p2.getNombre().toUpperCase();

            //ascending order
            return ProductName1.compareTo(ProductName2);

            //descending order
            //return ProductName2.compareTo(ProductName1);
        }
    };

    public static Comparator<Product> PrdPriceComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            Double ProductPrice1 = p1.getPrice();
            Double ProductPrice2 = p2.getPrice();

            //ascending order
            //return ProductPrice1.compareTo(ProductPrice2);

            //descending order
            return ProductPrice2.compareTo(ProductPrice1);
        }
    };

    @Override
    public String toString() {
        return "[ index=" + Indice + ", nombre=" + Nombre + ", precio=" + Price + "]";
    }
}
