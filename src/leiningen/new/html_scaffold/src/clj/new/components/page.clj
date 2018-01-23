(ns {{ns-name}}.components.page
  (:require [{{ns-name}}.utils.dom :refer [annotate]]))


(defn view
  "Page layout"
  [props & children]
  (annotate "Page"
    [:div.page
      (annotate "Page header"
        [:header.page__header
          [:h1 "boo"]])
      (annotate "Page content"
        [:div {:class "page__content" :role "main"} children])
      (annotate "Page footer"
        [:footer.page__footer])]))
