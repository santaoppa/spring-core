package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl은 추상화(MemberRepository), 구체화(MemoryMemberRepository()에도 의존 -> DIP 위반
    // private final  MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 생성자를 통해서 구현체 주입
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
