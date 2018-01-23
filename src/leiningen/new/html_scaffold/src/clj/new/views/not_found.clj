(ns {{ns-name}}.views.not-found
  (:require [{{ns-name}}.utils.dom :refer [annotate]]
            [{{ns-name}}.core :as core]
            [{{ns-name}}.layout :as layout]
            [{{ns-name}}.components.page :as page]))


(defn- renderer [context]
  (reify core/IView
    (css    [self] ["vendor" "style"])
    (js     [self] [])
    (render [self _]
      (page/view nil
        [:h1 {} "404"]))))


(defn view
  [context]
  (layout/base (renderer context) context))
