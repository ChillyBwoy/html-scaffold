(ns {{ns-name}}.render
  (:require [clojure.java.io :as io]
            [{{ns-name}}.core :as core]))

(def context {:suffix ".html"})


(defn get-resource
  [[url _ view]]
  (let [root (.getCanonicalPath (io/file "."))]
    {:what view
     :where (str root "/resources/public" url ".html")}))


(defn -main [& args]
  (let [data (map get-resource (core/routes context))]
    (doseq [obj data]
      (spit (:where obj) (:what obj)))))
