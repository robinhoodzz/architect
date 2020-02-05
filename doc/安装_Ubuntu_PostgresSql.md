# Ubuntu 安装 Postgres

* [官网安装教程](https://www.postgresql.org/download/linux/ubuntu/)
```shell
sudo vim /etc/apt/sources.list.d/pgdg.list
# 添加如下一行
# deb http://apt.postgresql.org/pub/repos/apt/ YOUR_UBUNTU_VERSION_HERE-pgdg main

sudo wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get install postgresql-11

sudo service postgresql-11 start
```

* 修改密码
```shell
sudo su postgres
psql
ALTER USER postgres WITH PASSWORD 'yourpassword'
# 退出数据库
```

* 远程访问
```shell

# 修改 postgresql.conf 文件, 存放在 /etc/postgresql/$版本号/main/
# listen_addresses = 'localhost'
# 改成如下
listen_addresses = '*'

# 修改pg_hba.conf, 存放在 /etc/postgresql/$版本号/main/
# 添加如下行
host    all             all             0.0.0.0/0          md5
```
> [参考](https://my.oschina.net/u/1011130/blog/2988178)

* 修改密码
```shell
sudo -u postgres psql
ALTER USER postgres WITH PASSWORD '123456';

SELECT pg_reload_conf();

```

* 安装kong
```shell

```



[参考官网](https://docs.konghq.com/install/ubuntu/?_ga=2.233576862.1057771421.1580647994-185606844.1580647994)


* 安装kong dashborad
```shell
#   npm install -g cnpm --registry=https://registry.npm.taobao.org
# 切换至淘宝源
​​​​​​​npm config set registry=http://registry.npmjs.org
npm config set registry https://registry.npm.taobao.org
# 切换回官方源
npm config set registry http://www.npmjs.org

```
[参考链接](https://blog.csdn.net/tangsl388/article/details/82851505)
[npm使用淘宝的镜像源](https://blog.csdn.net/tangsl388/article/details/82851505)


* [彻底卸载](https://www.cnblogs.com/hanshuai/p/8745952.html)
```shell
sudo apt-get --purge remove postgresql
sudo rm -r /etc/postgresql/
sudo rm -r /etc/postgresql-common/
sudo rm -r /var/lib/postgresql/
sudo userdel -r postgres
sudo groupdel postgres
```

