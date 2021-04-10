// pages/tips/list/list.js
Page({
  data: {
    tipList1: [{
      title: '多糖/少糖是否有意义 🍬',
      index: '0'
    },
    {
      title: '奶茶是否真的含"奶" 🥛',
      index: '1'
    },
    {
      title: '奶茶中的咖啡因 ☕',
      index: '2'
    },
    {
      title: '奶青,奶绿! 细数奶茶浇头 🍵',
      index: '3'
    },
    {
      title: '不同人群喝奶茶情况 👴',
      index: '4'
    }
    ],
    tipList2: [{
      title: '奶茶饮用科普👩‍🏫',
      index: '5'
    }, {
      title: '雷诺校正曲线📈',
      index: '6'
    }]
  },


  goToItem(e) {
    console.log(e.currentTarget.dataset.index)
    console.log(e.currentTarget.dataset.title)

    wx.navigateTo({
      url: '../item/item?index=' + e.currentTarget.dataset.index +
        '&title=' + JSON.stringify(e.currentTarget.dataset.title) +
        '&brand=""'
    })
  },

  goToCurve() {
    wx.navigateTo({
      url: '../curve/curve'
    })
  }
})