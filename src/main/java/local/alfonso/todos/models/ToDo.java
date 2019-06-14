package local.alfonso.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

public class ToDo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("todo")
    @Column(nullable = false)
    private User userid;

    public ToDo()
    {
    }

    public ToDo(String description)
    {
        this.description = description;
    }

    public ToDo(String description, boolean completed, User userid)
    {
        this.description = description;
        this.completed = completed;
        this.userid = userid;
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

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUserid()
    {
        return userid;
    }

    public void setUserid(User userid)
    {
        this.userid = userid;
    }
}
