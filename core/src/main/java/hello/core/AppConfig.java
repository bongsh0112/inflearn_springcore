package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 설계에 맞게 리팩토링! 역할과 구현 클래스가 한눈에 들어오도록 리팩터링한다
  
  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }
  
  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
  
  @Bean
  public MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
  
  @Bean
  public DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
  
}
