package hello.core.member;

public class MemberServiceImpl implements MemberService { // 추상에도 의존하고
  
//  private final MemberRepository memberRepository = new MemoryMemberRepository(); // 구현에도 의존한다 => DIP를 지키지 않음!
  
  private final MemberRepository memberRepository; // 오로지 memberRespository라는 인터페이스만 있다! DIP 지키기 -> 생성자 주입!!!!
  
  public MemberServiceImpl(MemberRepository memberRepository) {
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
