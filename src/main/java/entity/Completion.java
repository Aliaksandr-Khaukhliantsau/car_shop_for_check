package entity;

import java.util.List;

public class Completion {
    private String id;
    private String name;
    private List<Option> options;

    public Completion() {
    }

    public Completion(String id, String name, List<Option> options) {
        this.id = id;
        this.name = name;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Completion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", options=" + options +
                '}';
    }
}
