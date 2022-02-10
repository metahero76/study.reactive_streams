package zz;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

// 구독정보센터(구독자, 어떤 데이터를 구독할지)
public class MySubscription implements Subscription {


    private Subscriber s;
    private Iterator<Integer> it;

    public MySubscription(Subscriber s, Iterable<Integer> its){
        System.out.println("======== [구독정보센터] MySubscription 생성자함수 호출 ========");
        this.s = s;
        this.it = its.iterator();
        System.out.println("MySubscription 구독정보센터 담당자왈: 구독 정보 생성이 완료 되었습니다.");
        System.out.println("======== [구독정보센터] MySubscription 생성자함수 종료 ========");
    }


    @Override
    public void request(long n) {//20
        while (n > 0){
            if(it.hasNext()){
                s.onNext(it.next());
            }else{
                s.onComplete();
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
