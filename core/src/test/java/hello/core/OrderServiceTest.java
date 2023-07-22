package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
  
  MemberService memberService;
  OrderService orderService;
  
  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }
  
  @Test
  public void createOrder() throws Exception {
      //given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
      //when
    memberService.join(member);
      //then
    Order order = orderService.createOrder(memberId, "itemA", 20000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
  }
}
