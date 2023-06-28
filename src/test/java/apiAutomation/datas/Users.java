package apiAutomation.datas;


import com.fasterxml.jackson.annotation.JsonInclude;

//pojo - plain old java object
//nullari icermedik id ve created at gitmedi!
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

    String name;
    String job;
    String id;
    String createdAt;

    public Users() {

    }

    public Users(String name, String job, String id) {
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    //getters and setters methods:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}