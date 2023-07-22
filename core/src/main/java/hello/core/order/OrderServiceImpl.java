package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
  
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy; // 인터페이스에만 의존하고있음!!! -> DIP를 잘 지키고 있다.
  
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }
  
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId); // 우선 멤버 조회
    int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책 결정
    
    return new Order(memberId, itemName, itemPrice, discountPrice); // 멤버와 멤버에 대한 할인 정책에 맞는 주문을 리턴
  }
}
