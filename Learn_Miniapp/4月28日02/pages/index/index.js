// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  getTaskByTime :function (){
    this.setData({
      activeMoney: '',
      activeget1: '',
      activeget2: '',
      activeTime: 'filter-active'
    })
  },
  getTaskByMoney: function () {
    this.setData({
      activeTime: '',
      activeget1: '',
      activeget2: '',
      activeMoney: 'filter-active'
    })
  },
  getTask1: function () {
    this.setData({
      activeTime: '',
      activeMoney: '',
      activeget2: '',
      activeget1: 'filter-active'
    })
  },
  getTask2: function () {
    this.setData({
      activeTime: '',
      activeget1: '',
      activeMoney: '',
      activeget2: 'filter-active'
    })
  },
  toRelease: function () {
    console.log("这里有待完善")
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      activeType: '',
      activeTime: 'filter-active',
      activeMoney: '',
      activeget1: '',
      activeget2: '',
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.onLoad();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})