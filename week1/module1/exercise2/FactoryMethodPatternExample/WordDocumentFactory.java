package week1.module1.exercise2.FactoryMethodPatternExample;
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
