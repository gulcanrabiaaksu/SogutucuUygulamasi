package pkt;

public class Factory {
    public static IEyleyici eyleyici(){
        return new Eyleyici();
    }
    public static  IEkran ekran(){
        return new Ekran();
    }
    public static IObserver observer(){
        return new Kullanici1();
    }
    public static IObserver observer2(){
        return new Kullanici2();
    }
}