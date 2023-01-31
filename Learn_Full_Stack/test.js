const {DOMParser} = require('@xmldom/xmldom')
const fetch = require('electron-fetch').default
// import fetch from 'electron-fetch';

const url = ''
async function parseURL(url) {
    let xmlString = await fetch(url).then(r => r.text());
    let startString = '"Url" : "';
    let endString = '"DisplayUrl" : "';
    let startIndex = xmlString.lastIndexOf(startString);
    let endIndex = xmlString.lastIndexOf(endString);
    let urlKeyValue = xmlString.substring(startIndex, endIndex);
    let resultUrl = urlKeyValue.substring(urlKeyValue.lastIndexOf(startString) + startString.length, urlKeyValue.lastIndexOf('"'))
    console.log(resultUrl)
}

parseURL(url)
