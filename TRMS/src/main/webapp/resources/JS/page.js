class Page {
  constructor(url) {
    this.url = 'resources/Views/' + url;
  }

  load() {
    return $.get(this.url).done(res => this.html = res);
  }

  show(el) {
    el.innerHTML = this.html;
  }
}