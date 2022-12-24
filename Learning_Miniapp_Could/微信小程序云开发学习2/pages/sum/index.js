let input = 0
let first = 0
let second = 0
Page({
  data: {
    number: 999
  },
  handleInput(e) {
    //console.log(e)
    first = e.detail.value - ''
  },
  handleInput1(e) {
    //console.log(e)
    second = e.detail.value - ''
  },
  handleTap() {
    var that = this
    console.log(first)
    console.log(second)
    wx.cloud.callFunction({
      name: "add",
      data: {
        a: first,
        b: second
      },
      success(res) {
        console.log("请求成功！", res)
        that.setData({
          number:res.result
        })
      },
      fail(res) {
        console.log("请求失败！", res)
      }
    })
  }
})