package nl.han.ica.daretwodate.model;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @Column(name = "userId")
    private long userId;
    @Column(na = "realName")
    private String realName;
    @Column(name = "lastfmUserName")
    private String lastfmUserName;
    @Column(name = "gender")
    private char gender;
    @Column(name = "interest")
    private char interest;

    public long getUserId() {
        return userId;
    }

    public String getRealName() {
        return realName;
    }

    public String getLastfmUsername() {
        return lastfmUserName;
    }

    public char getGender() {
        return gender;
    }

    public char getInterest() {
        return interest;
    }
}
