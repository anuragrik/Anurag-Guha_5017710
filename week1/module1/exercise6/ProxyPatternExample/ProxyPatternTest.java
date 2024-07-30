package week1.module1.exercise6.ProxyPatternExample;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test_image1.jpg");
        image1.display();
        
        image1.display();

        Image image2 = new ProxyImage("test_image2.jpg");
        image2.display();
    }
}
