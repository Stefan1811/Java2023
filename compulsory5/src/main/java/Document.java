import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Document {

        private String id;
        private String name;
        private String location;
        private Map<String, String> tags;
        public Document(String id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
            tags = new HashMap<String, String>();
        }

        public Map<String, String> getTags() {
            return tags;
        }

        public void setTags(Map<String, String> tags) {
            this.tags = tags;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void addTag(String name, String value) {
            tags.put(name, value);
        }

        @Override
        public String toString() {
            return "Document{" + "id=" + id + ", title=" + name + ", location=" + location + ", tags=" + tags + '}';
        }
}


