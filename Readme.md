### 此处记录学习过程中遇到的问题
-   首次运行报错
- >java: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
  > 
  >该异常为lombok版本兼容异常，修改pom文件properties标签中版本号解决
  > 
