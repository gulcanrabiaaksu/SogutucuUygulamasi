package pkt;
//gözlemcilerin kaydedilmesi,çıkartılması ve istemcideki değişikliklerin
// gözlemcilere gönderilmesinden sorumlu sınıftır.
public interface ISubject {

    void attach(IObserver observer);
    void detach(IObserver observer);
    void notify(String message);
}
