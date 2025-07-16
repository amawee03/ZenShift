const NAME = 'toast';
const DATA_KEY = 'bs.toast';
const EVENT_KEY = `.${DATA_KEY}`;
const CLASS_NAME_FADE = 'fade';
const CLASS_NAME_SHOW = 'show';

const Default = {
  animation: true,
  autohide: true,
  delay: 5000
};

class Toast {
  constructor(element, config) {
    this._element = element;
    this._config = this._getConfig(config);
    this._timeout = null;
    this._init();
  }

  show() {
    const showEvent = new Event('show.bs.toast');
    this._element.dispatchEvent(showEvent);

    if (showEvent.defaultPrevented) {
      return;
    }

    this._element.classList.add(CLASS_NAME_SHOW);

    const complete = () => {
      this._element.classList.remove(CLASS_NAME_SHOW);
      const hiddenEvent = new Event('hidden.bs.toast');
      this._element.dispatchEvent(hiddenEvent);
    };

    setTimeout(() => {
      this.hide();
    }, this._config.delay);

    setTimeout(complete, 300); // fade duration
  }

  hide() {
    this._element.classList.remove(CLASS_NAME_SHOW);
  }

  _getConfig(config) {
    return {
      ...Default,
      ...(typeof config === 'object' ? config : {})
    };
  }

  _init() {
    this._element.addEventListener('click', () => {
      clearTimeout(this._timeout);
    });
  }

  static get NAME() {
    return NAME;
  }
}

// Example usage
document.querySelectorAll('.toast').forEach(toastEl => {
  const toast = new Toast(toastEl, { autohide: true, delay: 3000 });
  toast.show();
});