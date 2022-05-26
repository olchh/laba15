package com.company;
enum ClothesSize{
    XXS(32){
        @Override
        public String getDescription(){
            return "Детский размер.";
        }
    }, XS(34), S(36), M(38), L(40);

    private final int euroSize;

    ClothesSize(int i) {
        euroSize = i;
    }

    public String getDescription(){
        return "Взрослый размер.";
    }
    public String toString(){
        return name() + " (" + euroSize + ") " + getDescription();
    }
}

interface clothesMen {
    default void dressMen(){
        System.out.println("Одеть мужчину.");
    }
}

interface clothesWomen {
    default void dressWomen(){
        System.out.println("Одеть девушку.");
    }
}

abstract class Clothes{
    private final ClothesSize size;
    private double price;
    private final String color;

    Clothes(ClothesSize size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }


    public ClothesSize getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}

class Atelier{
    void dressAMan(Clothes[] clothes){
        System.out.println("Мужская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof clothesMen){ //проверяет ссылается ли обьект класса на мужскую или женскую одежду
                System.out.println(c);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("Женская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof clothesWomen){
                System.out.println(c);
            }
        }
    }
    public static class TShirt extends Clothes implements clothesMen, clothesWomen {
        TShirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }
        public String toString() {
            return "\n" + "Размер футболки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Trousers extends Clothes implements clothesMen, clothesWomen {
        Trousers(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер штанов " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Skirt extends Clothes implements clothesWomen {
        Skirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер юбки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Tie extends Clothes implements clothesMen {
        Tie(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return  "\n" + "Размер галстука " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Atelier.TShirt(ClothesSize.M, "Серая", 1200),
                new Atelier.TShirt(ClothesSize.S, "Белая", 1000),
                new Atelier.Trousers(ClothesSize.XXS, "Черные", 2500),
                new Atelier.Trousers(ClothesSize.M, "Болотные", 3100),
                new Atelier.Skirt(ClothesSize.XS, "Серая", 1000),
                new Atelier.Skirt(ClothesSize.L, "Белая", 1300),
                new Atelier.Tie(ClothesSize.XS, "Синий", 1200),
                new Atelier.Tie(ClothesSize.XXS, "Черный", 1500),
        };

        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        System.out.println();
        atelier.dressAWoman(clothes);
    }
}