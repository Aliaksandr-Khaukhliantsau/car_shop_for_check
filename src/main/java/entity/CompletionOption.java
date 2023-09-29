package entity;

public class CompletionOption {
    private String idCompletion;
    private String idOption;

    public CompletionOption() {
    }

    public CompletionOption(String idCompletion, String idOption) {
        this.idCompletion = idCompletion;
        this.idOption = idOption;
    }

    public String getIdCompletion() {
        return idCompletion;
    }

    public void setIdCompletion(String idCompletion) {
        this.idCompletion = idCompletion;
    }

    public String getIdOption() {
        return idOption;
    }

    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }

    @Override
    public String toString() {
        return "CompletionOption{" +
                "idCompletion='" + idCompletion + '\'' +
                ", idOption='" + idOption + '\'' +
                '}';
    }
}
