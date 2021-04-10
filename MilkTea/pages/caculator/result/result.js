// pages/caculator/result/result.js
const app = getApp()

Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,

    userInfo: null,
    openid: null,
    hasUserInfo: false,
    existence: false,

    brand_cur: "",
    brand_url: "",
    bodyList: [],
    ingreList: [],
    sugarBodyEnergy: 0,
    ingreEnergy: 0,
    totalEnergy: 0,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      brand_cur: options.brand_cur,
      brand_url: options.brand_url,
      bodyList: JSON.parse(options.bodyList),
      ingreList: JSON.parse(options.ingreList),
      sugarBodyEnergy: options.sugarBodyEnergy,
      ingreEnergy: options.ingreEnergy,
      totalEnergy: options.totalEnergy,
      hasUserInfo: app.globalData.hasUserInfo
    })
    // 只有登陆状态时判断是否收藏
    if (this.data.hasUserInfo)
      this.ifExists()
  },

  //搭配是否收藏
  ifExists() {
    wx.cloud.callFunction({
      name: 'ifExists',
      data: {
        openid: app.globalData.openid,
        brand_id: this.data.brand_cur,
        bodyList: this.data.bodyList
      },
      success: res => {
        console.log(res)
        if (res.result != 0) {
          this.setData({
            existence: true
          })
          return true
        }
        else return false
      },
      fail: console.error
    })
  },


  // 获取用户信息,保存搭配
  collect(e) {
    if (this.data.hasUserInfo) {
      wx.cloud.callFunction({
        name: "addCollection",
        data: {
          openid: app.globalData.openid,
          brand_id: this.data.brand_cur,
          brand_url: this.data.brand_url,
          bodyList: this.data.bodyList,
          ingreList: this.data.ingreList,
          sugarBodyEnergy: this.data.sugarBodyEnergy,
          ingreEnergy: this.data.ingreEnergy,
          totalEnergy: this.data.totalEnergy,
        },
        success: res => {
          console.log(res)
          this.setData({
            existence: true
          })
        },
        fail: console.error
      })
    }
  },

  // 授权获取userInfo和openid
  login(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    app.globalData.hasUserInfo = true
    wx.cloud.callFunction({
      name: 'getOpenid',
      complete: res => {
        console.log(res)
        app.globalData.openid = res.result.openid
        this.setData({
          userInfo: app.globalData.userInfo,
          openid: app.globalData.openid,
          hasUserInfo: true
        })
      }
    })
    // 登录后判断是否收藏
    this.ifExists()
  },

  // 返回首页
  backToWelcome(e) {
    wx.reLaunch({
      url: '../../base/base',
    })
  }



})