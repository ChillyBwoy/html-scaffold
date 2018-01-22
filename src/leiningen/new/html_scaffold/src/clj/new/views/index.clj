(ns {{ns-name}}.views.index
  (:require [{{ns-name}}.utils.dom :refer [annotate]]))


(defn view [{:keys [suffix]
             :or {suffix ""}
             :as context}]
  (annotate "Index view"
    (let [get-url (fn [u] (str u suffix))]
      [:h2 "{{ns-name}}"]
      [:ol
        [:li [:a {:href (get-url "../html/main")} "Main"]]])))
