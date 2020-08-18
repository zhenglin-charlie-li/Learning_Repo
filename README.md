# learning-miniapp-couldDevelopment
微信小程序和后台交互扫盲：https://www.bilibili.com/video/BV1jt411E7au

云开发：https://www.bilibili.com/video/BV1pE411C7Ca?from=search&seid=14303234966957086491

云开发学习代码： D:\code is here\微信小程序云开发学习

https://github.com/ZhengLin-Li/learning-miniapp-coulddevelopment

云开发配置的环境：cloud-learning


# 云开发环境初始化准备

## 需要：

APPID

## 操作：

1. 在创建项目时，填入APPID并选择不使用云函数
2. 进入到开发者页面，点击左上角的云开发并选择开通
3. 设置云开发环境名称，可以任意填写
4. 在`project.config.json`中加入字段`"cloudfunctionRoot":"cloud"`
5. 在打开的云开发控制台中点击设置，新建一个环境ID
6. `app.js`中删除所有代码，只保留`env`即环境ID

```
App({
  onLaunch: function () {
    //云开发环境初始化
    wx.cloud.init({
      env:"cloud-learning-i44qm"
    })
  }
})
```

![在project.config.json中加入字段"cloudfunctionRoot":"cloud"](https://img-blog.csdnimg.cn/20200817153256182.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![app.js中删除所有代码，只保留](https://img-blog.csdnimg.cn/20200817153332529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

6. 在根目录下创建文件夹（目录）`cloud`


# 云数据库

## 新增固定的数据

效果：通过点击一个按键可以向云数据库中新增固定字段的内容

实现：

1. 在`index.wxml`中，加入如下代码

```
<button bindtap="addData">新增数据</button>
```

2. 点击云开发-->数据库-->创建集合`testlist`
3. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("testlist")
Page({
  addData(){
    console.log('调用添加数据的方法')
    DB.add({
      data:{
        name:'panda bear',
        price:9999
      },
      success(res) {
        console.log("成功", res)
      },
      fail(res) {
        console.log("失败", res)
      }
    })
  }
})
```

测试：点击新增数据按钮，发现控制台上有相应输出，再进入到云开发的数据库页面，发现上述字段已新增



## 新增用户输入的不确定数据

效果：用户通过输入想新增的数据并点击确定新增按键，即可向云数据库中新增用户想新增的数据

实现：

1. 在`index.wxml`中加入如下代码

```
<input placeholder="输入名字" bindinput="addName"></input>
<text>\n</text>
<input placeholder="输入年龄" bindinput="addAge"></input>
<text>\n</text>
<button bindtap="addData" type="primary">新增数据</button>
```

2. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("list")
let name = ''
let age = ''

Page({
  addName(event){
    //console.log(event.detail.value)
    name = event.detail.value
  },

  addAge(event){
    //console.log(event.detail.value)
    age = event.detail.value
  },

  addData() {
    console.log('调用添加数据的方法')
    DB.add({
      data: {
        name: name,
        age: age
      },
      success(res) {
        console.log("添加数据成功", res)
      },
      fail(res) {
        console.log("添加数据失败", res)
      }
    })
  }
})
```

测试：输入数据后，点击新增数据按钮，发现控制台上有相应输出，再进入到云开发的数据库页面，发现输入的字段已新增

![输入数据后，点击新增数据按钮](https://img-blog.csdnimg.cn/20200817153642239.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![控制台上有相应输出](https://img-blog.csdnimg.cn/2020081715371567.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![再进入到云开发的数据库页面，发现输入的字段已新增](https://img-blog.csdnimg.cn/20200817153801918.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)


## 查找已有的数据

效果：通过点击一个按键可以查询云数据库中的内容

实现：

1. 在`index.wxml`中，加入如下代码

```
<button bindtap="getData">查询数据</button>
```

3. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("testlist")
Page({
  getData() {
    console.log('调用查询数据的方法')
    DB.get({
      success(res){
        console.log('查询数据成功',res)
      }
    })
  }
})
```

测试：点击查询数据按钮，发现控制台上有相应输出

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pLmxvbGkubmV0LzIwMjAvMDgvMTcvTkdIVHpBcVhjeXcyTXJuLnBuZw?x-oss-process=image/format,png)



## 通过ID删除数据

效果：用户通过输入想删除数据的ID并点击确定删除按键，即可删除云数据库中用户想删除的数据

实现：

1. 在`index.wxml`中加入如下代码

```
<input placeholder="要删除数据的ID" bindinput="delDataInput"></input>
<text>\n</text>
<button bindtap="delData" type="primary">删除数据</button>
```

2. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("list")
let id = ''

Page({
  delDataInput(event){
    //console.log(event.detail.value)
    id = event.detail.value
  },

  delData() {
    console.log('调用删除数据的方法')
    DB.doc(id).remove({
      success(res) {
        console.log('删除数据成功', res.data)
      }
    })
  }
})
```

测试：输入想删除数据的ID后（注意不要带有引号""），点击确定删除按键，发现控制台上有相应输出，再进入到云开发的数据库页面，发现输入id对应的该条数据已删除
![删除前](https://img-blog.csdnimg.cn/20200817154308889.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![删除后](https://img-blog.csdnimg.cn/20200817154330814.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 通过属性删除数据

效果：用户通过输入想删除数据的name的值并点击确定删除按键，即可删除云数据库中用户想删除的数据

实现：

1. 在`index.wxml`中加入如下代码

```
<input placeholder="输入要删除数据的name" bindinput="delDataInputName"></input>
<text>\n</text>
<button bindtap="delDataByProperty" type="primary">通过属性删除</button>
```

2. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("list")
let nameDelete = ''

Page({
  delDataInputName(event){
    //console.log(event.detail.value)
    nameDelete = event.detail.value
  },
  
  delDataByProperty() {
    console.log('调用属性删除数据的方法')
    DB.where({
      name: nameDelete
    }).remove({
      success(res) {
        console.log('删除数据成功', res.data)
      },
      fail(res) {
        console.log("删除数据失败", res)
      }
    })
  }
})
```

测试：输入想删除数据的name的值后（注意不要带有引号""），点击确定删除按键，发现控制台上有相应输出，再进入到云开发的数据库页面，发现输入的想删除数据的name的值对应的该条数据已删除
![删除前](https://img-blog.csdnimg.cn/20200817154708242.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![删除后](https://img-blog.csdnimg.cn/20200817154729966.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
另：
如果`name`为`abcd`的有多个数据，则全部name为abcd的数据都会被删除，如下图：
![全部name为abcd的数据都会被删除](https://img-blog.csdnimg.cn/20200817155152692.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 修改更新数据

更新有两个，updata和set，分别为：
update：局部更新一个或多个记录
set：替换更新一个记录
此处演示update

效果：用户通过输入数据ID以及修改后的name的值并点击修改更新数据按键，即可修改更新数据云数据库中用户想修改更新数据的数据

实现：

1. 在`index.wxml`中加入如下代码

```
<input placeholder="输入要更新的数据的ID" bindinput="updateID"></input>
<input placeholder="输入更新后的name的值" bindinput="updateValue"></input>
<button bindtap="updateData" type="primary">修改更新数据</button>
```

2. 在`index.js`中加入如下代码

```
const DB = wx.cloud.database().collection("list")
let updateID = ''
let updateValue = ''

Page({
  updateID(event) {
    console.log(event.detail.value)
    updateID = event.detail.value
  },

  updateValue(event) {
    console.log(event.detail.value)
    updateValue = event.detail.value
  },
  
  updateData() {
    console.log('调用修改更新数据的方法')
    DB.doc(updateID).update({
      data: {
        name: updateValue
      },
      success(res) {
        console.log('修改更新数据成功', res.data)
      },
      fail(res) {
        console.log("修改更新数据失败", res)
      }
    })
  }
})
```

测试：输入数据ID以及修改后的name的值并点击修改更新数据按键，发现控制台上有相应输出，再进入到云开发的数据库页面，数据已修改更新
![修改更新数据前](https://img-blog.csdnimg.cn/20200817164257555.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![修改更新数据后](https://img-blog.csdnimg.cn/20200817164315864.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

# 小程序云开发数据库的增删改查已经全部完成！


# 一、创建一个云开发的小程序

## 1. 如下图所示创建小程序

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818084851626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 2. 删除无关文件

删除前：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020081808502252.png#pic_center)
删除后：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818085156316.png#pic_center)

## 3. 删除无关代码

`index.wxml` `index.wxss` 内的代码全部清空，`index.js`保留如下：

```index.js
Page({

})
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818085442731.png#pic_center)
`app.json`删除无关代码，如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818085748146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 4. 配置云函数存储目录

在`project.config.json`中新增如下代码

```
"cloudfunctionRoot":"cloud",
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818085851769.png#pic_center)
在根目录下创建同名文件夹，发现其有云朵标识
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818085949202.png#pic_center)

## 5. 云开发环境初始化

点击云开发—>设置，复制你的环境ID
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818090314311.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
在`app.js`中，删除所有代码，并新增如下：

```
App({
  onLaunch: function () {
    wx.cloud.init({
      env:"cloud-learning-i44qm"//你的环境ID
    })
  }
})
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818092006170.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 6. 创建并上传一个云函数

我们以最简单的求和函数为例
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818092045766.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
输入`add`并回车
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818092133669.png#pic_center)
在上图的`index.js`中改变代码如下：

```
// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()

// 云函数入口函数
exports.main = async (event, context) => {
  let a = event.a;
  let b = event.b;
  return a+b;
}
```

写完代码后，记得 Ctrl+s 保存，然后点击如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818092500381.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
出现下图，则上传成功![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818092523660.png#pic_center)

## 7. 使用云函数

以下皆在page下的index页面操作
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818093124592.png#pic_center)
`index.wxml`中

```
<button bindtap="getSum">云函数的求和运算</button>
```

`index.js`中

```
Page({
  getSum() {
    wx.cloud.callFunction({
      name:"add",
      data:{
        a:5,
        b:6
      },
      success(res){
        console.log("请求成功！", res)
      },
      fail(res){
        console.log("请求失败！",res)
      }
    })
  }
})
```

8. 测试云函数调用是否成功
   ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818093350787.png#pic_center)

## 8. 进阶测试

 `index.wxml`中

```
<input bindinput="handleInput1" placeholder="数字1"></input>
<input bindinput="handleInput2" placeholder="数字2"></input>
<button bindtap="getSum">云函数的求和运算</button>
```

`index.js`中

```
let a = 0
let b = 0

Page({
  handleInput1(event) {
    //console.log(event.detail.value)
    a = event.detail.value
  },

  handleInput2(event) {
    //console.log(event.detail.value)
    b = event.detail.value
  },

  getSum() {
    wx.cloud.callFunction({
      name: "add",
      data: {
        a: a - '',
        b: b - ''
      },
      success(res) {
        console.log("请求成功！", res)
      },
      fail(res) {
        console.log("请求失败！", res)
      }
    })
  }
})
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818094114663.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020081809405454.png#pic_center)

# 二、使用云函数获取用户openid

## 1. 创建一个新的页面`getopenid`

如下图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818095349654.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 2. 创建云函数`getopenid`

里面的代码不用改动，使用默认的就可以
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818095617698.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 3. `getopenid.wxml`

```
<button bindtap="getopenid">getopenid</button>
```

## 4. `getopenid.js`

```
Page({
  onLoad(){
    wx.cloud.callFunction({
      name:"getopenid",
      data:{

      },
      success(res) {
        console.log("获取openid成功！", res)
        console.log("openid是：", res.result.openid)
      },
      fail(res) {
        console.log("获取openid失败！", res)
      }
    })
  }
})
```

## 5. 测试

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818095738693.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

# 二、通过云数据库API获取云数据库数据

## 1. 新建测试数据

在云数据库中随便新建几条数据![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818101955175.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 2. 新建测试页面

新建页面`cloudfunctionVSdatabaseAPI`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818101632569.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 3. 创建测试按键

`cloudfunctionVSdatabaseAPI.wxml`中

```
<button bindtap="shujuku">数据库API获取数据</button>
```

`cloudfunctionVSdatabaseAPI.js`中

```
Page({
  shujuku(){
    wx.cloud.database().collection("pk").get({
      success(res) {
        console.log("数据库API获取数据成功！", res)
      },
      fail(res) {
        console.log("数据库API获取数据失败！", res)
      }
    })
  }
})
```

## 4. 测试

点击按键`数据库API获取数据`，发现控制台如下输出：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818103343412.png#pic_center)
此时，我们发现数据库中明明有数据但通过数据库API获取不到，为什么呢？
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818103445206.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
原因是权限不够，如果我们更新权限，让所有用户都可以获取，会怎么样呢？
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818103554484.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818103609591.png#pic_center)

## 5. 结论

可以看到，我们现在获取到了想要的数据，我们也发现了通过数据库API获取数据的局限性。

# 三、通过云函数获取云数据库数据

## 1. 云数据库就可以直接获取数据库里的数据，为什么这么做？

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818100024885.png#pic_center)

## 2. 说明

本例延续上例中的`cloudfunctionVSdatabaseAPI`页面

## 3. 创建云函数

利用上述方法创建云函数`cloudfunctionVSdatabaseAPI`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818104300955.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
云函数`cloudfunctionVSdatabaseAPI.js`中的代码：

```
// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()

// 云函数入口函数
exports.main = async (event, context) => {
  return cloud.database().collection("pk").get();
}
```

记得上传并部署，注意这里没有`wx.`
云函数调用：`cloud.database().collection("pk").get();`
本地调用：`wx.cloud.database().collection("pk").get();`

## 4. 创建测试按键

`cloudfunctionVSdatabaseAPI.wxml`中

```
<button bindtap="shujuku">数据库API获取数据</button>
<button bindtap="yunhanshu">云函数获取数据</button>
```

`cloudfunctionVSdatabaseAPI.js`中

```
Page({
  shujuku(){
    wx.cloud.database().collection("pk").get({
      success(res) {
        console.log("数据库API获取数据成功！", res)
      },
      fail(res) {
        console.log("数据库API获取数据失败！", res)
      }
    })
  },
  yunhanshu(){
    wx.cloud.callFunction({
      name:"cloudfunctionVSdatabaseAPI",
      success(res) {
        console.log("云函数获取数据成功！", res)
      },
      fail(res) {
        console.log("云函数获取数据失败！", res)
      }
    })
  }
})
```

## 5. 测试

首先更改云数据库的权限为仅创建者可读写
![](https://img-blog.csdnimg.cn/20200818105244679.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)
点击两个按键
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818105303589.png#pic_center)
控制台输出如下：同样的，数据库API不可以获取到数据，而云函数可以
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818105333789.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

## 6. 注意事项

如果你的云开发有多套环境，在初始化时应指明，如下：
在下图文件中![在这里插入图片描述](https://img-blog.csdnimg.cn/20200818105730727.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1BhbmRhMzI1,size_16,color_FFFFFF,t_70#pic_center)

```
// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init({
  env: "cloud-learning-i44qm"
})

// 云函数入口函数
exports.main = async (event, context) => {
  return cloud.database().collection("pk").get();
}
```

## 7. 云函数调用数据库的应用

短信发送，邮件发送，复杂数据运算
