启动主类： RedisApplication 
A、springboot中整合redis，存储的两种序列化方式
   Json存储：RedisUtils、JsonController
   Java二进制存储：SerializableController
   UserEntity
B、使用redis作为缓存
   MemberController、UserMapper、MemberEntity
   
C、采用redis的过期机制通知，限定订单的时间
   RedisKeyExpirationListener、RedisListenerConfig、
   OrderController、OrderMapper、OrderEntity
     使用Redis Key自动过期机制
     当我们的key失效时，可以执行我们的客户端回调监听的方法。
     需要在Redis中配置：
   notify-keyspace-events "Ex"
D、使用redis（单个redis，未做集群）实现分布式锁
  原理：使用SetNx命令的特性实现，只有没有这个key，setNx命令才能成功，否则不成功
  RedisLock.java、RedisLockController.java、RedisUtil.java