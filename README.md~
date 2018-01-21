#### mvn执行
mvn install 执行后生成jar包  
java -jar girl-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
1. springboot 安装  通过idea自动生成springboot项目
使用spring boot jpa  mysql
2. spring boot 配置
#### 属性配置
@Value 来实现配置文件的注入  
@Component 来实现配置文件的分组  
@ConfigurationProperties来实现配置文件的分组 
3. spring boot使用
#### Controller的使用  

@Controller 处理http请求 ,使用模板时可以使用 
@RestController Spring4之后新加的注解,原来返回JSON需要@ResponseBody配置@Controller,RestController等同于@Controller+@ResponseBody  
@RequestMapping 配置url映射

@Controller 模板使用需要配置官方的spring-boot-starter-thymeleaf  
要通过web方式访问要添加RestController注释,RestController等同于@Controller+@ResponseBody

@RequestMapping 注释:
如果想配置多个url来访问这个页面,可以写成一个集合,@RequestMapping 可以给整个类设置一个url  
类配置url `@RequestMapping(value = "/base")`  
方法上配置url`@RequestMapping(value ={"/hello","/hi"}, method = RequestMethod.GET)` 

#### 如何处理url中的参数
@PathVariable 获取url中的数据  
```
//  如果想配置多个url来访问这个页面,可以写成一个集合,@RequestMapping 可以给整个类设置一个url
     @RequestMapping(value ={"/hello/{id}","/{id}/hi"}, method = RequestMethod.GET)
 //    参数可以写在url的后面也可以写在前面,PathVariable的注解使用方法
     public String Say(@PathVariable("id") Integer id) {
         return "id:" + id;
     }
```
@RequestParam 获取请求参数的值  ,get.post都可以使用这个方式获取值
```
http://localhost:8081/girl/base/hello?id=111
url后面跟?id=100这样的参数使用,可以设置默认值,不设置会输出null
   @RequestMapping(value ={"/hello","/hi"}, method = RequestMethod.GET)
//    参数可以写在url的后面也可以写在前面,RequestParam的注解使用方法
//    required 是否必传,defaultValue默认值
    public String Say(@RequestParam(value="id",required=false,defaultValue = "0") Integer id) {
        return "id:" + id;
    }
```
@Get Mapping 组合注解   

Spring-Data-Jpa(JPA)定义了一系列对象持久化的标准,目前实现这一规范的产品有Hibernate\TopLink等  
1. Spring Jpa生成数据库表的方法 @Entity创建一个实体类,标注@Entity方法的类就是一个数据库持久层的类
2. @Id 数据库主键  @GeneratedValue @GeneratedValue:主键的产生策略
3. 需要写一个接口继承jpa方法,接口是interface, JpaRepository有很多方法 
`public interface GirlRepository extends JpaRepository<Girl, Integer> {
      List<Girl> findByAge(Integer age);
 }`
 4. jpa的配置有create\update\none等,常用的就是update,create是创建如果有数据就会删掉
 `jpa:
      hibernate:
        ddl-auto: update
      show-sql: true`
RESTful APi设计
请求类型 请求路径 功能

```spring:
   profiles:
     active: dev
   datasource:
     driver-class-name: com.mysql.jdbc.Driver
     url: jdbc:mysql://127.0.0.1:3306/dbgirl
     username: root
     password:
   jpa:
     hibernate:
       ddl-auto: create // dll-auto 有5中方法,常用的有update,create,
     show-sql: true
```
#### @Transactional 事物处理写在service中
* Service控制
* @Transactional 事物控制,如果两天数据有一条失败.另一条也不插入
* 只有查询的时候不需要加事物
 
 
 #### web进阶
 1. 使用@Valid表单验证,防填写错误,防黑客
 2. 使用AOP处理请求 , 非常强大 非常实用
 3. 统一异常处理
 4. 单元测试 有责任心的开发都应该写单元测试
 
 第一 
 1. 拦截所有未满18岁的
 ```java
        /*
       * 当一个对象属性特别多的时候,参数传一个对象,从对象里获取属性
         */
        @PostMapping(value ="/girls")
         public Girl girlAdd(Girl girl){
    //        给函数传一个对象,从对象里获取属性
            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
            return girlRepository.save(girl);
        }
        
首先把单个的属性换成对象,当有很多属性的时候只需要往对象里面添加
```
```java
//首先把单个的属性换成对象,当有很多属性的时候只需要往对象里面添加  
//@Valid 表单验证,后面有参数BindingResult bindingResult,然后做判断
//Controller 类
 public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
}
//Entity实体类 在需要验证的属性前面添加@Min标注,并给出值
public class Girl {
    @Min(value = 18, message = "未成年禁止入内")
    private Integer age;
}
```
2. AOP统一处理请求日志
AOP是一种变成范式,与语言无关,是一种程序设计思想  
面向切面(AOP) Aspect Oriented programming (.)  
面向对象(OOP) Object Oriented Programming (Java C++ C#)  
面向过程(POP) Procedure Oriented Programming(C语言)  
面向对象到面向过程 换个角度看世界,换个姿势处理问题  
AOP可以统一实现一些经常调用的通用方法
- 使用AOP第一步添加依赖  
- 第二部 添加处理文件,创建Aspect类,引入@Aspect @Component标注 
-  第三部 实现具体代码
  ```java
    //   使用spring boot 自带的log方法import org.slf4j.Logger;
        private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);
    
        // 在Pointcut中添加要拦截的方法,如果要拦截整个类直接后面跟上*就可以
        @Pointcut(" execution(public * com.example.Controller.GirlController.girlList(..))")
        public void log() {
        }
    //    Before是在执行前执行,调用log()方法
        @Before("log()")
        public void doBefore() {
            logger.info("11111");
        }
        // After是在执行后处理的
        @After("log()")
        public void doAfter(){
            logger.info("2222222222");
        }
```
使用统一日志格式 选择springboot自带的日志工具类org.slf4j.Logger;  
 `private final static Logger logger = LoggerFactory.getLogger(GirlController.class);`
 
 获取httprequest的数据和response的数据方法
 ````java
        @Before("log()")
        public void doBefore(JoinPoint joinPoint) {
    //        记录请求的 url method IP 类方法 参数
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //获取url
            logger.info("url={}", request.getRequestURI());
            //获取method
            logger.info("method={}", request.getMethod());
            //获取ip
            logger.info("IP={}", request.getRemoteAddr());
            //获取类方法
            logger.info("Class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            //获取参数
            logger.info("args={}", joinPoint.getArgs());
        }
        // After是在执行后处理的,
        @After("log()")
        public void doAfter(){
            logger.info("2222222222");
        }
    //    获取返回的内容,传一个object对象.现在实体中添加一个toString方法 ,在把对象调用toString方法
        @AfterReturning(returning = "object", pointcut = "log()")
        public void doAfterReturning(Object object) {
            logger.info("response={}", object.toString());
        }
 ```
 统一异常处理,返回格式要统一
 