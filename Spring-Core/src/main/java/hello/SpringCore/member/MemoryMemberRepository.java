package hello.SpringCore.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //여러 군데에서 접근하면 동시성 문제가 있을 수 있기 때문에 ConcurrentHashMap을 사용하는게 좋다.


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
