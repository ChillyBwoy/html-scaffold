(ns {{ns-name}}.views.index
  (:require [{{ns-name}}.utils.dom :refer [annotate]]
            [{{ns-name}}.core :as core]
            [{{ns-name}}.layout :as layout]
            [{{ns-name}}.components.page :as page]))


(defn- renderer [context]
  (reify core/IView
    (css    [self] ["vendor" "style" "main"])
    (js     [self] ["main"])
    (render [self {:keys [get-url]}]
      (page/view nil
        [:h1 "Test"]
        [:h2 "Pages"
          [:ol
            [:li [:a {:href (get-url "main")} "Main"]]]]))))


(defn view
  [context]
  (layout/base (renderer context) context))
