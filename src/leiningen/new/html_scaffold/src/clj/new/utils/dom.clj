(ns {{ns-name}}.utils.dom)

(defn- class-name-pred [stack [name pred]]
  (let [resolved? (if (fn? pred)
                    (pred)
                    pred)]
    (if resolved?
      (conj stack name)
      stack)))


(defn class-names [& pairs]
  (let [data (reduce class-name-pred [] pairs)]
    (clojure.string/join " " data)))


(defn annotate
  "Component wrapper with description"
  ([name body]
   (list
     (str "\n\n<!-- " name " -->\n")
     body
     (str "\n<!-- /" name " -->\n\n")))
  ([name description body]
   (list
    (str
      "\n\n<!-- "
      name
      (when description
        ": " description)
      " -->\n")
    body
    (str "\n<!-- /" name " -->\n\n"))))
