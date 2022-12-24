const app = getApp()
const db = wx.cloud.database()
Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,
    brandList: [],
    brand_url:"",
    brand_cur:"",
    brand_name:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("brand.js->onload()正在执行")
    wx.showLoading({
      title: '加载中...',
      mask: true
    })

    var that = this
    db.collection("brand").get({
      success: function(res){
        console.log(res.data)
        that.setData({
          brandList: res.data
        })
        wx.hideLoading()
      }
    })
    
  },


  selectBrand(e){
    this.setData({
      brand_url: e.currentTarget.dataset.brand_url,
      brand_cur: e.currentTarget.dataset.brand_id,
      brand_name: e.currentTarget.dataset.brand_name
    }),
    wx.navigateTo({
      url: '../menu/menu?brand_cur='+this.data.brand_cur
        + '&brand_url=' + this.data.brand_url
      + '&brand_name='+this.data.brand_name
    })
  }
})