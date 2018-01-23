(ns {{ns-name}}.layout
  (:use [hiccup.page :only (html5 include-css include-js)])
  (:require [{{ns-name}}.utils.dom :refer [annotate]]
            [{{ns-name}}.utils.helpers :refer [create-helpers]]))


(defn- layout-meta-content
  "Meta tag helper"
  [args]
  (clojure.string/join
    ", "
    (map #(str (-> % first name) "=" (last %)) args)))


(defn base
  "Base layout"
  [view context]
  (let [stylesheets (map #(str "../css/" % ".css") (.css view))
        javascripts (map #(str "../js/" % ".js") (.js view))
        helpers (create-helpers context)]
    (html5 {:lang "ru"}
      [:head
        [:meta {:charset "utf-8"}]
        [:meta {:http-equiv "X-UA-Compatible"
                :content (layout-meta-content {:IE "edge"})}]
        [:meta {:name "viewport"
                :content (layout-meta-content {:width "device-width"
                                               :initial-scale "1.0"
                                               :minimum-scale "1.0"})}]
        [:title (:title context)]
        (apply include-css stylesheets)]
      [:body
        (.render view helpers)
        (apply include-js javascripts)])))
