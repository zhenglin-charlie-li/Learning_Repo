//获取应用实例
const app = getApp()

Page({
  data: {
    PageCur: 'welcome'
  },
  //事件处理函数
  NavChange(e) {
    this.setData({
      PageCur: e.currentTarget.dataset.cur
    })
  },

  onLoad: function (options) {
    console.log("执行base.onload")
    if(options.PageCur != undefined){
      this.setData({
        PageCur: options.PageCur
      })
    }
  }
})
