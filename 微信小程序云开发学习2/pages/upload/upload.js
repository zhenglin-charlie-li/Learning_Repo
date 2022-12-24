Page({
  data: {
    imgURL:''
  },
  selectAndUpload() {
    let that = this
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: res => {
        console.log('choose successfully',res)
        wx.cloud.uploadFile({
          cloudPath: new Date().getTime() + '.png',
          filePath: res.tempFilePaths[0], // 文件路径
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
      },
      fail(res) {
        console.log('choose failed', res)
      }
    })
  },
})