package zz;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
//[구독자]
public class MySub implements Subscriber<Integer> {

    private Subscription s;
    int buffSize = 3;//하루에 구독할 개수
    int currBuffSize = buffSize;//하루에 구독할 개수
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("MySub.onSubscribe [구독자]: 구독 잘 받았어");
        this.s = s;

        System.out.println("MySub.onSubscribe [구독자]: 신문 "+buffSize+"개씩 매일 줘!!");
        s.request(buffSize);//
    }

    @Override
    public void onNext(Integer t) {
        System.out.println("MySub.onNext [구독자]: "+t+"번째 신문 받았어");
        currBuffSize--;
        if(currBuffSize == 0) {
            System.out.println("하루 경과");
            currBuffSize = buffSize;
            s.request(buffSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("구독 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("MySub.onComplete [구독자]: 다 읽었어 [구독완료]");
    }
}
