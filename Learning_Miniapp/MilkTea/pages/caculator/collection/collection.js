const app = getApp()

Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,

    item: null,
    count: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showLoading({
      title: '加载中...',
      mask: true
    })

    console.log("collection.js->onload()正在执行")
    //获取openid
    if (app.globalData.openid == null) {
      wx.cloud.callFunction({
        name: 'getOpenid',
        complete: res => {
          console.log(res)
          app.globalData.openid = res.result.openid
          this.setData({
            hasOpenid: true,
            openid: app.globalData.openid
          })
          // 回调
          this.getCollection()
        }
      })
    }
    else this.getCollection()
  },

  // 云函数查询数据
  getCollection() {
    wx.cloud.callFunction({
      name: 'getCollection',
      data: {
        openid: app.globalData.openid
      },
      success: res => {
        console.log(res)
        this.setData({
          resultList: res.result,
          count: res.result.length
        })
        // 加载完毕，回调关闭loading
        wx.hideLoading()
      },
      fail: console.error
    })
  },

  // 搭配详情
  goToItem(e) {
    var index = e.currentTarget.dataset.index
    var item = JSON.stringify(this.data.resultList[index])
    console.log("goToItem():", item)

    wx.navigateTo({
      url: './item/item?item=' + item,
    })
  },
  // 删除收藏
  deleteItem(e) {
    var _id = e.currentTarget.dataset._id
    wx.cloud.callFunction({
      name: 'delCollection',
      data: {
        _id: _id
      },
      success: res => {
        this.onLoad()
      }
    })
  }



})