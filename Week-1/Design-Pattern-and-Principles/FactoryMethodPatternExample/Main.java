public class Main {
    public static void main(String[] args) {
        DocumentFactory obj1 = new WordDocumentFactory();
        Document word = obj1.createDocument();
        word.read();
        word.write();

        DocumentFactory obj2 = new PdfDocumentFactory();
        Document pdf = obj2.createDocument();
        pdf.read();
        pdf.write();

        DocumentFactory obj3 = new ExcelDocumentFactory();
        Document excel = obj3.createDocument();
        excel.read();
        excel.write();
    }
}
