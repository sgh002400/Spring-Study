package hello.SpringCore.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) { //AppConfig에서 구현체를 주입 받기 때문에 DIP 지켜짐. 여기서는 interface만 알고 있다.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    } //구현체가 하나만 있을 때는 관례상 인터페이스명 뒤에 Impl을 많이 붙임
}
