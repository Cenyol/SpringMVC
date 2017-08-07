#### Aspect(切面)
在软件开发中，散布于应用中多出的功能被称为横切关注点(cross-cutting concern)。这些横切关注点可以被模块化为特殊的类，这些类被称为切面(Aspect)。也就是说，一个切面就是我们说的日志啊，安全啊，审计啊之类的模块化功能，它们都可以在系统的任何一个地方用到，但是这些功能又不是某个地方具体逻辑代码所应该关注的。

#### Advice(通知)
通知趸船了切面是什么以及何时使用。除了描述切面要完成的工作之外，通知还解决了何时执行这个工作的问题。其实吧，我认为把通知称为功能、方法、method更加合适，只不过这个method具有时间属性，用来表明何时被执行。

#### Pointcut(切点)
切点定义了通知(method)要在那几处进行执行，可以有一处、两处甚至多处。

#### Join Point(连接点)
上面说的一处两处的处，就是这边的连接点。我觉得这个和hook有点像，就是钩子，之前在开发web服务的时候，总是会出现一些hook，在特定的点会执行特定的hook。


### 注意
- 需要两个依赖：spring-aspects和aspectjweaver。见：https://www.mkyong.com/spring/classnotfoundexception-org-aspectj-weaver-reflect-reflectionworldreflectionworldexception/

- 需要注意aspectjweaver版本与jdk的对应关系。我用的是jdk1.8，用了aspectjweaver1.5的时候会抛出错误：error at ::0 can't find referenced pointcut performance。把aspectjweaver改成1.8.x的就好了。见：http://www.cnblogs.com/xing901022/p/4267563.html

