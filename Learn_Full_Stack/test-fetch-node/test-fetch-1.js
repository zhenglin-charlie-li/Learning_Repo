import fetch from 'node-fetch';
import writeFile from 'fs/promises';

var result111;

fetch(
  'https://www.bing.com/search?q=url%3Ahttps%3A%2F%2Fmag.wcoomd.org%2Ffr%2F%3Fs%3D购买迷情药犯法么【购买网址ghb7.com】【想做爱的药，氰化鉀，催情香水，麻药，昏睡葯，口香糖药《出售网址ghb7.com》买卖出售各类春药迷药】哪里可以买到真的&qs=n&form=QBRE&=Search %7B0%7D for %7B1%7D&=Search work for %7B0%7D&=%25eManage Your Search History%25E&msbsrank=11_14_Bookmark_2&sp=-1&pq=url%3A&sc=15-4&sk=&cvid=8D5FDE108BA0439C9B615118AAA4F182&ghsh=0&ghacc=0&ghpl=&format=pbxml'
)
  .then((result) => {
    result111 = result.text();
  })
  .catch((e) => console.log(e));

console.log(result111);

try {
  const content = result111;
  writeFile(
    'D:\\Documents\\Projects\\Learning_Repo\\Learn_Full_Stack\\test-fetch-node\\result111.txt',
    content
  );
} catch (err) {
  console.log(err);
}
