package BY.Oreshko.Serv.repository.dbconstsnts;

public enum PersonTableConstants {
    ID("id"),
    NAME("name1"),
    PHONE("phone"),
    EMAIL ("email");
    private String fieldName;
    private PersonTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName(){
        return fieldName;
    }
}
