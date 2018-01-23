(ns {{ns-name}}.core)

(defprotocol IView
  (css    [_])
  (js     [_])
  (render [_ helpers]))
