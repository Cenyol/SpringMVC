### 三种bean自动装配技术

#### 推荐：自动发现配置
使用@ComponentScan和@Component两个注解配合。其中@ComponentScan注解可以通过指定包名来扫描特定包下面带有@Component注解的类，这时候Spring会自动创建这个bean类，并加到bean容器中，以备之后进行注入。

#### 通过JavaConfig来实现
使用@Configuration和@Bean两个注解进行配合。在配置文件，如CDPlayerConfig里面。这种方式有个优点就是可以随心所欲，自己写代码创建需要的bean。

#### 通过xml文件
最常见，最古老的bean装配技术。具体见本项目的测试代码：com.cenyol.example.model.autowire.CDPlayerTest和resources/config-beans.xml