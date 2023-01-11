// pages/tips/calory/calory.js
Page({

  data: {
    activityList:[
      {
        num:1.2,
        text:"久坐的工作方式;极少运动"
      },
      {
        num:1.4,
        text:"工作有时走动或者站立;轻微运动(1-3D/W)"
      },
      {
        num:1.6,
        text:"工作中经常走动或者站立;适中运动(3-5D/W)"
      },
      {
        num:1.8,
        text:"工作中有较多的体力劳动;较多运动(6-7D/W)"
      },
      {
        num: 2.0,
        text: "工作中有很大的体力劳动;大量运动(2次/D)"
      }
    ],
    BMR: null,
    calory: null
  },

  
  onLoad: function (options) {

  },

  getBMR(e){
    console.log("触发getBMR():",e.detail.value)
    var activity = parseFloat(e.detail.value.activity)
    var gender = e.detail.value.gender
    var height = parseFloat(e.detail.value.height)
    var weight = parseFloat(e.detail.value.weight)
    var age = parseInt(e.detail.value.age)

    var BMR = 0
    var calory = 0

    //公式来自美国运动医学协会
    if(gender=='man'){
      BMR = (13.75*weight)+(5*height)-(6.76*age) + 66
      calory = BMR * activity
    }else{
      BMR = (9.56 * weight) + (1.85 * height) - (4.68 * age) + 655
      calory = BMR * activity
    }
    console.log("BMR和每日耗能为:", BMR, calory)
    this.setData({
      BMR: BMR.toFixed(2),
      calory: calory.toFixed(2)
    })
  },

  cleanBMR(e){
    console.log('form发生了reset事件，携带数据为：', e.detail.value)
    this.setData({
      BMR: null,
      calory: null
    })

  }

  
})