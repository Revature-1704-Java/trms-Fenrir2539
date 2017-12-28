const r = new Router (
    {
      '#default': new Page('login.html'),
      home: new Layout(new Page('menu.html'), new Page('login.html')),
      about: new Layout(new Page('menu.html'), new Page('login.html')),
    },
    document.querySelector('main')
  );