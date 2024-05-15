### 此处记录学习过程中遇到的问题
-   首次运行报错
- >java: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
  > 
  >该异常为lombok版本兼容异常，修改pom文件properties标签中版本号解决
  > 
-   公共字段自动填充
- > 1、自定义注解 @AutoFill，指定作用方法类型  
  > 2、自定义切面类AutoFillAspect，统一拦截加了 @AutoFill的方法  
  > 3、Mapper方法加上 @AutoFill  