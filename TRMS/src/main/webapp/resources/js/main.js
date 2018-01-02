const r = new Router (
    {
      '#default': new Page('createReim.html'),
      home: new Layout(new Page('menu.html'), new Page('login.html')),
      about: new Layout(new Page('menu.html'), new Page('login.html')),
    },
    document.querySelector('main')
  );