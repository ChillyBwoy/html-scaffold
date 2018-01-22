(ns {{ns-name}}.core
  (:require [{{ns-name}}.layout :as layout]
            [{{ns-name}}.views.index :as index]
            [{{ns-name}}.views.main :as main]))

(defn routes
  [context]
  (let [page (partial layout/base context)]
    [["/html/index" [] (page (index/view (conj context {:stylesheet "index"})))]
     ["/html/main"  [] (page (main/view (conj context {:stylesheet "main"})))]]))
