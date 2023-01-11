const DB = wx.cloud.database().collection("pyq")
Page({
  data: {
    details: '',
    imgURL: ''
  },
  bindTextAreaBlur: function (e) {
    console.log(e.detail.value);
    var that = this;
    that.setData({
      details: e.detail.value
    });
  },
  seleteAndUploadPicture() {
    let that = this
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: res => {
        console.log('choose successfully', res)
        that.setData({
          imgURL: res.tempFilePaths[0]
        })
      },
      fail(res) {
        console.log('choose failed', res)
      }
    })
  },
  share() {
    console.log('调用share的方法')
    let that = this
    wx.cloud.uploadFile({
      cloudPath: new Date().getTime() + '.png',
      filePath: this.data.imgURL, // 文件路径
      success: function (res) {
        console.log('upload successfully', res)
        that.setData({
          imgURL: res.fileID
        })
      },
      fail(res) {
        console.log('upload failed', res)
      }
    })
    DB.add({
      data: {
        descption: this.data.details,
        imgURL: this.data.imgURL
      },
      success(res) {
        console.log("share成功", res)
        wx.navigateTo({
          url: "../../pages/pyq/pyq"
        })
        wx.showToast({
          title: '成功',
          icon: 'success',
          duration: 2000
        })
      },
      fail(res) {
        console.log("share失败", res)
      }
    })
  }
})