package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
  
  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();
  
  @Test
  public void createOrder() throws Exception {
      //given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
      //when
    memberService.join(member);
      //then
    Order order = orderService.createOrder(memberId, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}