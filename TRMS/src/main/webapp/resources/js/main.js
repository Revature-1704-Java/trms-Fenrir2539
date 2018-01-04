const r = new Router (
    {
      '#default': new Page('login.html'),
      home: new Layout(new Page('menu.html'), new Page('createReim.html')),
    },
    document.querySelector('main')
  );