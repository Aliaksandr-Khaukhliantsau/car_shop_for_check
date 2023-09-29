package entity;

public class Model {
    private String id;
    private String name;
    private String idCompletion;

    public Model() {
    }

    public Model(String id, String name, String idCompletion) {
        this.id = id;
        this.name = name;
        this.idCompletion = idCompletion;
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

    public String getIdCompletion() {
        return idCompletion;
    }

    public void setIdCompletion(String idCompletion) {
        this.idCompletion = idCompletion;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idCompletion='" + idCompletion + '\'' +
                '}';
    }
}
