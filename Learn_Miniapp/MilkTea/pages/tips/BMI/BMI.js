// pages/tips/BMI/BMI.js
Page({
  data: {
    height: null,
    weight: null,
    BMI: null,
    textColor: null,
    advice: null
  },

  onLoad: function (options) {
  },

  getBMI(e){
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    var height = parseFloat(e.detail.value.height)/100
    var weight = parseFloat(e.detail.value.weight)
    var BMI = Math.floor(weight/(height*height)*100/100)

    var textColor
    var advice
    if(BMI <= 18.4) {
      textColor='grey'
      advice = "体重偏瘦,可以少来两杯奶茶,但一定要注意膳食均衡,加强营养!"
      }
    else if (BMI <= 23.9) {
      textColor = 'green'
      advice = "很标准,偶尔的奶茶没有影响"
      }
    else if (BMI <= 27.9) {
      textColor = 'orange'
      advice = "偏重啦,放下手中的奶茶,加强运动"
      }
    else {
      textColor = 'red'
      advice = "体重超标严重,一定要戒掉奶茶,请咨询医师获取专业减重建议"
      }
    this.setData({
      BMI: BMI,
      textColor: textColor,
      advice: advice
    })
  },

  cleanBMI(e){
    console.log('form发生了reset事件，携带数据为：', e.detail.value)
    this.setData({
      BMI: null,
      textColor: null,
      advice: null
    })
  }

})