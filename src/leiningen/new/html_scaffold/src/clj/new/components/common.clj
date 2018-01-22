(ns {{ns-name}}.components.common
  (:require [{{ns-name}}.utils.dom :refer [annotate]]))


(defn picture
  "Picture component"
  [{:keys [src alt class]}]
  (annotate "Picture"
    (let [chunks (clojure.string/split src #"\.")
          name (clojure.string/join "." (butlast chunks))
          ext (last chunks)
          src-2x (str name "@2x." ext)
          srcset (str src-2x " 2x, " src " 1x")]
      [:img {:alt alt
             :src src
             :class class
             :srcset srcset}])))
