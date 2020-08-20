const DB = wx.cloud.database().collection("pyq")
Page({
  data: {
    array: []
  },
  onLoad() {
    let that = this
    DB.get({
      success(res) {
        that.setData({
          array: res.data
        })
        for (let i = 0; i < res.data.length; i++) {
          console.log(res.data[i].descption)
          console.log(res.data[i].imgURL)
        }
      }
    })
  }
})