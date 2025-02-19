package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 메모리 회원 저장소
public class MemoryMemberRepository implements MemberRepository{

    // 실무에서는 동시성 이슈가 있으므로 ConcurrentHashMap 사용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
