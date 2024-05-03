package hello.springtx.propagation;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }
}