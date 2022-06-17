---
layout : post
title : react-server-db 연동
categories : Javascript
date : 2022-06-17
---
## 서론

자바스크립트 환경과 react 환경에서의 db연동하는 방법이 꽤 차이가 났다 react 환경에서 db연동하는 방법을 알아보자.

## 과정

1. react에서는 웹과 서버를 같이 실행해야하기때문에 concurrently를 사용해서 상위 디렉토리 package.json 부분을 고친다. client와 서버 폴더를 따로둔다고 가정했을때 nodemon을 실행할 경우 client는 client 폴더에 들어가서 실행하고 서버는 server.js를 실행한다. concurrently는 동시에 실행한다는 npm 패키지이다. --kill-others-on-fail옵션은 하나라도 에러가 발생하면 둘다 실행하지않는다는 옵션이다.<br>

```javascriput
{
  "name": "server",
  "version": "1.0.0",
  "description": "",
  "main": "sever.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "client": "cd client && npm start",
    "server": "nodemon server.js",
    "start": "concurrently --kill-others-on-fail \"npm run server\" \"npm run client\""
  },
  ...
  // 폴더이름은 server server.js로 설정했다.
```

2. 웹의 기본 localhost 주소는 3000이므로 proxy 중개자를 사용해서 localhost:3000 주소가 이동할때마다 서버에서 설정한 주소로 바꿔준다. 그렇게되면 server와 연동된 db의 데이터를 가져올 수 있다.<br>
```javascriput
const { createProxyMiddleware } = require('http-proxy-middleware');
module.exports = (app) => {
	app.use(
		createProxyMiddleware('/api', {
			target: 'http://localhost:4000',
			changeOrigin: true,
		})
	);
};
// react에서는 /api를 기본으로 post한다. 서버의 set주소는 loaclhost:4000으로 설정했다.
```
