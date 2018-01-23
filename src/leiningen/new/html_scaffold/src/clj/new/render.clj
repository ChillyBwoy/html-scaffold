(ns {{ns-name}}.render
  (:require [clojure.java.io :as io]
            [{{ns-name}}.app :as app]
            [{{ns-name}}.data :as data]))


(def context (data/create-context {:title "Boo"
                                   :suffix ".html"}))


(defn get-resource
  [[url _ view]]
  (let [root (.getCanonicalPath (io/file "."))]
    {:what view
     :where (str root "/resources/public" url ".html")}))


(defn -main [& args]
  (let [data (map get-resource (app/routes context))]
    (doseq [obj data]
      (spit (:where obj) (:what obj)))))
