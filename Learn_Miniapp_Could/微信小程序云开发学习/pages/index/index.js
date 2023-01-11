const DB = wx.cloud.database().collection("list")
let name = ''
let age = ''
let id = ''
let nameDelete = ''
let updateID = ''
let updateValue = ''

Page({
  addName(event) {
    //console.log(event.detail.value)
    name = event.detail.value
  },

  addAge(event) {
    //console.log(event.detail.value)
    age = event.detail.value
  },

  delDataInputID(event) {
    //console.log(event.detail.value)
    id = event.detail.value
  },

  delDataInputName(event) {
    //console.log(event.detail.value)
    nameDelete = event.detail.value
  },

  updateID(event) {
    console.log(event.detail.value)
    updateID = event.detail.value
  },

  updateValue(event) {
    console.log(event.detail.value)
    updateValue = event.detail.value
  },


  addData() {
    console.log('调用添加数据的方法')
    DB.add({
      data: {
        name: name,
        age: age
      },
      success(res) {
        console.log("添加数据成功", res)
      },
      fail(res) {
        console.log("添加数据失败", res)
      }
    })
  },

  getData() {
    console.log('调用查询数据的方法')
    DB.get({
      success(res) {
        console.log('查询数据成功', res.data)
      },
      fail(res) {
        console.log("查询数据失败", res)
      }
    })
  },

  delDataByID() {
    console.log('调用ID删除数据的方法')
    DB.doc(id).remove({
      success(res) {
        console.log('删除数据成功', res.data)
      },
      fail(res) {
        console.log("删除数据失败", res)
      }
    })
  },

  delDataByProperty() {
    console.log('调用属性删除数据的方法')
    DB.where({
      name: nameDelete
    }).remove({
      success(res) {
        console.log('删除数据成功', res.data)
      },
      fail(res) {
        console.log("删除数据失败", res)
      }
    })
  },

  updateData() {
    console.log('调用修改更新数据的方法')
    DB.doc(updateID).update({
      data: {
        name: updateValue
      },
      success(res) {
        console.log('修改更新数据成功', res.data)
      },
      fail(res) {
        console.log("修改更新数据失败", res)
      }
    })
  }
})