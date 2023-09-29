package entity;
// Model, Option, Order - зарезервированные имена в бд и java, рекомендую изменить но не теряя смысл и понимания.
public class Option {
    private String id;
    private String name;

    public Option() {
    }

    public Option(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Option{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
