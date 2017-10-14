

1，读文件读到内存（客户端）
2，将任务放到各个节点执行（服务端）
3，执行完成
4，将所有成功订单订单号缓存至ignite，找出与文件差集




网游:  随机写入两个对象 Map1<String,list<String>>   Map2<String,list<String>>
20170901 ---> list<String>
20170902 ---> list<String>
20170903 ---> list<String>
.
.
.
201709031 ---> list<String>


单机:  一个对象 Map<String,list<String>>
20170901 ---> list<String>
20170902 ---> list<String>
20170903 ---> list<String>
.
.
.
201709031 ---> list<String>


ignite代码集成
文件随机读取到两个对象
任务拆分
