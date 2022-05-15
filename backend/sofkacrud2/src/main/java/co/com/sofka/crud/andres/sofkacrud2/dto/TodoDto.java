package co.com.sofka.crud.andres.sofkacrud2.todo;


//TDo Sirven para  trasportar datos
public class TodoDto {
    private Integer id;

    private String name;

    private boolean completed;

    private ListDto list;

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

    public ListDto getList() {
        return list;
    }

    public void setList(ListDto list) {
        this.list = list;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
