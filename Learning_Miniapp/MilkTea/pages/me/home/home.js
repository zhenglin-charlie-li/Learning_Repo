// pages/me/home/home.js
var app = getApp();

Component({
  options: {
    addGlobalClass: true,
  },

  data: {
    hasUserInfo: null,
    userInfo: null,
    openid: null
  },

  lifetimes:{
    attached(){
      var that = this
      var times = setInterval(function () {
        if (app.globalData.hasUserInfo != null) {
          // 数据有效
          console.log('me/home开始setData()')
          that.setData({
            hasUserInfo: app.globalData.hasUserInfo,
            userInfo: app.globalData.userInfo
          })
          if (that.data.hasUserInfo) {
            that.setData({
              modalName: null//有userinfo后无需弹窗
            })
          } else {
            that.setData({
              modalName: 'Modal' //无userinfo需弹窗
            })
          }
          clearInterval(times)
          console.log("setInterval结束")
        }
      }, 500)
    }
  },


  methods: {
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
            hasUserInfo: true,
            modalName: null
          })
          console.log(this.data.userInfo + '' + this.data.hasUserInfo)
        }
      })
    },
    hideModal(e) {
      wx.reLaunch({
        url: './base?PageCur=welcome'
      }) 
    }
  },



})