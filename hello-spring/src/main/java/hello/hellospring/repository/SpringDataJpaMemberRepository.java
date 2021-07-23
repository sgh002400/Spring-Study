package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
//JpaRepository를 상속 받으면 알아서 내부 구현을 해준다. 그 후 알아서 Spring Bean에 등록해준다.
    @Override

    //JPQL이 메서드 이름을 보고 select m from Member m where m.name = ? 라는 query를 생성한다.
    //findByNameAndId 이런식으로 작성하면 또 이름을 보고 쿼리 자동 생성함.
    Optional<Member> findByName(String name);

}
