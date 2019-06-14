package local.alfonso.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class ToDo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private String completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("todo")
    private User usertodo;

    public ToDo()
    {
    }

    public ToDo(String description)
    {
        this.description = description;
    }

    public ToDo(String description, String completed, User usertodo)
    {
        this.description = description;
        this.completed = completed;
        this.usertodo = usertodo;
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCompleted()
    {
        return completed;
    }

    public void setCompleted(String completed)
    {
        this.completed = completed;
    }

    public User getUsertodo()
    {
        return usertodo;
    }

    public void setUsertodo(User usertodo)
    {
        this.usertodo = usertodo;
    }
}
