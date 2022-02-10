package zz;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

//[신문사]
public class MyPub implements Publisher<Integer> {
    //신문사에서 가지고 있는 데이터 목록들
    Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Override
    public void subscribe(Subscriber<? super Integer> s) {

        System.out.println("======== [신문사] MyPub.subscribe 함수 호출 ========");
        System.out.println("MyPub.subscribe 고독자왈: 신문사야 나 너희 신문 볼께");
        System.out.println("MyPub.subscribe 신문사왈: 정보를 만들어서 줄테니 기다려!");

        MySubscription subscription = new MySubscription(s, its);
        System.out.println("MyPub.subscribe 신문사왈: 구독 정보 생성 완료 했어 잘 받아");
        s.onSubscribe(subscription);
        System.out.println("========= [신문사] MyPub.subscribe 함수 종료 =======");
    }
}
