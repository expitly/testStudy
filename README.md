### Test Study



Test는 독립적이어야 한다.

독립적이다 => 다른 것에 의존하지 않는다. 

의존 대상을 다른 것으로 대체한다.



Test Double => 여기서 Double은 "대역"을 의미.

Test Double 종류 : Stub, Mock 등..



Mock Object = 행위 검증(behavior verification)

Stub = 상태 검증(state verification)



#### * TDD

1. Test가 실패 할 경우에만 코드를 작성한다.

2. 중복을 제거한다.
   - 실패하는 TEST 만들기.
   - Test가 성공하도록 무슨짓을 하던 초록색이 뜨도록 수정하기
   - 리팩토링

