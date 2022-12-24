// pages/caculator/collection/item/item.js
const app = getApp()

Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,

    item: null
  },

  onLoad: function (options) {
    this.setData({
      item: JSON.parse(options.item)
    })
  },

  // 返回首页
  backToWelcome(e) {
    wx.reLaunch({
      url: '../../../base/base',
    })
  },
  // 返回上页
  backToLast(e) {
    wx.navigateBack({
      delta: 1
    })
  }
  
})