// 云函数入口文件
const cloud = require('wx-server-sdk')
cloud.init()
const db = cloud.database()

// 云函数入口函数
exports.main = async (event, context) => {
  return await db.collection('collection').where({
    openid: event.openid,
    bodyList: event.bodyList
  }).count().then(res => {
    return res.total
  })
}