package hello.core.member;

public class MemberServiceImpl implements MemberService { // 추상에도 의존하고
  
  private final MemberRepository memberRepository = new MemoryMemberRepository(); // 구현에도 의존한다 => DIP를 지키지 않음!
  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }
  
  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
