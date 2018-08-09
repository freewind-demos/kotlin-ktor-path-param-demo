Use [httpie](https://httpie.org/) as client for testing.

```
brew install httpie
```

### demo1

```
$ http http://localhost:8080/demo1/123
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 13
Content-Type: text/plain; charset=UTF-8

id: 123
```

```
$ http http://localhost:8080/demo1/
HTTP/1.1 404 Not Found
Connection: keep-alive
Content-Length: 0
```

```
$ http http://localhost:8080/demo1/123/456
HTTP/1.1 404 Not Found
Connection: keep-alive
Content-Length: 0
```

### demo2

```
$ http http://localhost:8080/demo2/123
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 13
Content-Type: text/plain; charset=UTF-8

id: 123
```

```
$ http http://localhost:8080/demo2/
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 14
Content-Type: text/plain; charset=UTF-8

id: null
```

### demo3

```
$ http http://localhost:8080/demo3/abc/123
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 14
Content-Type: text/plain; charset=UTF-8

route: /demo3/*/123
```

```
$ http http://localhost:8080/demo3/abc
HTTP/1.1 404 Not Found
Connection: keep-alive
Content-Length: 0
```

### demo4

```
$ http http://localhost:8080/demo4
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 19
Content-Type: text/plain; charset=UTF-8

route: /demo4/{...}
```

```
http http://localhost:8080/demo4/111
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 19
Content-Type: text/plain; charset=UTF-8

route: /demo4/{...}
```

```
$ http http://localhost:8080/demo4/111/222
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 19
Content-Type: text/plain; charset=UTF-8

route: /demo4/{...}
```

### demo5

```
$ http http://localhost:8080/demo5/111/222
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 16
Content-Type: text/plain; charset=UTF-8

tail: [111, 222]
```