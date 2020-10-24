# Redis

### Install

6.0.8 기준

```shell script
wget https://download.redis.io/releases/redis-6.0.8.tar.gz
tar xzf redis-6.0.8.tar.gz
cd redis-6.0.8
make
```

gcc 업그레이드
redis 6 버전대는 gcc 4.9 이상 필요

```shell script
sudo yum install centos-release-scl
sudo yum-config-manager --enable rhel-server-rhscl-7-rpms
sudo yum install devtoolset-8
scl enable devtoolset-8 bash
```

### standalone setting

설정 

./redis.conf 파일 수정

* bind
* requirepass
* daemonize

실행
```shell script
./src/redis-server ./redis.conf
```

### sentinel setting

### cluster setting
