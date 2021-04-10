// pages/caculator/menu/menu.js
const app = getApp()
const db = wx.cloud.database()

Page({
  data: {
    StatusBar: app.globalData.StatusBar,
    CustomBar: app.globalData.CustomBar,
    Custom: app.globalData.Custom,

    brand_cur: "",
    brand_url: "",

    category: [{
      id: "body",
      name: "主体"
    }, {
      id: "sugar",
      name: "糖量"
    }, {
      id: "cup",
      name: "杯形"
    }, {
      id: "material",
      name: "配料"
    }],
    // 四个list保存数据库取出数据
    bodyList: [],
    ingreList: [],
    sugarList: [],
    cupList: [],
    // bodyName保存不同选择拼凑的主体名
    // ["糖量","杯型","主体"]
    bodyName: ["正常/半糖", "中杯", ""],
    // ingreName保存不同选择拼凑的配料名
    ingreName: [],

    // 半糖每100ml热量
    sugarBase: 0,
    // 不含糖主体每100ml热量
    bodyEnergy: 0,
    // 糖每100ml热量
    sugarEnergy: 0,
    // 含糖主体每100ml热量
    sugarBodyEnergy: 0,
    // 配料每份热量
    ingreEnergy: 0,
    // 总热量
    totalEnergy: 0,
    // 当前糖量和容积(初始无糖)
    curSugar: 0,
    curCup: 0
  },

  onLoad: function (options) {
    wx.showLoading({
      title: '加载中...',
      mask: true
    })

    this.setData({
      brand_url: options.brand_url,
      brand_cur: options.brand_cur,
      brand_name: options.brand_name
    })
    var that = this
    db.collection("material").where({
      brand_id: that.data.brand_cur
    }).get({
      success: function (res) {
        console.log(res.data)
        that.setData({
          bodyList: res.data[0].bodyList,
          sugarList: res.data[0].sugarList,
          cupList: res.data[0].cupList,
          ingreList: res.data[0].ingreList,
          // 初始中杯
          curCup: res.data[0].cupList[0].value
        })
        wx.hideLoading()
      }
    })
  },

  tabSelect(e) {
    this.setData({
      TabCur: e.currentTarget.dataset.id,
      MainCur: e.currentTarget.dataset.id,
      VerticalNavTop: (e.currentTarget.dataset.id - 1) * 50
    })
  },


  VerticalMain(e) {
    let that = this;
    let category = this.data.category;
    let tabHeight = 0;
    if (this.data.load) {
      for (let i = 0; i < category.length; i++) {
        // 查询id=main-category[i].id的节点
        let view = wx.createSelectorQuery().select("#main-" + category[i].id);
        view.fields({
          size: true
        }, data => {
          category[i].top = tabHeight;
          tabHeight = tabHeight + data.height;
          category[i].bottom = tabHeight;
        }).exec();
      }
      that.setData({
        load: false,
        category: category
      })
    }
    let scrollTop = e.detail.scrollTop + 20;
    for (let i = 0; i < category.length; i++) {
      if (scrollTop > category[i].top && scrollTop < category[i].bottom) {
        that.setData({
          VerticalNavTop: (category[i].id - 1) * 50,
          TabCur: category[i].id
        })
        return false
      }
    }
  },
  selectBody(e) {
    console.log(e.detail.value)
    var str = e.detail.value.split("|")
    // 不含糖主体每百ml热量
    var bodyEnergy = parseFloat(str[0])
    var bodyName = this.data.bodyName
    bodyName[2] = str[1]
    // 单计半糖每百ml热量(不含主体,配料等)
    var sugarBase = parseFloat(str[2])
    // 单计"无,半,全糖"每百ml热量 = 糖量*半糖热量
    var sugarEnergy = sugarBase * this.data.curSugar
    // 含糖主体热量
    var sugarBodyEnergy = (bodyEnergy + sugarEnergy) * this.data.curCup
    // 总热量
    var totalEnergy = sugarBodyEnergy + this.data.ingreEnergy

    this.setData({
      bodyEnergy: bodyEnergy,
      sugarBase: sugarBase,
      sugarEnergy: sugarEnergy,
      sugarBodyEnergy: Math.floor(sugarBodyEnergy),
      totalEnergy: Math.floor(totalEnergy),
      bodyName: bodyName
    })
    console.log("selectBody():", bodyEnergy, this.data.totalEnergy, this.data.bodyName)
  },

  selectSugar(e) {
    var str = e.detail.value.split("|")
    // 糖量
    var curSugar = parseFloat(str[0])
    // 单计无,半,全糖每百ml热量 = 糖量*半糖热量
    var sugarEnergy = this.data.sugarBase * curSugar
    // 保存名称
    var bodyName = this.data.bodyName
    bodyName[0] = str[1]
    // 含糖主体热量
    var sugarBodyEnergy = (this.data.bodyEnergy + sugarEnergy) * this.data.curCup
    // 总热量
    var totalEnergy = sugarBodyEnergy + this.data.ingreEnergy

    this.setData({
      curSugar: curSugar,
      sugarEnergy: sugarEnergy,
      sugarBodyEnergy: Math.floor(sugarBodyEnergy),
      totalEnergy: Math.floor(totalEnergy),
      bodyName: bodyName
    })
  },

  selectCup(e) {
    var str = e.detail.value.split("|")
    var curCup = parseFloat(str[0])
    // 保存名称
    var bodyName = this.data.bodyName
    bodyName[1] = str[1]

    // 含糖主体热量
    var sugarBodyEnergy = (this.data.bodyEnergy + this.data.sugarEnergy) * curCup
    // 总热量
    var totalEnergy = sugarBodyEnergy + this.data.ingreEnergy

    this.setData({
      curCup: curCup,
      sugarBodyEnergy: Math.floor(sugarBodyEnergy),
      totalEnergy: Math.floor(totalEnergy),
      bodyName: bodyName
    })


  },

  selectIngre(e) {
    var ingreEnergy = 0
    var ingreName = []
    console.log(e.detail.value)

    for (let i in e.detail.value) {
      var str = e.detail.value[i].split("|")
      ingreEnergy += parseInt(str[0])
      ingreName.push(str[1])
    }
    console.log("ingreName:", ingreName)


    var totalEnergy = this.data.sugarBodyEnergy + ingreEnergy
    this.setData({
      ingreEnergy: Math.floor(ingreEnergy),
      totalEnergy: Math.floor(totalEnergy),
      ingreName: ingreName
    })
  },
  // 结果生成
  generate(e) {
    var bodyList = JSON.stringify(this.data.bodyName)
    var ingreList = JSON.stringify(this.data.ingreName)
    console.log("generate():", bodyList)

    wx.navigateTo({
      url: '../result/result?brand_cur=' + this.data.brand_cur +
        '&brand_url=' + this.data.brand_url +
        '&bodyList=' + bodyList +
        '&ingreList=' + ingreList +
        '&sugarBodyEnergy=' + this.data.sugarBodyEnergy +
        '&ingreEnergy=' + this.data.ingreEnergy +
        '&totalEnergy=' + this.data.totalEnergy
    })
  }
})