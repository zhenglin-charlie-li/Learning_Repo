Component({
  options: {
    addGlobalClass: true,
  },
  data: {
    elements: [
      {
        title: 'BMI测算',
        name: 'BMI',
        color: 'olive',
        icon: 'favor',
        url: '../tips/BMI/BMI'
      },
      {
        title: '每日热量',
        name: 'calory',
        color: 'red',
        icon: 'hotfill',
        url: '../tips/calory/calory'
      }
    ],
  }
})