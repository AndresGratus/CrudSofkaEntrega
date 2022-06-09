package co.com.sofka.crud.andres.sofkacrud2.dto;


//TDo Sirven para  trasportar datos
public class ToDoListDTO {
    private Integer id;

    private String name;

    private boolean completed;

    private Long idList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdList() {
        return idList;
    }


    public void setIdList(Long idList) {
        this.idList = idList;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
