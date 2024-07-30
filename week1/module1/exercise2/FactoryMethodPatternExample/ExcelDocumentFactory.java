package week1.module1.exercise2.FactoryMethodPatternExample;


public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
