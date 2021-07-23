package hello.hellospring.repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; //JPA는 EntityManager로 모든게 동작한다.

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist: 영구 저장하다 이런 뜻
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // JPQL을 통해서 Object와 쿼리 결과 매핑
        //JPQL이란 객체(엔티티)를 대상으로 쿼리를 날리는 것임.
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}