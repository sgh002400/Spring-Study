package hello.SpringCore.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    } //구현체가 하나만 있을 때는 관례상 인터페이스명 뒤에 Impl을 많이 붙임
}
