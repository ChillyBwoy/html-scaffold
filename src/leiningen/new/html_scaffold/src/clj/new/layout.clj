(ns {{ns-name}}.layout
  (:use [hiccup.page :only (html5 include-css include-js)])
  (:require [{{ns-name}}.utils.dom :refer [annotate]]))


(defn- meta-content
  "Meta tag helper"
  [args]
  (clojure.string/join
    ", "
    (map #(str (-> % first name) "=" (last %)) args)))


(defn- page-head
  "Page head section"
  [{:keys [title stylesheet]
    :or {title "{{ns-name}}"}}]
  (let [meta-viewport {:width "device-width"
                       :initial-scale "1.0"
                       :minimum-scale "1.0"}]
    (list
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible"
              :content (meta-content {:IE "edge"})}]
      [:meta {:name "viewport"
              :content (meta-content meta-viewport)}]
      (include-css "../css/views/vendor.css")
      (when stylesheet
        (include-css (str "../css/views/" stylesheet ".css")))
      [:title title])))


(defn- page-layout
  "Page layout"
  [context & children]
  [:div.page
    (annotate "Header"
      [:header.page__header
        [:h1 "{{ns-name}}"]])
    (annotate "Content"
      [:div {:class "page__content"
             :role "main"}
            children])
    (annotate "Footer"
      [:footer.page__footer])])


(defn- page-js
  "JS"
  []
  (list
    (include-js "../js/main.js")
    (include-js "../js/bundles/app.dev.js")))


(defn base
  "Base layout"
  ([props content]
   (html5 {:lang "ru"}
     [:head
       (page-head props)]
     [:body
       (page-layout props content)
       (page-js)])))
