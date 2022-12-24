# MilkTea

#### 技术栈

- 前端:微信小程序,UI设计使用了[ColorUI组件库](https://github.com/weilanwl/ColorUI)  
- 后端:使用小程序云开发,主要使用了[云函数](https://developers.weixin.qq.com/miniprogram/dev/wxcloud/guide/functions.html)和[云数据库](https://developers.weixin.qq.com/miniprogram/dev/wxcloud/guide/database.html)  
- 插件:  
  1. [Parser](https://github.com/jin-yufeng/Parser)--弥补小程序对富文本标签支持不足问题,方便文章排版
  2. 官方插件--[腾讯位置服务路线规划](https://mp.weixin.qq.com/wxopen/pluginbasicprofile?action=intro&appid=wx50b5593e81dd937a&token=1738923725&lang=zh_CN)
  3. 官方插件--[腾讯位置服务地图选点](https://mp.weixin.qq.com/wxopen/pluginbasicprofile?action=intro&appid=wx76a9a06e5b4e693e&token=1738923725&lang=zh_CN)

#### 路径概述

``` Shell
├─colorui               # colorui组件
├─functions             # 云函数
│  ├─addCollection        # 添加收藏
│  ├─delCollection        # 删除收藏
│  ├─getCollection        # 获取收藏
│  ├─getOpenid            # 获取openid
│  └─ifExists             # 判断是否已收藏
├─images                # 存放部分图片(主要图片存放在云DB)  
├─libs                  # 引入第三方插件(Parser)
├─pages                 # 页面
│  ├─base                 # 实际的tabbar,负责切换并渲染不同组件页面
│  ├─caculator            # 能量计算组件
│  │  ├─brand               # 品牌选择
│  │  ├─collection          # 收藏页
│  │  │  └─item               # 收藏详情
│  │  ├─home                # 组件首页
│  │  ├─menu                # 配料选择
│  │  └─result              # DIY结果
│  ├─me                   # 个人页面组件
│  │  ├─about               # 大创相关
│  │  ├─home                # 组件首页
│  │  └─log                 # 开发日志
│  ├─nearby               # 附加探店页面
│  ├─tips                 # 营养贴士组件
│  │  ├─BMI                 # BMI计算
│  │  ├─calory              # BMR计算
│  │  ├─curve               # 雷诺矫正曲线
│  │  ├─home                # 组件首页
│  │  ├─list                # 贴士列表 (*目前主要维护部分)
│  │  └─item                # 贴士详情 (*目前主要维护部分)
│  └─welcome              # 小程序首页组件
└─utils

```

#### 参与开发流程

1.  Fork 本仓库
2.  Clone 至本地
3.  本地新建分支(可选),完成开发
4.  提交代码,Push到远程仓库
5.  新建 Pull Request 到主仓库(即该仓库)的dev分支(一定为dev分支)


