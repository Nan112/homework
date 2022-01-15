package code;

public class student {
    String sid;
    String name;
    String age;
    String banji;

    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
        this.banji = banji;
    }

    public student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public student(String sid, String name, String age, String banji) {
        super();
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.banji = banji;
    }
}
