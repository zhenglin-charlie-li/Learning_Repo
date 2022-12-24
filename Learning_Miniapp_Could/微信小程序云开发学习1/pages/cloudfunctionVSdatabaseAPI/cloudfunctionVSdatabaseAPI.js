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