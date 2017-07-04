package jp.drjoy.service.grpc.starter.example.service;

/**
 *
 * Created by k.sumi on 6/14/2017.
 */
//@GrpcService
public class GreeterService {

}
//public class GreeterService extends GreeterServiceGrpc.GreeterServiceImplBase {
//
//    @Override
//    public void sayHello(GreeterRequest request, StreamObserver<GreeterReply> responseObserver) {
//        final String message = "Hello " + request.getUsername();
//
//        GreeterReply res = GreeterReply.newBuilder().setMessage(message).build();
//        responseObserver.onNext(res);
//        responseObserver.onCompleted();
//    }
//}
