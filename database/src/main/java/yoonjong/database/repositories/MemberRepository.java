package yoonjong.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yoonjong.database.entities.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
{
}
