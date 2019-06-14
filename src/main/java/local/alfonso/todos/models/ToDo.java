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
}
