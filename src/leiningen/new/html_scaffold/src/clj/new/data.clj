(ns {{ns-name}}.data)

(defn create-context
  ([] (create-context {}))
  ([context]
   (conj {:title "Boo"
          :prefix "html"
          :suffix ""} context)))
