package yoonjong.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;

@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private long permission_group_id;

    @Column
    private OffsetDateTime updated_at;

    @Column
    @CreatedDate
    private OffsetDateTime created_at;
}
