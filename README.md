# tencent-sms(腾讯云短信服务)

[![GitHub license](https://img.shields.io/github/license/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/issues)
[![GitHub stars](https://img.shields.io/github/stars/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/network)
![Java version](https://img.shields.io/badge/Jdk-1.8-yellow)
![SpringBoot version](https://img.shields.io/badge/SpringBoot-2.1.13-brightgreen)

---

## 预备知识点

- Tencent短信服务
- Redis
- SpringBoot
- Swagger

## 本仓库

### 关注

[![Stargazers repo roster for @mikuhuyo/tencent-sms](https://reporoster.com/stars/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/stargazers)

### 收藏

[![Forkers repo roster for @mikuhuyo/tencent-sms](https://reporoster.com/forks/mikuhuyo/tencent-sms)](https://github.com/mikuhuyo/tencent-sms/network/members)

## 功能演示

### 获取短信

![](./assert/assert-01.png)

### 短信校验

![](./assert/assert-02.png)

## 项目启动

### 创建容器

```shell script
docker pull redis:4

docker run --name redis -p 6379:6379  \
-d redis:4 \
--requirepass "yueliminvc@outlook.com" \
--appendonly yes
```

### 修改配置

修改`sms`与`redis`配置.

```yaml`
sms:
  qcloud:
    appId: 12345678
    appKey: 'yueliminvc888888ddddd'
    templateId: '123456'
    sign: 'fake'
```

### 开启腾讯短信服务

修改`com.tencent.sms.SmsNumberVerificationHandler`(将`sms.service.send()`注释取消):

```java
@Override
String confusion(Map<String, Object> payload, String key, String code) {
    String mobile = String.valueOf(payload.get("mobile"));

    // 使用腾讯云发送短信
    smsService.send(mobile, code, getEffectiveTime());

    // 测试使用, 在控制台输出验证码
    smsService.sendOnConsole(mobile, code, getEffectiveTime());
    return null;
}
```
