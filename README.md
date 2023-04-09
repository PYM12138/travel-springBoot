# Travel-SpringBoot
## 项目介绍
- 对技术框架的一次整合运用练习
- 如何把所学的知识运用在实际的开发中
- 记录开发过程中的一些问题和解决方法
- 是我第一次单独开发一个较完整的项目的过程
## 项目演示
### 首页
![index](https://user-images.githubusercontent.com/39949028/230712511-0cf1c551-5d4c-4afc-8844-1983373117c7.png)
### 登录
![127 0 0 1_login html](https://user-images.githubusercontent.com/39949028/230712582-1c2865a1-6cc6-4193-a9be-23a87079b371.png)
### 注册
![127 0 0 1_register html](https://user-images.githubusercontent.com/39949028/230712588-da7ad0a0-fcca-4370-95d1-d11f654d9fe4.png)
### 搜索
![127 0 0 1_search_searchContent=BBE5B1](https://user-images.githubusercontent.com/39949028/230712596-02c98e44-16c9-4250-8b6d-8ab3c8b425b0.png)
### 我的收藏
![127 0 0 1_myfavorite](https://user-images.githubusercontent.com/39949028/230712670-e616a638-a219-4489-9535-d369b6c7832b.png)
### 收藏排行榜
![127 0 0 1_favoriteList](https://user-images.githubusercontent.com/39949028/230712602-1f6e91a7-d486-4114-8886-8a42ad666861.png)
### 国内游
![国内游](https://user-images.githubusercontent.com/39949028/230712608-23fde5ad-68a4-4c58-8b01-38fe0f95c3b8.png)
### 路线详情页
![127 0 0 1_detail_26](https://user-images.githubusercontent.com/39949028/230712613-4b2e8af6-e64d-4746-8c0e-4e581a94d8fb.png)

## 项目背景
学校给的一个javaweb 项目，当时我刚学会了springboot、mybatis等技术框架，技痒，故用了两个星期左右的时间，对这个项目进行底层技术升级，第一次把所学的技术应用在实际开发中，
很好的证明了自己对于技术框架的运用和理解，虽然过程并没有预期的进展顺利，但是还是克服了重重困难，最后做到了。
### 项目需求
- 展示产品
- 项目详情的展示
- 注册登录功能
- 搜索功能
- 分类查询功能
- 个人收藏功能
### 安装部署
- 直接使用springboot自带方式打包
### 项目设计
#### 总体设计
- 本项目用到的技术和框架
  1. 项目构建：Maven
  2. web框架：Springboot
  3. 数据库ORM：Mybatis
  4. 数据库连接池： Druid
  5. 分页插件：PageHelper
  6. 数据库：MySql
  7. 前端模板：Thymeleaf
  8. 前端框架：BootStrap
 - 一些关键点
  1. 第一次尝试用邮箱来实现注册验证功能
  2. 验证码采用redis来进行缓存（功能所需，直接使用，并不熟悉详情）
 - 环境 
    -  开发工具 IDEA
    - jdk1.8
    - Mysql 5.5
    - 项目框架 SpringBoot + MyBatis 
## 结构图
![未命名文件](https://user-images.githubusercontent.com/39949028/230790328-7a966022-7cb2-42e5-90be-d9e1e56f559b.jpg)

## 开发流程
- controller层中编写前端接口，接收前端参数
- service层中编写所需业务接口，供controller层调用
- 实现service层中的接口，并注入dao层中的sql接口
- 采用Mybatis的JavaConfig方式编写Sql语句。由于并没有使用Mybatis的逆向功能，需要自己手写所有sql语句
## 总结
### 开发中遇到的难点
- 第一次独立开发一个较完整的项目，过程比较磕磕绊绊，总体思路是有的，但是实现起来也并不是很容易。
- 在登录注册功能实现的时候，需要考虑前后端方面的验证，比较复杂。
- 在开发后期，对一些前端页面的内容复用性进行了思考，比如分页条就是进行抽象之后可以通用了。
### 整体项目的评价
只是实现了页面的一些基础功能，并没有很强的健壮性，小bug较多，由于只是一个练习项目，自己也不打算再去深究，这次是为接下来的博客项目做前期的准备。
