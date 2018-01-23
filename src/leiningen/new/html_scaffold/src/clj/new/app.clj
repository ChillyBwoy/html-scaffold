(ns {{ns-name}}.app
  (:require [{{ns-name}}.views.index :as index]))


(defn routes
  [{:keys [prefix] :as context}]
  (let [r (fn [x] (str "/" prefix "/" x))]
    [[(r "index") [] (index/view context)]]))
