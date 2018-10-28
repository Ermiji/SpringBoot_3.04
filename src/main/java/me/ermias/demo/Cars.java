package me.ermias.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long year;

    @NotNull
    @Size(min=4)
    private String make;

    @NotNull
    @Size(min=3)
    private String model;

    public Cars(@NotNull long year,
                @NotNull @Size(min = 4) String make,
                @NotNull @Size(min = 3) String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public Cars() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
