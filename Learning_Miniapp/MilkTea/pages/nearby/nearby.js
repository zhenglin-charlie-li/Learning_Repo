const chooseLocation = requirePlugin('chooseLocation')

Page({
  data: {
    key: 'CA6BZ-YCE6P-6UID3-VW24L-ADCY7-SABOA',
    referer: 'MilkTea',
    location: JSON.stringify({
      latitude: 39.89631551,
      longitude: 116.323459711
    }),
  },

  onLoad() {
    console.log("执行onload()")
    var that = this
    wx.getLocation({
      type: 'gcj02',
      success(res) {
        var location = JSON.stringify({
          latitude: res.latitude,
          longitude: res.longitude
        })
        console.log(location)
        that.setData({
          location: location
        })
        wx.navigateTo({
          url: `plugin://chooseLocation/index?key=${that.data.key}&referer=${that.data.referer}&location=${that.data.location}`
        })
      }
    })
  },
  onShow() {
    var location = chooseLocation.getLocation(); // 如果点击确认选点按钮，则返回选点结果对象，否则返回null
    console.log("onShow(): location = " + location)

    var endPoint = null

    if (location != null) {
      endPoint = JSON.stringify({ //终点
        'name': location.address,
        'latitude': location.latitude,
        'longitude': location.longitude
      })
      console.log("onShow(): endPoint = " + endPoint)
      this.routeNavi(endPoint)
    }
    // while (location != null) {
    //   endPoint = JSON.stringify({ //终点
    //     'name': location.address,
    //     'latitude': location.latitude,
    //     'longitude': location.longitude
    //   })
    //   console.log("endPoint: " + endPoint)
    //   this.routeNavi(endPoint)
    //   break;
    // }
  },

  routeNavi(endPoint) {
    var that = this
    wx.redirectTo({
      url: 'plugin://routePlan/index?key=' + that.data.key + '&referer=' + that.data.referer + '&endPoint=' + endPoint
    })
  }
})