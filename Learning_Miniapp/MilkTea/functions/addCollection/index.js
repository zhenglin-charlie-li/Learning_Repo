// 云函数入口文件
const cloud = require('wx-server-sdk')
cloud.init()
const db = cloud.database()

// 云函数入口函数
exports.main = async (event, context) => {
  return await db.collection('collection').add({
    data: {
      openid: event.openid,
      brand_id: event.brand_id,
      brand_url: event.brand_url,
      bodyList: event.bodyList,
      ingreList: event.ingreList,
      sugarBodyEnergy: event.sugarBodyEnergy,
      ingreEnergy: event.ingreEnergy,
      totalEnergy: event.totalEnergy,
    }
  })
}