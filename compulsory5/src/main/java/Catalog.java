
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
public class Catalog {

        private String name;
        private List<Document> documente = new ArrayList<>();
        public Catalog(String name) {
            this.name = name;
            this.documente = new ArrayList<Document>();
        }

        public List<Document> getDocumente() {
            return documente;
        }

        public void setDocumente(List<Document> documente) {
            this.documente = documente;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void add(Document document) {
            documente.add(document);
        }
        public void save(String fileName) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(fileName), documents);
        }
        public static Catalog load(String fileName) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Document.class);
            List<Document> documents = mapper.readValue(new File(fileName), type);
            Catalog catalog = new Catalog(fileName);
            for (Document doc : documents) {
                catalog.addDocument(doc);
            }
            return catalog;
        }
        @Override
        public String toString() {
            return "Catalog{" + "name=" + name + ", documents=" + documente + '}';
        }

}


