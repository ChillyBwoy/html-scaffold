(ns {{ns-name}}.views.main
  (:require [{{ns-name}}.utils.dom :refer [class-names annotate]]))

(defn view
  "Main view"
  [context]
  (annotate "Main view"
    [:div {:class (class-names
                    ["main" true]
                    ["main_foo" (> 5 10)])}
          "Write your code here..."]))
