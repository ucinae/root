# api 설계

### version

`GET /api/v1`

version 을 path 에 추가해서 관리하자

### response 형태

result 를 envelop 하나 마나 많은 정보를 찾은 결과 하는게 좋다고 생각된다.

참고 [restful-api-design-tips](https://github.com/ptboyer/restful-api-design-tips)

```json
{
  "apiVersion": "2.1",
  "id": "server supplied. useful for correlating server logs",
  "method": "represents the operation to perform e.g. controller method name",
  "params": "client's request dto (object type)",
  "data": "api's response dto (object type)",
  "error": {
    "code": "error code e.g. 404, 500",
    "message": "error message",
    "errors": [{
      "domain": "",
      "reason": "exception name e.g. ~Exception",
      "message": "human readable message (more detail info)",
      "location": "location",
      "locationType": "e.g. parameter..."
    }]
  }
}
```

[Google Json Style Guide](https://google.github.io/styleguide/jsoncstyleguide.xml) 를 참조

