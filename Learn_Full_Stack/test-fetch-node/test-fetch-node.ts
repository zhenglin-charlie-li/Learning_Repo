import fetch from 'node-fetch';

fetch('https://facebook.com')
  .then((result) => result.text())
  .then((textformat) => console.log(textformat))
  .catch((e) => console.log(e));

console.log('a');
